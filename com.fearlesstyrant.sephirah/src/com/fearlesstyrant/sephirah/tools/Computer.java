package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.util.EList;

import com.fearlesstyrant.sephirah.sephirah.*;

/**
 * Evaluates Sephirah expression trees.
 *
 * <p>This class is currently kept under its legacy name, {@code Computer}, so
 * existing validator and UI code can be migrated incrementally. Conceptually,
 * this is now Sephirah's expression evaluator.</p>
 *
 * <p>The generated grammar now stores variable and function names as strings
 * rather than EMF cross-references. Variable values therefore come from an
 * {@link EvaluationContext}, and function calls are dispatched through a
 * {@link FunctionRegistry}.</p>
 */
public final class Computer {

    private static final MathContext DEFAULT_MATH_CONTEXT = MathContext.DECIMAL128;

    private final EvaluationContext context;
    private final FunctionRegistry functions;

    /**
     * Creates an evaluator with the supplied runtime context and function registry.
     *
     * @param context runtime variable bindings
     * @param functions available runtime functions
     */
    public Computer(EvaluationContext context, FunctionRegistry functions) {
        this.context = Objects.requireNonNull(context, "context must not be null");
        this.functions = Objects.requireNonNull(functions, "functions must not be null");
    }

    /**
     * Evaluates an expression with no external variable bindings.
     *
     * @param expression expression to evaluate
     * @return evaluated numeric result
     */
    public static BigDecimal compute(Expression expression) {
        return standard().evaluate(expression);
    }

    /**
     * Evaluates a statement wrapper with no external variable bindings.
     *
     * @param evaluation evaluation statement to evaluate
     * @return evaluated numeric result
     */
    public static BigDecimal compute(Evaluation evaluation) {
        Objects.requireNonNull(evaluation, "evaluation must not be null");

        return compute(evaluation.getExpression());
    }

    /**
     * Evaluates an expression using the supplied variable bindings.
     *
     * @param expression expression to evaluate
     * @param values runtime variable bindings
     * @return evaluated numeric result
     */
    public static BigDecimal compute(Expression expression, Map<String, BigDecimal> values) {
        return standard(EvaluationContext.of(values)).evaluate(expression);
    }

    /**
     * Creates a standard evaluator with no external variable bindings.
     *
     * @return standard evaluator
     */
    public static Computer standard() {
        return standard(EvaluationContext.empty());
    }

    /**
     * Creates a standard evaluator with the supplied runtime context.
     *
     * @param context runtime variable bindings
     * @return standard evaluator
     */
    public static Computer standard(EvaluationContext context) {
        return new Computer(context, Methods.standardRegistry());
    }

    /**
     * Evaluates an expression using this evaluator's context and function registry.
     *
     * @param expression expression to evaluate
     * @return evaluated numeric result
     */
    public BigDecimal evaluate(Expression expression) {
        Objects.requireNonNull(expression, "expression must not be null");

        if(expression instanceof NumberLiteral numberLiteral) {
            return numberLiteral.getValue();
        }

        if(expression instanceof Constant constant) {
            return Constants.getBDConstant(constant.getValue());
        }

        if(expression instanceof Variable variable) {
            return context.requireValue(variable.getName());
        }
        
        if(expression instanceof Conditional conditional) {
        	return evaluateConditional(conditional);
        }

        if(expression instanceof Add add) {
            return evaluate(add.getLeft()).add(evaluate(add.getRight()));
        }

        if(expression instanceof Subtract subtract) {
            return evaluate(subtract.getLeft()).subtract(evaluate(subtract.getRight()));
        }

        if(expression instanceof Multiply multiply) {
            return evaluate(multiply.getLeft()).multiply(evaluate(multiply.getRight()));
        }

        if(expression instanceof Divide divide) {
            BigDecimal divisor = evaluate(divide.getRight());

            if(BigDecimal.ZERO.compareTo(divisor) == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            return evaluate(divide.getLeft()).divide(divisor, DEFAULT_MATH_CONTEXT);
        }

        if(expression instanceof Exponent exponent) {
            /*
             * BigDecimal does not support arbitrary decimal exponents directly.
             * This is acceptable as a temporary evaluator bridge, but the final
             * runtime should define exact integer-power behavior separately from
             * approximate decimal-power behavior.
             */
            double base = evaluate(exponent.getLeft()).doubleValue();
            double power = evaluate(exponent.getRight()).doubleValue();

            return BigDecimal.valueOf(Math.pow(base, power));
        }

        if(expression instanceof MethodCall methodCall) {
            return evaluateMethodCall(methodCall);
        }
        
        throw new IllegalArgumentException("Unhandled expression type: "
                + expression.eClass().getName());
    }
    
    private BigDecimal evaluateConditional(Conditional conditional) {
    	Objects.requireNonNull(conditional, "conditional must not be null");
    	
    	if(evaluateCondition(conditional.getCondition())) {
    		return evaluate(conditional.getThenBranch());
    	}
    	
    	return evaluate(conditional.getElseBranch());
    }
    
    private boolean evaluateCondition(Condition condition) {
    	Objects.requireNonNull(condition, "condition must not be null");
    	
    	BigDecimal left = evaluate(condition.getLeft());
    	BigDecimal right = evaluate(condition.getRight());
    	
    	int comparison = left.compareTo(right);
    	
    	ComparisonOperator operator = condition.getOp();
    	
    	if (operator == null) {
            throw new IllegalArgumentException("Condition has no comparison operator.");
        }

        switch (operator) {
            case LT:
                return comparison < 0;
            case LTE:
                return comparison <= 0;
            case GT:
                return comparison > 0;
            case GTE:
                return comparison >= 0;
            case EQ:
                return comparison == 0;
            case NEQ:
                return comparison != 0;
            default:
                throw new IllegalArgumentException("Unhandled comparison operator: " + operator);
        }
    }

    /**
     * Evaluates a function call expression.
     *
     * @param methodCall generated function-call expression
     * @return evaluated numeric result
     */
    private BigDecimal evaluateMethodCall(MethodCall methodCall) {
        String functionName = methodCall.getName();
        List<BigDecimal> arguments = new ArrayList<>();

        for (Expression argument : methodCall.getArgs()) {
            arguments.add(evaluate(argument));
        }

        return functions.invoke(functionName, arguments, context);
    }

    /**
     * Evaluates a user definition by binding supplied argument expressions to
     * definition parameters.
     *
     * <p>This method is a compatibility bridge for old callers. The final
     * module compiler should turn user definitions into registered functions
     * instead of calling this method directly.</p>
     *
     * @param parameters argument expressions supplied to the definition
     * @param definition user definition to evaluate
     * @return evaluated definition result
     */
    public static BigDecimal definitionEvaluate(EList<Expression> parameters, Definition definition) {
        Objects.requireNonNull(parameters, "parameters must not be null");
        Objects.requireNonNull(definition, "definition must not be null");

        EList<Assignment> variables = definition.getArgs();

        if (parameters.size() != variables.size()) {
            throw new IllegalArgumentException("Definition " + definition.getName()
                    + " expects " + variables.size() + " argument(s), but received "
                    + parameters.size() + ".");
        }

        Map<String, BigDecimal> localValues = new HashMap<>();

        for (int i = 0; i < variables.size(); i++) {
            Assignment variable = variables.get(i);
            BigDecimal value = compute(parameters.get(i));

            localValues.put(variable.getName(), value);
        }

        return standard(EvaluationContext.of(localValues)).evaluate(definition.getExpr());
    }

    /**
     * Finds the first use of a definition variable inside an expression tree.
     *
     * <p>This is retained for validator compatibility during migration.</p>
     *
     * @param definitionVariable definition variable to search for
     * @param expression expression tree to search
     * @return the matching variable expression, or {@code null} when absent
     */
    public static Variable findVariable(DefinitionVariable definitionVariable, Expression expression) {
        Objects.requireNonNull(definitionVariable, "definitionVariable must not be null");

        if (expression == null) {
            return null;
        }

        if (expression instanceof Variable variable) {
            if (definitionVariable.getName().equals(variable.getName())) {
                return variable;
            }

            return null;
        }

        if (expression instanceof Add add) {
            return findVariableInBinary(definitionVariable, add.getLeft(), add.getRight());
        }

        if (expression instanceof Subtract subtract) {
            return findVariableInBinary(definitionVariable, subtract.getLeft(), subtract.getRight());
        }

        if (expression instanceof Multiply multiply) {
            return findVariableInBinary(definitionVariable, multiply.getLeft(), multiply.getRight());
        }

        if (expression instanceof Divide divide) {
            return findVariableInBinary(definitionVariable, divide.getLeft(), divide.getRight());
        }

        if (expression instanceof Exponent exponent) {
            return findVariableInBinary(definitionVariable, exponent.getLeft(), exponent.getRight());
        }

        if (expression instanceof MethodCall methodCall) {
            for (Expression argument : methodCall.getArgs()) {
                Variable variable = findVariable(definitionVariable, argument);

                if (variable != null) {
                    return variable;
                }
            }
        }

        return null;
    }

    /**
     * Searches two child expressions from left to right.
     *
     * @param definitionVariable variable to search for
     * @param left left child expression
     * @param right right child expression
     * @return the matching variable expression, or {@code null}
     */
    private static Variable findVariableInBinary(
            DefinitionVariable definitionVariable,
            Expression left,
            Expression right) {

        Variable variable = findVariable(definitionVariable, left);

        if (variable != null) {
            return variable;
        }

        return findVariable(definitionVariable, right);
    }

    /**
     * Counts an EMF list without depending on implementation details.
     *
     * @param list list to count
     * @param <E> element type
     * @return number of elements
     */
    public static <E> int getEListSize(EList<E> list) {
        int size = 0;

        for (@SuppressWarnings("unused") E ignored : list) {
            size++;
        }

        return size;
    }
}