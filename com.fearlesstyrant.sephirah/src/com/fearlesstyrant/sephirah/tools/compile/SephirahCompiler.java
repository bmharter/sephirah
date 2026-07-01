package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

import com.fearlesstyrant.sephirah.sephirah.*;
import com.fearlesstyrant.sephirah.tools.*;
import com.fearlesstyrant.sephirah.tools.type.SephirahTypeInferenceContext;

import org.eclipse.xtext.EcoreUtil2;

public class SephirahCompiler {

	public CompiledSephirahModule compile(FormulaModel model) {
		return compile(model, Methods.standardRegistry());
	}
	
	private CompiledSephirahModule compile(
	        FormulaModel model,
	        FunctionRegistry baseFunctions) {
	   return compile(model, baseFunctions, null);
	}
	
	private CompiledSephirahModule compile(
	        FormulaModel model,
	        FunctionRegistry baseFunctions,
	        CompiledSephirahModuleSet importedModules) {
	    if (model == null) {
	        throw new IllegalArgumentException("Cannot compile null Sephirah model.");
	    }

	    String name = getModuleName(model);

	    MutableFunctionRegistryReference reference =
	            new MutableFunctionRegistryReference(baseFunctions);

	    ModuleValueResolver localResolver =
	            new ModuleValueResolver(model, reference::get);

	    ValueResolver resolver = localResolver;

	    if (importedModules != null) {
	        resolver = new ImportAwareValueResolver(
	                localResolver,
	                buildImportedModulesByLocalName(model, importedModules));
	    }

	    SephirahTypeInferenceContext typeContext =
	            buildTypeInferenceContext(model, importedModules);
	    
	    FunctionRegistry functions =
	            compileFunctions(model, baseFunctions, resolver, reference, typeContext);
	    
	    reference.set(functions);

	    EvaluationContext context =
	            new EvaluationContext(Collections.emptyMap(), resolver);

	    Map<String, Expression> variables = compileVariables(model);
	    List<Expression> expressions = compileEvaluations(model);
	    Set<String> definedFunctionNames = compileDefinedFunctionNames(model);
	    List<CompiledImport> imports = compileImports(model);
	    
	    return new CompiledSephirahModule(
	            name,
	            context,
	            functions,
	            variables,
	            expressions,
	            definedFunctionNames,
	            imports,
	            typeContext);
	}
	
	public CompiledSephirahModuleSet compileAll(
			Collection<FormulaModel> models) {
		List<CompiledSephirahModule> firstPassModules = new ArrayList<>();
		
		for(FormulaModel model : models) {
			firstPassModules.add(compile(model));
		}
		
		CompiledSephirahModuleSet firstPassSet = 
				new CompiledSephirahModuleSet(firstPassModules);
		
		for (FormulaModel model : models) {
		    validateImportedSymbolReferences(model, firstPassSet);
		}
		
		List<CompiledSephirahModule> linkedModules = new ArrayList<>();
		
		for(FormulaModel model : models) {
			String moduleName = getModuleName(model);
			
			CompiledSephirahModule firstPassModule =
					firstPassSet.getModule(moduleName);
			
			FunctionRegistry baseFunctions = 
					buildImportAwareBaseRegistry(
							firstPassModule,
							firstPassSet);
			
			linkedModules.add(compile(model, baseFunctions, firstPassSet));
		}
		
		return new CompiledSephirahModuleSet(linkedModules);
	}
	
	private Map<String, CompiledSephirahModule> buildImportedModulesByLocalName(
	        FormulaModel model,
	        CompiledSephirahModuleSet modules) {
	    Map<String, CompiledSephirahModule> results = new HashMap<>();
	    
	    for (CompiledImport imported : compileImports(model)) {
	    	String localName = imported.getLocalName();
	    	
	    	if(results.containsKey(localName)) {
	    		throw new IllegalArgumentException(
	    	            "Module " + getModuleName(model)
	    	            + " has duplicate import local name: "
	    	            + localName);
	    	}
	    	
	        CompiledSephirahModule importedModule =
	                modules.getModule(imported.getModuleName());

	        results.put(localName, importedModule);
	    }

	    return results;
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
			ValueResolver resolver,
			MutableFunctionRegistryReference reference,
			SephirahTypeInferenceContext typeContext) {
		
		return ModuleFunctionCompiler.compile(
				model,
				baseFunctions,
				resolver,
				reference,
				typeContext);
	}
	
	private List<CompiledImport> compileImports(FormulaModel model) {
		List<CompiledImport> results = new ArrayList<>();
		
		for(Import anImport : model.getImports()) {
			String moduleName = anImport.getModule();
			
			if(moduleName == null || moduleName.isBlank()) {
				continue;
			}
			
			results.add(new CompiledImport(anImport.getModule(),
					anImport.getAlias()));
		}
		
		return results;
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
	
	private FunctionRegistry buildImportAwareBaseRegistry(
			CompiledSephirahModule module,
			CompiledSephirahModuleSet modules) {
		FunctionRegistry.Builder builder = 
				Methods.standardRegistry().toBuilder();
		
		for(CompiledImport anImport : module.getImports()) {
			CompiledSephirahModule importedModule =
					modules.getModule(anImport.getModuleName());
			
			String localModuleName = anImport.getLocalName();
			
			for(CompiledFunction function : importedModule.getExports().getFunctions()) {
				registerImportedFunction(
						builder,
						localModuleName,
						importedModule,
						function);
			}
		}
		
		return builder.build();
	}
	
	private SephirahTypeInferenceContext buildTypeInferenceContext(
	        FormulaModel model,
	        CompiledSephirahModuleSet importedModules) {
	    SephirahTypeInferenceContext context =
	            SephirahTypeInferenceContext.empty();

	    if (importedModules == null) {
	        return context;
	    }

	    Map<String, CompiledSephirahModule> importedByLocalName =
	            buildImportedModulesByLocalName(model, importedModules);

	    for (Map.Entry<String, CompiledSephirahModule> entry
	            : importedByLocalName.entrySet()) {
	        String localName = entry.getKey();
	        CompiledSephirahModule importedModule = entry.getValue();

	        for (CompiledVariable variable
	                : importedModule.getExports().getVariables()) {
	            context.registerExternalVariableType(
	                    localName + "." + variable.getName(),
	                    variable.getType());
	        }

	        for (CompiledFunction function
	                : importedModule.getExports().getFunctions()) {
	            context.registerExternalFunctionSignature(
	                    localName + "." + function.getName(),
	                    function.getSignature());
	        }
	    }

	    return context;
	}
	
	private String getModuleName(FormulaModel model) {
	    return model.getName() == null
	            || model.getName().getName() == null
	            || model.getName().getName().isBlank()
	            ? "<anonymous>"
	            : model.getName().getName();
	}
	
	private void registerImportedFunction(
			FunctionRegistry.Builder builder,
			String localModuleName,
			CompiledSephirahModule importedModule,
			CompiledFunction function) {
		String importedFunctionName = localModuleName + "." + function.getName();
		
		builder.register(new RegisteredFunction(
				importedFunctionName,
				function.getSignature(),
				(arguments, context) -> 
					importedModule.call(function.getName(), arguments)));
	}
	
	private void validateImportedSymbolReferences(
	        FormulaModel model,
	        CompiledSephirahModuleSet modules) {
	    Map<String, CompiledSephirahModule> importedByLocalName =
	            buildImportedModulesByLocalName(model, modules);

	    for (Variable variable : EcoreUtil2.getAllContentsOfType(model, Variable.class)) {
	        validateImportedVariableReference(variable, importedByLocalName);
	    }

	    for (MethodCall methodCall : EcoreUtil2.getAllContentsOfType(model, MethodCall.class)) {
	        validateImportedFunctionReference(methodCall, importedByLocalName);
	    }
	}
	
	private void validateImportedFunctionReference(
	        MethodCall methodCall,
	        Map<String, CompiledSephirahModule> importedByLocalName) {
	    String name = methodCall.getName();

	    if (name == null || name.isBlank() || !name.contains(".")) {
	        return;
	    }

	    int dot = name.indexOf('.');
	    String localModuleName = name.substring(0, dot);
	    String functionName = name.substring(dot + 1);

	    CompiledSephirahModule importedModule =
	            importedByLocalName.get(localModuleName);

	    if (importedModule == null) {
	        return;
	    }

	    if (!importedModule.getExports().hasFunction(functionName)) {
	        throw new IllegalArgumentException(
	                "Unknown imported function: " + name);
	    }
	    
	    CompiledFunction importedFunction =
	            importedModule.getExports().getFunction(functionName);

	    FunctionSignature signature =
	            importedFunction.getSignature();

	    int actual = methodCall.getArgs().size();

	    if (!signature.accepts(actual)) {
	        throw new IllegalArgumentException(
	                signature.describeMismatch(name, actual));
	    }
	}
	
	private void validateImportedVariableReference(
	        Variable variable,
	        Map<String, CompiledSephirahModule> importedByLocalName) {
	    String name = variable.getName();

	    if (name == null || name.isBlank() || !name.contains(".")) {
	        return;
	    }

	    int dot = name.indexOf('.');
	    String localModuleName = name.substring(0, dot);
	    String variableName = name.substring(dot + 1);

	    CompiledSephirahModule importedModule =
	            importedByLocalName.get(localModuleName);

	    if (importedModule == null) {
	        return;
	    }

	    if (!importedModule.getExports().hasVariable(variableName)) {
	        throw new IllegalArgumentException(
	                "Unknown imported variable: " + name);
	    }
	}
}
