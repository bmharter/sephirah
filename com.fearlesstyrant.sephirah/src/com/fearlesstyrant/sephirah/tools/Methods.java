package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

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
                .register("abs", Methods::abs)
                .register("ceil", Methods::ceil)
                .register("floor", Methods::floor)
                .register("min", Methods::min)
                .register("max", Methods::max)
                .register("roundHalfUp", Methods::roundHalfUp)
                .register("roundHalfDown", Methods::roundHalfDown)
                .register("sqrt", Methods::sqrt)

                /*
                 * Dice remains registered here for now so existing Sephirah
                 * expressions can keep using roll(num, sides). The Dice class
                 * itself is still scheduled for replacement by DiceService.
                 */
                .register("roll", Methods::roll)
                .build();
    }
    
    public static FunctionRegistry previewRegistry() {
    	return FunctionRegistry.builder()
    			.register("abs", Methods::abs)
                .register("ceil", Methods::ceil)
                .register("floor", Methods::floor)
                .register("min", Methods::min)
                .register("max", Methods::max)
                .register("roundHalfUp", Methods::roundHalfUp)
                .register("roundHalfDown", Methods::roundHalfDown)
                .register("sqrt", Methods::sqrt)
                .build();
    }

    private static BigDecimal abs(List<BigDecimal> args, EvaluationContext context) {
        requireArity("abs", args, 1);
        return args.get(0).abs();
    }

    private static BigDecimal ceil(List<BigDecimal> args, EvaluationContext context) {
        requireArity("ceil", args, 1);
        return roundToInteger(args.get(0), RoundingMode.CEILING);
    }

    private static BigDecimal floor(List<BigDecimal> args, EvaluationContext context) {
        requireArity("floor", args, 1);
        return roundToInteger(args.get(0), RoundingMode.FLOOR);
    }

    private static BigDecimal min(List<BigDecimal> args, EvaluationContext context) {
        requireAtLeast("min", args, 1);

        BigDecimal result = args.get(0);
        for (int i = 1; i < args.size(); i++) {
            result = result.min(args.get(i));
        }

        return result;
    }

    private static BigDecimal max(List<BigDecimal> args, EvaluationContext context) {
        requireAtLeast("max", args, 1);

        BigDecimal result = args.get(0);
        for (int i = 1; i < args.size(); i++) {
            result = result.max(args.get(i));
        }

        return result;
    }

    private static BigDecimal roundHalfUp(List<BigDecimal> args, EvaluationContext context) {
        requireArity("roundHalfUp", args, 1);
        return roundToInteger(args.get(0), RoundingMode.HALF_UP);
    }

    private static BigDecimal roundHalfDown(List<BigDecimal> args, EvaluationContext context) {
        requireArity("roundHalfDown", args, 1);
        return roundToInteger(args.get(0), RoundingMode.HALF_DOWN);
    }

    private static BigDecimal sqrt(List<BigDecimal> args, EvaluationContext context) {
        requireArity("sqrt", args, 1);

        BigDecimal value = args.get(0);

        if (value.signum() < 0) {
            throw new ArithmeticException("sqrt cannot accept a negative value: " + value);
        }

        /*
         * DECIMAL128 is a reasonable default for now. Later, precision should
         * come from an EvaluationSettings object.
         */
        return value.sqrt(MathContext.DECIMAL128);
    }

    private static BigDecimal roll(List<BigDecimal> args, EvaluationContext context) {
        requireArity("roll", args, 2);

        int quantity = requireWholeInt("roll quantity", args.get(0));
        int sides = requireWholeInt("roll sides", args.get(1));

        if (quantity <= 0 || sides <= 0) {
            throw new IllegalArgumentException("Dice quantity and sides must be positive.");
        }

        return BigDecimal.valueOf(Dice.roll(quantity, sides));
    }

    private static BigDecimal roundToInteger(BigDecimal value, RoundingMode roundingMode) {
        return value.setScale(0, roundingMode);
    }

    private static void requireArity(String functionName, List<BigDecimal> args, int expected) {
        if (args.size() != expected) {
            throw new IllegalArgumentException(functionName + " expects " + expected
                    + " argument(s), but received " + args.size() + ".");
        }
    }

    private static void requireAtLeast(String functionName, List<BigDecimal> args, int minimum) {
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