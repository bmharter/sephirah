package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

import com.fearlesstyrant.sephirah.sephirah.*;
import com.fearlesstyrant.sephirah.tools.*;

public class SephirahCompiler {

	public CompiledSephirahModule compile(FormulaModel model) {
		if (model == null) {
            throw new IllegalArgumentException("Cannot compile null Sephirah model.");
        }
		
		String name = model.getName() == null
				|| model.getName().getName() == null
				|| model.getName().getName().isBlank()
				? "<anonymous>"
				: model.getName().getName();
		
		 FunctionRegistry baseFunctions = Methods.standardRegistry();

		 MutableFunctionRegistryReference reference =
		            new MutableFunctionRegistryReference(baseFunctions);

		 ModuleValueResolver resolver =
		            new ModuleValueResolver(model, reference::get);
		
		FunctionRegistry functions = compileFunctions(model, baseFunctions, resolver, reference);
		
		reference.set(functions);
		
		EvaluationContext context = new EvaluationContext(
				Collections.emptyMap(),
				resolver);
		
		Map<String, Expression> variables = compileVariables(model);
		List<Expression> expressions = compileEvaluations(model);
		Set<String> definedFunctionNames = compileDefinedFunctionNames(model);
		
		return new CompiledSephirahModule(
				name,
				context,
				functions,
				variables,
				expressions,
				definedFunctionNames);
	}
	
	public CompiledSephirahModuleSet compileAll(
			Collection<FormulaModel> models) {
		List<CompiledSephirahModule> modules = new ArrayList<>();
		
		for(FormulaModel model : models) {
			modules.add(compile(model));
		}
		
		return new CompiledSephirahModuleSet(modules);
	}
	
	private Set<String> compileDefinedFunctionNames(FormulaModel model) {
	    Set<String> names = new LinkedHashSet<>();

	    for (Definition definition : model.getMethodDefs()) {
	        String name = definition.getName();

	        if (name == null || name.isBlank()) {
	            continue;
	        }

	        names.add(name);
	    }

	    return names;
	}
	
	private List<Expression> compileEvaluations(FormulaModel model) {
		List<Expression> results = new ArrayList<>();
		
		for(Evaluation evaluation : model.getValues()) {
			if(evaluation.getExpression() == null) {
				continue;
			}
			
			results.add(evaluation.getExpression());
		}
		
		return results;
	}
	
	private FunctionRegistry compileFunctions(
			FormulaModel model,
			FunctionRegistry baseFunctions,
			ModuleValueResolver resolver,
			MutableFunctionRegistryReference reference) {
		
		return ModuleFunctionCompiler.compile(model, baseFunctions, resolver, reference);
	}
	
	private Map<String, Expression> compileVariables(FormulaModel model) {
		Map<String, Expression> variables = new LinkedHashMap<>();
		
		for(Assignment assignment : model.getVariables()) {
			if(assignment instanceof VariableAssignment variableAssignment) {
				String variableName = variableAssignment.getName();
				
				if (variableName == null || variableName.isBlank()) {
		            continue;
		        }
				
				variables.put(
						variableName, 
						variableAssignment.getValue());
			}
		}
		
		return variables;
	}
}
