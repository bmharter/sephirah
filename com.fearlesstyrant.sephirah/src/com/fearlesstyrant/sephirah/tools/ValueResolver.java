package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Resolves named Sephirah values that are not directly bound in an
 * EvaluationContext.
 */
@FunctionalInterface
public interface ValueResolver {

    /**
     * Attempts to resolve a variable name or qualified path.
     *
     * @param name variable name or qualified path
     * @return the resolved numeric value, if available
     */
    Optional<BigDecimal> resolveValue(String name);
}