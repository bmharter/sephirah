package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.fearlesstyrant.sephirah.tools.type.SephirahType;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;
import com.fearlesstyrant.sephirah.tools.value.SephirahValues;

/**
 * Provides Sephirah's standard numeric function library.
 *
 * <p>This class no longer dispatches directly from generated AST nodes.
 * Instead, it produces a {@link FunctionRegistry}. The evaluator is
 * responsible for evaluating argument expressions and invoking the registry
 * by function name.</p>
 */
public final class Methods {

    private Methods() {
        // Utility class; not instantiable.
    }

    /**
     * Creates the default Sephirah standard-library function registry.
     *
     * @return registry containing built-in numeric functions
     */
    public static FunctionRegistry standardRegistry() {
        return FunctionRegistry.builder()
                .register("abs",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::abs)
                .register("ceil",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::ceil)
                .register("floor",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::floor)
                .register("min",
                		FunctionSignature.varargs(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::min)
                .register("max",
                		FunctionSignature.varargs(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::max)
                .register("roundHalfUp",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::roundHalfUp)
                .register("roundHalfDown",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::roundHalfDown)
                .register("sqrt",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::sqrt)

                /*
                 * Dice remains registered here for now so existing Sephirah
                 * expressions can keep using roll(num, sides). The Dice class
                 * itself is still scheduled for replacement by DiceService.
                 */
                .register("roll",
                		FunctionSignature.exactly(2,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::roll)
                .build();
    }
    
    public static FunctionRegistry previewRegistry() {
    	return FunctionRegistry.builder()
    			.register("abs",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::abs)
                .register("ceil",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::ceil)
                .register("floor",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::floor)
                .register("min",
                		FunctionSignature.varargs(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::min)
                .register("max",
                		FunctionSignature.varargs(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::max)
                .register("roundHalfUp",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::roundHalfUp)
                .register("roundHalfDown",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::roundHalfDown)
                .register("sqrt",
                		FunctionSignature.exactly(1,
                				SephirahType.NUMBER,
                				SephirahType.NUMBER),
                		Methods::sqrt)
                .build();
    }

    private static SephirahValue abs(List<SephirahValue> args, EvaluationContext context) {
        requireArity("abs", args, 1);
        
        BigDecimal value = SephirahValues.requireNumeric(args.get(0));
        
        return SephirahValues.numeric(value.abs());
    }

    private static SephirahValue ceil(List<SephirahValue> args, EvaluationContext context) {
        requireArity("ceil", args, 1);
        
        BigDecimal value = roundToInteger(SephirahValues.requireNumeric(args.get(0)),
        		RoundingMode.CEILING);
        
        return SephirahValues.numeric(value);
    }

    private static SephirahValue floor(List<SephirahValue> args, EvaluationContext context) {
        requireArity("floor", args, 1);
        
        BigDecimal value = roundToInteger(SephirahValues.requireNumeric(args.get(0)),
        		RoundingMode.FLOOR);
        
        return SephirahValues.numeric(value);
    }

    private static SephirahValue min(List<SephirahValue> args, EvaluationContext context) {
        requireAtLeast("min", args, 1);
        
        BigDecimal result = SephirahValues.requireNumeric(args.get(0));
        
        List<BigDecimal> results = new ArrayList<>();
        
        for(SephirahValue value : args) {
        	results.add(SephirahValues.requireNumeric(value));
        }
        
        for (int i = 1; i < results.size(); i++) {
            result = result.min(results.get(i));
        }

        return SephirahValues.numeric(result);
    }

    private static SephirahValue max(List<SephirahValue> args, EvaluationContext context) {
        requireAtLeast("max", args, 1);

        BigDecimal result = SephirahValues.requireNumeric(args.get(0));
        
        List<BigDecimal> results = new ArrayList<>();
        
        for(SephirahValue value : args) {
        	results.add(SephirahValues.requireNumeric(value));
        }
        
        for (int i = 1; i < args.size(); i++) {
            result = result.max(results.get(i));
        }

        return SephirahValues.numeric(result);
    }

    private static SephirahValue roundHalfUp(List<SephirahValue> args, EvaluationContext context) {
        requireArity("roundHalfUp", args, 1);
        
        BigDecimal value = roundToInteger(SephirahValues.requireNumeric(args.get(0)),
        		RoundingMode.HALF_UP);
        
        return SephirahValues.numeric(value);
    }

    private static SephirahValue roundHalfDown(List<SephirahValue> args, EvaluationContext context) {
        requireArity("roundHalfDown", args, 1);
        
        BigDecimal value = roundToInteger(SephirahValues.requireNumeric(args.get(0)),
        		RoundingMode.HALF_DOWN);
        
        return SephirahValues.numeric(value);
    }

    private static SephirahValue sqrt(List<SephirahValue> args, EvaluationContext context) {
        requireArity("sqrt", args, 1);

        BigDecimal value = SephirahValues.requireNumeric(args.get(0));

        if (value.signum() < 0) {
            throw new ArithmeticException("sqrt cannot accept a negative value: " + value);
        }

        /*
         * DECIMAL128 is a reasonable default for now. Later, precision should
         * come from an EvaluationSettings object.
         */
        return SephirahValues.numeric(value.sqrt(MathContext.DECIMAL128));
    }

    private static SephirahValue roll(List<SephirahValue> args, EvaluationContext context) {
        requireArity("roll", args, 2);

        int quantity = requireWholeInt("roll quantity", SephirahValues.requireNumeric(args.get(0)));
        int sides = requireWholeInt("roll sides", SephirahValues.requireNumeric(args.get(1)));

        if (quantity <= 0 || sides <= 0) {
            throw new IllegalArgumentException("Dice quantity and sides must be positive.");
        }

        return SephirahValues.numeric(BigDecimal.valueOf(Dice.roll(quantity, sides)));
    }

    private static BigDecimal roundToInteger(BigDecimal value, RoundingMode roundingMode) {
        return value.setScale(0, roundingMode);
    }

    private static void requireArity(String functionName, List<SephirahValue> args, int expected) {
        if (args.size() != expected) {
            throw new IllegalArgumentException(functionName + " expects " + expected
                    + " argument(s), but received " + args.size() + ".");
        }
    }

    private static void requireAtLeast(String functionName, List<SephirahValue> args, int minimum) {
        if (args.size() < minimum) {
            throw new IllegalArgumentException(functionName + " expects at least " + minimum
                    + " argument(s), but received " + args.size() + ".");
        }
    }

    private static int requireWholeInt(String label, BigDecimal value) {
        try {
            return value.intValueExact();
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException(label + " must be a whole integer: " + value, exception);
        }
    }
}