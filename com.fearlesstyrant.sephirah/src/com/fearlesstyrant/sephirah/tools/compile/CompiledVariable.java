package com.fearlesstyrant.sephirah.tools.compile;

import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.tools.type.SephirahType;

public final class CompiledVariable {

	private final String name;
	private final Expression expression;
	private final SephirahType type;
	
	public CompiledVariable(
			String name,
			Expression expression,
			SephirahType type) {
		this.name = name;
		this.expression = expression;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Expression getExpression() {
		return expression;
	}

	public SephirahType getType() {
		return type;
	}
}
