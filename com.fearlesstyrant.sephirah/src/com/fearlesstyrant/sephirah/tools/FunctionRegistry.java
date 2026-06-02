package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Stores the callable functions available to a Sephirah evaluation.
 *
 * <p>The grammar now stores method/function calls by name. This registry is
 * the runtime mechanism that turns a function name such as {@code floor} or
 * {@code roll} into executable behavior.</p>
 */
public final class FunctionRegistry {

    /**
     * Shared empty registry for contexts where no functions are available.
     */
    public static final FunctionRegistry EMPTY = new FunctionRegistry(Collections.emptyMap());

    private final Map<String, SephirahFunction> functions;

    /**
     * Creates a registry from the supplied function map.
     *
     * @param functions function names mapped to implementations
     */
    public FunctionRegistry(Map<String, SephirahFunction> functions) {
        Objects.requireNonNull(functions, "functions must not be null");

        this.functions = Collections.unmodifiableMap(new HashMap<>(functions));
    }

    /**
     * Creates an empty registry.
     *
     * @return an empty function registry
     */
    public static FunctionRegistry empty() {
        return EMPTY;
    }

    /**
     * Creates a mutable builder for assembling a registry.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Invokes a registered function.
     *
     * @param name function name
     * @param arguments evaluated argument values
     * @param context active evaluation context
     * @return function result
     */
    public BigDecimal invoke(String name, List<BigDecimal> arguments, EvaluationContext context) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(arguments, "arguments must not be null");
        Objects.requireNonNull(context, "context must not be null");

        SephirahFunction function = functions.get(name);

        if (function == null) {
            throw new IllegalArgumentException("Unknown function: " + name);
        }

        return function.apply(arguments, context);
    }

    /**
     * Checks whether a function is registered.
     *
     * @param name function name
     * @return true when the function exists in this registry
     */
    public boolean contains(String name) {
        Objects.requireNonNull(name, "name must not be null");

        return functions.containsKey(name);
    }

    /**
     * Mutable builder for {@link FunctionRegistry}.
     */
    public static final class Builder {

        private final Map<String, SephirahFunction> functions = new HashMap<>();

        /**
         * Registers a function implementation.
         *
         * @param name function name
         * @param function function implementation
         * @return this builder
         */
        public Builder register(String name, SephirahFunction function) {
            Objects.requireNonNull(name, "name must not be null");
            Objects.requireNonNull(function, "function must not be null");

            functions.put(name, function);
            return this;
        }

        /**
         * Builds an immutable function registry.
         *
         * @return function registry
         */
        public FunctionRegistry build() {
            return new FunctionRegistry(functions);
        }
    }
}
