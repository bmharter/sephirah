package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

import com.fearlesstyrant.sephirah.sephirah.*;
import com.fearlesstyrant.sephirah.tools.*;

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

	    FunctionRegistry functions =
	            compileFunctions(model, baseFunctions, resolver, reference);

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
	            imports);
	}
	
	public CompiledSephirahModuleSet compileAll(
			Collection<FormulaModel> models) {
		List<CompiledSephirahModule> firstPassModules = new ArrayList<>();
		
		for(FormulaModel model : models) {
			firstPassModules.add(compile(model));
		}
		
		CompiledSephirahModuleSet firstPassSet = 
				new CompiledSephirahModuleSet(firstPassModules);
		
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
	        CompiledSephirahModule importedModule =
	                modules.getModule(imported.getModuleName());

	        results.put(imported.getLocalName(), importedModule);
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
			MutableFunctionRegistryReference reference) {
		
		return ModuleFunctionCompiler.compile(model, baseFunctions, resolver, reference);
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
}
