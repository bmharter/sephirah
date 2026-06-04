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
		
		for(Definition definition : model.getMethodDefs()) {
			String name = definition.getName();
			
			if(name == null || name.isBlank()) {
				continue;
			}
			
			if (baseRegistry.contains(name)) {
                throw new IllegalArgumentException(
                        "Function declaration conflicts with built-in function: " + name);
            }
			
			builder.register(name, createFunction(definition, moduleResolver, registryReference));
		}
		
		return builder.build();
	}
	
	private static SephirahFunction createFunction(Definition definition,
			ValueResolver moduleResolver,
			MutableFunctionRegistryReference registryReference) {
		
		return (List<BigDecimal> arguments, EvaluationContext callerContext) -> {
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
		};
	}
}
