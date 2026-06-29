package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;
import java.math.BigDecimal;

import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.tools.*;
import com.fearlesstyrant.sephirah.tools.type.SephirahType;
import com.fearlesstyrant.sephirah.tools.type.SephirahTypeInferencer;
import com.fearlesstyrant.sephirah.tools.value.*;

public final class CompiledSephirahModule {

	private final String name;
	private final EvaluationContext context;
	private final FunctionRegistry functions;
	private final Map<String, Expression> variables;
	private final List<Expression> evaluations;
	private final Set<String> definedFunctionNames;
	
	public CompiledSephirahModule(
			String name,
			EvaluationContext context,
			FunctionRegistry functions,
			Map<String, Expression> variables,
			List<Expression> evaluations,
			Set<String> definedFunctionNames) {
		this.name = name;
		this.context = context;
		this.functions = functions;
		this.variables = Map.copyOf(variables);
		this.evaluations = List.copyOf(evaluations);
		this.definedFunctionNames = definedFunctionNames;
	}

	public String getName() {
		return name;
	}
	
	public Set<String> getDefinedFunctionNames() {
	    return definedFunctionNames;
	}

	public List<CompiledFunction> getDefinedFunctions() {
	    List<CompiledFunction> results = new ArrayList<>();

	    for (String name : definedFunctionNames) {
	        results.add(getFunction(name));
	    }

	    return results;
	}
	
	public int getEvaluationCount() {
		return evaluations.size();
	}
	
	public CompiledFunction getFunction(String name) {
		FunctionSignature signature = functions.getSignature(name);
		
		if (signature == null) {
	        throw new IllegalArgumentException("Unknown function: " + name);
	    }
		
		return new CompiledFunction(name, signature);
	}
	
	public List<CompiledFunction> getFunctions() {
		List<CompiledFunction> results = new ArrayList<>();
		
		for(String name : functions.getFunctionNames()) {
			results.add(getFunction(name));
		}
		
		return results;
	}
	
	public Set<String> getFunctionNames() {
		return functions.getFunctionNames();
	}
	
	public FunctionSignature getFunctionSignature(String name) {
	    FunctionSignature signature = functions.getSignature(name);

	    if (signature == null) {
	        throw new IllegalArgumentException("Unknown function: " + name);
	    }

	    return signature;
	}
	
	public CompiledVariable getVariable(String name) {
		Expression expression = variables.get(name);
		
		if(expression == null) {
			throw new IllegalArgumentException("Unknown variable: " + name);
		}
		
		return new CompiledVariable(
				name,
				expression,
				SephirahTypeInferencer.inferType(expression));
	}
	
	public CompiledModuleSummary getSummary() {
		return new CompiledModuleSummary(
				name,
				getVariables(),
				getFunctions(),
				getEvaluationCount());
	}
	
	public List<CompiledVariable> getVariables() {
		List<CompiledVariable> results = new ArrayList<>();
		
		for(String name : variables.keySet()) {
			results.add(getVariable(name));
		}
		
		return results;
	}
	
	public Set<String> getVariableNames() {
	    return Collections.unmodifiableSet(variables.keySet());
	}
	
	public SephirahType getVariableType(String name) {
		Expression expression = variables.get(name);
		
		if (expression == null) {
	        throw new IllegalArgumentException("Unknown variable: " + name);
	    }
		
		return SephirahTypeInferencer.inferType(expression);
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
	
	public List<CompiledEvaluationResult> evaluateAllResults() {
	    List<CompiledEvaluationResult> results = new ArrayList<>();

	    for (int i = 0; i < evaluations.size(); i++) {
	        Expression expression = evaluations.get(i);
	        SephirahValue value = evaluateExpression(expression);
	        SephirahType type = SephirahTypeInferencer.inferType(expression);
	        
	        results.add(new CompiledEvaluationResult(
	                i,
	                expression,
	                value,
	                type));
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
    
    public SephirahValue callWithBooleans(String name, boolean... arguments) {
        List<SephirahValue> values = new ArrayList<>();
        
        for(boolean arguement : arguments) {
        	values.add(SephirahValues.bool(arguement));
        }
        
        return call(name, values);
    }
    
    public boolean callForBoolean(String name, boolean... arguments) {
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
