package com.fearlesstyrant.sephirah.tools;

import java.util.*;

import org.eclipse.emf.common.util.EList;

import java.math.BigDecimal;

import com.fearlesstyrant.sephirah.sephirah.*;

/**
 * Compiles module-level Sephirah definitions into callable runtime functions.
 */
public final class ModuleFunctionCompiler {

	private ModuleFunctionCompiler() {
		
	}
	
	public static FunctionRegistry compile(
			FormulaModel model,
			FunctionRegistry baseRegistry,
			ValueResolver moduleResolver,
			MutableFunctionRegistryReference registryReference) {
		Objects.requireNonNull(model, "model must not be null");
		Objects.requireNonNull(baseRegistry, "baseRegistry must not be null");
		Objects.requireNonNull(moduleResolver, "moduleResolver must not be null");
		Objects.requireNonNull(registryReference, "registryReference must not be null");
		
		FunctionRegistry.Builder builder = baseRegistry.toBuilder();
		
		ThreadLocal<Deque<String>> callStack =
		        ThreadLocal.withInitial(ArrayDeque::new);
		
		for(Definition definition : model.getMethodDefs()) {
			String name = definition.getName();
			
			if(name == null || name.isBlank()) {
				continue;
			}
			
			if (baseRegistry.contains(name)) {
                throw new IllegalArgumentException(
                        "Function declaration conflicts with built-in function: " + name);
            }
			
			builder.register(name, createFunction(definition,
					moduleResolver,
					registryReference,
					callStack));
		}
		
		return builder.build();
	}
	
	private static SephirahFunction createFunction(Definition definition,
			ValueResolver moduleResolver,
			MutableFunctionRegistryReference registryReference,
			ThreadLocal<Deque<String>> callStack) {
		
		return (List<BigDecimal> arguments, EvaluationContext callerContext) -> {
			String functionName = definition.getName();
			
			if (functionName == null || functionName.isBlank()) {
	            throw new IllegalArgumentException("Cannot invoke unnamed function.");
	        }
			
			Deque<String> stack = callStack.get();
			
			if(stack.contains(functionName)){
				throw new IllegalStateException("Cyclic function invocation: "
	                    + formatFunctionCycle(functionName, stack));
			}
			
			stack.push(functionName);
			
			try {
				EList<Assignment> parameters = definition.getArgs();
				
				if(arguments.size() != parameters.size()) {
					throw new IllegalArgumentException("Function " + definition.getName()
	                + " expects " + parameters.size()
	                + " argument(s), but received " + arguments.size() + ".");
				}
				
				Map<String, BigDecimal> localValues = new HashMap<>();
				
				for(int i = 0; i < parameters.size(); i++) {
					Assignment parameter = parameters.get(i);
					String parameterName = parameter.getName();
					
					if (parameterName == null || parameterName.isBlank()) {
	                    throw new IllegalArgumentException(
	                            "Function " + definition.getName()
	                            + " has an unnamed parameter.");
	                }
					
					localValues.put(parameterName, arguments.get(i));
				}
				
				EvaluationContext localContext = new EvaluationContext(localValues, moduleResolver);
				
				return new Computer(localContext, registryReference.get())
						.evaluate(definition.getExpr());
			} finally {
				stack.pop();
				
				if(stack.isEmpty()) {
					callStack.remove();
				}
			}
		};
	}
	
	private static String formatFunctionCycle(String repeatedName, Deque<String> stack) {
	    List<String> path = new ArrayList<>(stack);
	    Collections.reverse(path);

	    int cycleStart = path.indexOf(repeatedName);

	    StringBuilder builder = new StringBuilder();

	    if (cycleStart >= 0) {
	        for (int i = cycleStart; i < path.size(); i++) {
	            if (builder.length() > 0) {
	                builder.append(" -> ");
	            }

	            builder.append(path.get(i));
	        }

	        builder.append(" -> ").append(repeatedName);
	        return builder.toString();
	    }

	    builder.append(repeatedName);

	    for (String name : path) {
	        builder.append(" -> ").append(name);
	    }

	    builder.append(" -> ").append(repeatedName);

	    return builder.toString();
	}
}
