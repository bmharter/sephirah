package com.fearlesstyrant.sephirah.tools.value;

import java.math.BigDecimal;
import java.util.Objects;

public final class NumericValue implements SephirahValue{

	private final BigDecimal value;

    public NumericValue(BigDecimal value) {
        this.value = Objects.requireNonNull(value, "value must not be null");
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}