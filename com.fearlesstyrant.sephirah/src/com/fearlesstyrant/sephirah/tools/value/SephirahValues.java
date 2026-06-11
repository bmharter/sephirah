package com.fearlesstyrant.sephirah.tools.value;

import java.math.BigDecimal;
import java.util.Objects;

public final class SephirahValues {

	private SephirahValues() {
    }

    public static NumericValue numeric(BigDecimal value) {
        return new NumericValue(value);
    }

    public static BooleanValue bool(boolean value) {
        return BooleanValue.of(value);
    }

    public static BigDecimal requireNumeric(SephirahValue value) {
        Objects.requireNonNull(value, "value must not be null");

        if (value instanceof NumericValue numericValue) {
            return numericValue.getValue();
        }

        throw new IllegalArgumentException("Expected numeric value, but received " + value + ".");
    }

    public static boolean requireBoolean(SephirahValue value) {
        Objects.requireNonNull(value, "value must not be null");

        if (value instanceof BooleanValue booleanValue) {
            return booleanValue.getValue();
        }

        throw new IllegalArgumentException("Expected boolean value, but received " + value + ".");
    }
}
