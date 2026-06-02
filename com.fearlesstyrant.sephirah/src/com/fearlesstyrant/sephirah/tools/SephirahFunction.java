package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a callable Sephirah runtime function.
 *
 * <p>Functions receive already-evaluated numeric arguments. This keeps the
 * normal function path strict and predictable: the evaluator resolves each
 * argument expression first, then passes the resulting values into the
 * function implementation.</p>
 */
@FunctionalInterface
public interface SephirahFunction {

    /**
     * Applies this function to evaluated numeric arguments.
     *
     * @param arguments evaluated argument values in source order
     * @param context active evaluation context
     * @return numeric result of the function call
     */
    BigDecimal apply(List<BigDecimal> arguments, EvaluationContext context);
}