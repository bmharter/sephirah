package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

public final class CompiledModuleExports {

	private final List<CompiledVariable> variables;
	private final List<CompiledFunction> functions;
	
	public CompiledModuleExports(
			List<CompiledVariable> variables,
			List<CompiledFunction> functions) {
		this.variables = List.copyOf(variables);
		this.functions = List.copyOf(functions);
	}

	public List<CompiledVariable> getVariables() {
		return variables;
	}

	public List<CompiledFunction> getFunctions() {
		return functions;
	}
	
	public Set<String> getVariableNames() {
	    Set<String> names = new LinkedHashSet<>();

	    for (CompiledVariable variable : variables) {
	        names.add(variable.getName());
	    }

	    return names;
	}

	public Set<String> getFunctionNames() {
	    Set<String> names = new LinkedHashSet<>();

	    for (CompiledFunction function : functions) {
	        names.add(function.getName());
	    }

	    return names;
	}
}
