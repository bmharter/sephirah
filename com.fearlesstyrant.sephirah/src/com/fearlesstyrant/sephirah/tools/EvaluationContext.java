package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.fearlesstyrant.sephirah.tools.value.SephirahValue;
import com.fearlesstyrant.sephirah.tools.value.SephirahValues;

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
    public static final EvaluationContext EMPTY = new EvaluationContext(Collections.emptyMap(), null);

    private final Map<String, SephirahValue> values;
    private final ValueResolver resolver;

    /**
     * Creates a context using the supplied variable bindings.
     *
     * @param values variable names mapped to numeric values
     */
    public EvaluationContext(Map<String, SephirahValue> values) {
        this(values, null);
    }
    
    public EvaluationContext(Map<String, SephirahValue> values, ValueResolver resolver) {
        Objects.requireNonNull(values, "values must not be null");

        this.values = Collections.unmodifiableMap(new HashMap<>(values));
        this.resolver = resolver;
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
    public static EvaluationContext of(Map<String, SephirahValue> values) {
    	Objects.requireNonNull(values, "values must not be null");
        return new EvaluationContext(values);
    }
    
    public static EvaluationContext of(Map<String, SephirahValue> values, ValueResolver resolver) {
    	Objects.requireNonNull(values, "values must not be null");
    	Objects.requireNonNull(resolver, "resolver must not be null");
    	return new EvaluationContext(values, resolver);
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

        Map<String, SephirahValue> updatedValues = new HashMap<>(values);
        updatedValues.put(name, SephirahValues.numeric(value));

        return new EvaluationContext(updatedValues, resolver);
    }
    
    public EvaluationContext withResolver(ValueResolver resolver) {
    	Objects.requireNonNull(resolver, "resolver must not be null");
    	
    	return new EvaluationContext(values, resolver);
    }

    /**
     * Resolves a variable name into a numeric value when available.
     *
     * @param name variable name or qualified path
     * @return the resolved value, if bound
     */
    public Optional<SephirahValue> resolveValue(String name) {
    	Objects.requireNonNull(name, "name must not be null");

        SephirahValue directValue = values.get(name);

        if (directValue != null) {
            return Optional.of(directValue);
        }

        if (resolver == null) {
            return Optional.empty();
        }

        return resolver.resolveValue(name);
    }

    /**
     * Resolves a variable name or throws a clear runtime exception.
     *
     * @param name variable name or qualified path
     * @return the resolved numeric value
     */
    public SephirahValue requireValue(String name) {
        return  resolveValue(name)
                .orElseThrow(() -> new IllegalArgumentException("Unbound variable: " + name));
    }
    
    public BigDecimal requireNumericValue(String name) {
        return SephirahValues.requireNumeric(requireValue(name));
    }

	public ValueResolver getResolver() {
		return resolver;
	}
}