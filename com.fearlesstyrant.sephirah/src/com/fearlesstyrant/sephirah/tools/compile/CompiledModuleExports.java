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
	
	public boolean hasVariable(String name) {
	    return getVariableNames().contains(name);
	}

	public CompiledVariable getVariable(String name) {
	    for (CompiledVariable variable : variables) {
	        if (variable.getName().equals(name)) {
	            return variable;
	        }
	    }

	    throw new IllegalArgumentException("Unknown exported variable: " + name);
	}

	public boolean hasFunction(String name) {
	    return getFunctionNames().contains(name);
	}

	public CompiledFunction getFunction(String name) {
	    for (CompiledFunction function : functions) {
	        if (function.getName().equals(name)) {
	            return function;
	        }
	    }

	    throw new IllegalArgumentException("Unknown exported function: " + name);
	}
}
