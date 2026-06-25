package com.fearlesstyrant.sephirah.tools;

import java.util.Collections;
import java.util.*;

import com.fearlesstyrant.sephirah.tools.value.SephirahValue;

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

    private final Map<String, RegisteredFunction> functions;

    /**
     * Creates a registry from the supplied function map.
     *
     * @param functions function names mapped to implementations
     */
    public FunctionRegistry(Map<String, RegisteredFunction> functions) {
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
    
    public Builder toBuilder() {
        Builder builder = new Builder();

        for (Map.Entry<String, RegisteredFunction> entry : functions.entrySet()) {
            builder.register(entry.getValue());
        }

        return builder;
    }

    /**
     * Invokes a registered function.
     *
     * @param name function name
     * @param arguments evaluated argument values
     * @param context active evaluation context
     * @return function result
     */
    public SephirahValue invoke(String name, List<SephirahValue> arguments, EvaluationContext context) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(arguments, "arguments must not be null");
        Objects.requireNonNull(context, "context must not be null");

        RegisteredFunction function = functions.get(name);

        if (function == null) {
            throw new IllegalArgumentException("Unknown function: " + name);
        }

        return function.invoke(arguments, context);
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
    
    public Set<String> getFunctionNames() {
    	return functions.keySet();
    }
    
    public FunctionSignature getSignature(String name) {
        Objects.requireNonNull(name, "name must not be null");

        RegisteredFunction function = functions.get(name);

        if (function == null) {
            return null;
        }

        return function.getSignature();
    }

    /**
     * Mutable builder for {@link FunctionRegistry}.
     */
    public static final class Builder {

        private final Map<String, RegisteredFunction> functions = new HashMap<>();

        /**
         * Registers a function implementation.
         *
         * @param name function name
         * @param function function implementation
         * @return this builder
         */
        public Builder register(String name,
        		FunctionSignature signature,
        		SephirahFunction function
        		) {
            Objects.requireNonNull(name, "name must not be null");
            Objects.requireNonNull(function, "function must not be null");
            Objects.requireNonNull(signature, "signature must not be null");

            if(functions.containsKey(name)) {
            	throw new IllegalArgumentException("Function already registered: " + name);
            }
            
            return register(new RegisteredFunction(name, signature, function));
        }
        
        public Builder register(RegisteredFunction function) {
            Objects.requireNonNull(function, "function must not be null");

            String name = function.getName();

            if (functions.containsKey(name)) {
                throw new IllegalArgumentException("Function already registered: " + name);
            }

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
