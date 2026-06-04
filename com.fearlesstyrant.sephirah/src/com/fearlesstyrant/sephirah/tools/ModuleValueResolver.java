package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;

import com.fearlesstyrant.sephirah.sephirah.Assignment;
import com.fearlesstyrant.sephirah.sephirah.FormulaModel;
import com.fearlesstyrant.sephirah.sephirah.VariableAssignment;

/**
 * Resolves module-level Sephirah variable declarations.
 *
 * <p>This resolver treats a Sephirah document as declarative rather than
 * sequential. All variable declarations in the module are collected before
 * evaluation, so a variable may refer to another variable declared later in the
 * source file.</p>
 *
 * <p>Values are evaluated lazily and cached after first resolution. This allows
 * forward references while avoiding repeated computation.</p>
 */
public final class ModuleValueResolver implements ValueResolver {

	private final Map<String, VariableAssignment> declarations;
	private final Map<String, BigDecimal> cache;
	private final Deque<String> resolutionStack;
	private final Supplier<FunctionRegistry> functions;
	    
	 /**
     * Creates a module resolver using Sephirah's standard function registry.
     *
     * @param model Sephirah module/document model
     */
	public ModuleValueResolver(FormulaModel model) {
		this(model, Methods::standardRegistry);
	}
	
	  /**
     * Creates a module resolver using a supplied function registry.
     *
     * @param model Sephirah module/document model
     * @param functions functions available while evaluating variable values
     */
	public ModuleValueResolver(FormulaModel model, FunctionRegistry functions) {
		this(model, () -> functions);
	}
	
	public ModuleValueResolver(FormulaModel model, Supplier<FunctionRegistry> functions) {
		Objects.requireNonNull(model, "model must not be null");
		Objects.requireNonNull(functions, "functions must not be null");
		
		this.declarations = collectDeclarations(model);
		this.cache = new HashMap<>();
		this.resolutionStack = new ArrayDeque<>();
		this.functions = functions;
	}
	
	@Override
	public Optional<BigDecimal> resolveValue(String name) {
		Objects.requireNonNull(name, "name must not be null");
		
		if(cache.containsKey(name)) {
			return Optional.of(cache.get(name));
		}
		
		VariableAssignment declaration = declarations.get(name);
		
		if(declaration == null) {
			return Optional.empty();
		}
		
		if(resolutionStack.contains(name)) {
			throw new IllegalStateException("Cyclic variable definition: "
				+ formatCycle(name));
		}
		
		resolutionStack.push(name);
		
		try {
			EvaluationContext context = new EvaluationContext(Collections.emptyMap(), this);
			
			BigDecimal value = new Computer(context, functions.get())
					.evaluate(declaration.getValue());
			
			cache.put(name, value);
			
			return Optional.of(value);
		} finally {
			resolutionStack.pop();
		}
	}

	 /**
     * Returns true when this module contains a variable declaration with the
     * supplied name.
     *
     * @param name variable name
     * @return true when declared
     */
	public boolean containsDeclaration(String name) {
		Objects.requireNonNull(name, "name must not be null");
		
		return declarations.containsKey(name);
	}
	
	private static Map<String, VariableAssignment> collectDeclarations(FormulaModel model) {
		Map<String, VariableAssignment> collected = new HashMap<>();

		for(Assignment assignment : model.getVariables()) {
			if(!(assignment instanceof VariableAssignment)) {
				continue;
			}
			
			VariableAssignment variableAssignment = (VariableAssignment) assignment;
	        String name = variableAssignment.getName();
	        
	        if(name == null || name.isBlank()) {
	        	continue;
	        }
	        
	        VariableAssignment previous = collected.put(name, variableAssignment);
	        
	        if(previous != null) {
	        	throw new IllegalArgumentException(
	        			"Duplicate variable declaration: " + name);
	        }
		}
		
		return Collections.unmodifiableMap(collected);
	}
	
	private String formatCycle(String repeatedName) {
		List<String> stack = new ArrayList<>(resolutionStack);
	    Collections.reverse(stack);

	    int cycleStart = stack.indexOf(repeatedName);

	    StringBuilder builder = new StringBuilder();

	    if (cycleStart >= 0) {
	        for (int i = cycleStart; i < stack.size(); i++) {
	            if (builder.length() > 0) {
	                builder.append(" -> ");
	            }

	            builder.append(stack.get(i));
	        }

	        builder.append(" -> ").append(repeatedName);
	        return builder.toString();
	    }

	    /*
	     * Defensive fallback. In normal use this should not happen because
	     * formatCycle is only called after resolutionStack.contains(repeatedName).
	     */
	    builder.append(repeatedName);

	    for (String name : stack) {
	        builder.append(" -> ").append(name);
	    }

	    builder.append(" -> ").append(repeatedName);

	    return builder.toString();
	}
}
