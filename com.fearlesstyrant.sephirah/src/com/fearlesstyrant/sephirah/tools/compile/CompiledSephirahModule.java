package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;
import java.math.BigDecimal;

import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.tools.*;
import com.fearlesstyrant.sephirah.tools.value.*;

public final class CompiledSephirahModule {

	private final String name;
	private final EvaluationContext context;
	private final FunctionRegistry functions;
	private final Map<String, Expression> variables;
	
	public CompiledSephirahModule(
			String name,
			EvaluationContext context,
			FunctionRegistry functions,
			Map<String, Expression> variables) {
		this.name = name;
		this.context = context;
		this.functions = functions;
		this.variables = Map.copyOf(variables);
	}

	public String getName() {
		return name;
	}
	
	public boolean hasVariable(String name) {
		return variables.containsKey(name);
	}
	
	public SephirahValue evaluateVariable(String name) {
		Expression expression = variables.get(name);
		
		if (expression == null) {
            throw new IllegalArgumentException("Unknown variable: " + name);
        }

        return evaluateExpression(expression);
	}
	
	public BigDecimal evaluateNumberVariable(String name) {
		return SephirahValues.requireNumeric(evaluateVariable(name));
	}
	
	public boolean evaluateBooleanVariable(String name) {
		return SephirahValues.requireBoolean(evaluateVariable(name));
	}
	
	public SephirahValue evaluateExpression(Expression expression) {
        return new Computer(context, functions).evaluateValue(expression);
    }

    public SephirahValue call(String name, List<SephirahValue> arguments) {
        return functions.invoke(name, arguments, context);
    }
    
    public SephirahValue callWithNumbers(String name, BigDecimal... arguments) {
    	return call(
    			name,
    			Arrays.stream(arguments)
    				.<SephirahValue>map(SephirahValues::numeric)
    				.toList());
    }
    
    public SephirahValue callWithNumbers(String name, int... arguments) {
    	return call(
    			name,
    			Arrays.stream(arguments)
    				.mapToObj(BigDecimal::valueOf)
    				.<SephirahValue>map(SephirahValues::numeric)
    				.toList());
    }
    
    public BigDecimal callForNumber(String name, BigDecimal... arguments) {
        return SephirahValues.requireNumeric(callWithNumbers(name, arguments));
    }

    public BigDecimal callForNumber(String name, int... arguments) {
        return SephirahValues.requireNumeric(callWithNumbers(name, arguments));
    }

    public boolean callForBoolean(String name, BigDecimal... arguments) {
        return SephirahValues.requireBoolean(callWithNumbers(name, arguments));
    }

    public boolean callForBoolean(String name, int... arguments) {
        return SephirahValues.requireBoolean(callWithNumbers(name, arguments));
    }
}
