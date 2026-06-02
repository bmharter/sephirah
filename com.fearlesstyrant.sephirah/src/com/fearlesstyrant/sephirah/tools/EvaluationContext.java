package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Provides runtime bindings for Sephirah expression evaluation.
 *
 * <p>The grammar now represents variables as names rather than EMF references.
 * This context is the evaluator-facing object responsible for resolving those
 * names into numeric values.</p>
 *
 * <p>This class is intentionally small at this stage. It can later grow into a
 * layered resolver that checks local function parameters, module-level
 * constants, imported symbols, host-object paths, and J20 runtime state.</p>
 */
public final class EvaluationContext {

    /**
     * Shared empty context for evaluating expressions that do not require
     * external variable bindings.
     */
    public static final EvaluationContext EMPTY = new EvaluationContext(Collections.emptyMap());

    private final Map<String, BigDecimal> values;

    /**
     * Creates a context using the supplied variable bindings.
     *
     * @param values variable names mapped to numeric values
     */
    public EvaluationContext(Map<String, BigDecimal> values) {
        Objects.requireNonNull(values, "values must not be null");

        this.values = Collections.unmodifiableMap(new HashMap<>(values));
    }

    /**
     * Creates an empty context.
     *
     * @return an empty evaluation context
     */
    public static EvaluationContext empty() {
        return EMPTY;
    }

    /**
     * Creates a context from a map of variable bindings.
     *
     * @param values variable names mapped to numeric values
     * @return a new evaluation context
     */
    public static EvaluationContext of(Map<String, BigDecimal> values) {
        return new EvaluationContext(values);
    }

    /**
     * Creates a new context with one added or replaced variable binding.
     *
     * @param name variable name
     * @param value numeric value
     * @return a new context containing the additional binding
     */
    public EvaluationContext withValue(String name, BigDecimal value) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(value, "value must not be null");

        Map<String, BigDecimal> updatedValues = new HashMap<>(values);
        updatedValues.put(name, value);

        return new EvaluationContext(updatedValues);
    }

    /**
     * Resolves a variable name into a numeric value when available.
     *
     * @param name variable name or qualified path
     * @return the resolved value, if bound
     */
    public Optional<BigDecimal> resolveValue(String name) {
        Objects.requireNonNull(name, "name must not be null");

        return Optional.ofNullable(values.get(name));
    }

    /**
     * Resolves a variable name or throws a clear runtime exception.
     *
     * @param name variable name or qualified path
     * @return the resolved numeric value
     */
    public BigDecimal requireValue(String name) {
        return resolveValue(name)
                .orElseThrow(() -> new IllegalArgumentException("Unbound variable: " + name));
    }
}