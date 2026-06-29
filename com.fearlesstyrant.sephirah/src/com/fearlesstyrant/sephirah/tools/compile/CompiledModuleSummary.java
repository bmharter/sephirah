package com.fearlesstyrant.sephirah.tools.compile;

import java.util.List;

public final class CompiledModuleSummary {

	private final String name;
	private final List<CompiledVariable> variables;
	private final List<CompiledFunction> functions;
	private final int evaluationCount;
	
	public CompiledModuleSummary(
			String name,
			List<CompiledVariable> variables,
			List<CompiledFunction> functions,
			int evaluationCount) {
		this.name = name;
		this.variables = variables;
		this.functions = functions;
		this.evaluationCount = evaluationCount;
	}

	public String getName() {
		return name;
	}

	public List<CompiledVariable> getVariables() {
		return variables;
	}

	public List<CompiledFunction> getFunctions() {
		return functions;
	}

	public int getEvaluationCount() {
		return evaluationCount;
	}
}
