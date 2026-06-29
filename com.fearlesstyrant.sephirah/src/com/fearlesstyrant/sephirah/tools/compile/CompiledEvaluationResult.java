package com.fearlesstyrant.sephirah.tools.compile;

import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;
import com.fearlesstyrant.sephirah.tools.type.SephirahType;
import com.fearlesstyrant.sephirah.tools.type.SephirahTypeInferencer;

public final class CompiledEvaluationResult {

	private final int index;
	private final Expression expression;
	private final SephirahValue value;
	private final SephirahType type;
	
	public CompiledEvaluationResult(
			int index,
			Expression expression,
			SephirahValue value) {
		this.index = index;
		this.expression = expression;
		this.value = value;
		this.type = SephirahTypeInferencer.inferType(expression);
	}

	public CompiledEvaluationResult(
			int index,
			Expression expression,
			SephirahValue value,
			SephirahType type) {
		this.index = index;
		this.expression = expression;
		this.value = value;
		this.type = type;
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
	
	public SephirahType getType() {
		return type;
	}

	@Override
    public String toString() {
        return "Evaluation " + index + ": " + value;
    }
}
