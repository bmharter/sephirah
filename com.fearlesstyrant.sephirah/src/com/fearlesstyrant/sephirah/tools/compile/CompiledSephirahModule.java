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
	private final List<Expression> evaluations;
	
	public CompiledSephirahModule(
			String name,
			EvaluationContext context,
			FunctionRegistry functions,
			Map<String, Expression> variables,
			List<Expression> evaluations) {
		this.name = name;
		this.context = context;
		this.functions = functions;
		this.variables = Map.copyOf(variables);
		this.evaluations = evaluations;
	}

	public String getName() {
		return name;
	}
	
	public int getEvaluationCount() {
		return evaluations.size();
	}
	
	public Set<String> getFunctionNames() {
		return functions.getFunctionNames();
	}
	
	public Set<String> getVariableNames() {
	    return Collections.unmodifiableSet(variables.keySet());
	}
	
	public boolean hasFunction(String name) {
		return functions.contains(name);
	}
	
	public boolean hasVariable(String name) {
		return variables.containsKey(name);
	}
	
	public List<SephirahValue> evaluateAll() {
		List<SephirahValue> results = new ArrayList<>();
		
		for(Expression expression : evaluations) {
			results.add(evaluateExpression(expression));
		}
		
		return results;
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
    
    public SephirahValue callWithBooleans(String name, Boolean... arguments) {
        List<SephirahValue> values = new ArrayList<>();
        
        for(boolean arguement : arguments) {
        	values.add(SephirahValues.bool(arguement));
        }
        
        return call(name, values);
    }
    
    public boolean callForBoolean(String name, Boolean... arguments) {
    	return SephirahValues.requireBoolean(callWithBooleans(name, arguments));
    }
    
    public SephirahValue callWithJavaValues(String name, Object... arguments) {
        List<SephirahValue> values = new ArrayList<>();

        for (Object argument : arguments) {
            values.add(toSephirahValue(argument));
        }

        return call(name, values);
    }

    public BigDecimal callForNumberWithJavaValues(String name, Object... arguments) {
        return SephirahValues.requireNumeric(callWithJavaValues(name, arguments));
    }

    public boolean callForBooleanWithJavaValues(String name, Object... arguments) {
        return SephirahValues.requireBoolean(callWithJavaValues(name, arguments));
    }

    private static SephirahValue toSephirahValue(Object argument) {
        if (argument instanceof SephirahValue value) {
            return value;
        }

        if (argument instanceof BigDecimal value) {
            return SephirahValues.numeric(value);
        }

        if (argument instanceof Integer value) {
            return SephirahValues.numeric(BigDecimal.valueOf(value));
        }

        if (argument instanceof Long value) {
            return SephirahValues.numeric(BigDecimal.valueOf(value));
        }

        if (argument instanceof Double value) {
            return SephirahValues.numeric(BigDecimal.valueOf(value));
        }

        if (argument instanceof Boolean value) {
            return SephirahValues.bool(value);
        }

        throw new IllegalArgumentException(
                "Unsupported Sephirah argument type: "
                        + (argument == null ? "null" : argument.getClass().getName()));
    }
}
