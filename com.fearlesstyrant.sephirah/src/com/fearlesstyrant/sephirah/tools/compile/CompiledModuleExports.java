package com.fearlesstyrant.sephirah.tools.compile;

import java.util.List;

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
}
