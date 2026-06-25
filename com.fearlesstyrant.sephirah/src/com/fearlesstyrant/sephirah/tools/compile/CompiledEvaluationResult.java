package com.fearlesstyrant.sephirah.tools.compile;

import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;

public final class CompiledEvaluationResult {

	private final int index;
	private final Expression expression;
	private final SephirahValue value;
	
	public CompiledEvaluationResult(
			int index,
			Expression expression,
			SephirahValue value) {
		this.index = index;
		this.expression = expression;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public Expression getExpression() {
		return expression;
	}

	public SephirahValue getValue() {
		return value;
	}
	
	@Override
    public String toString() {
        return "Evaluation " + index + ": " + value;
    }
}
