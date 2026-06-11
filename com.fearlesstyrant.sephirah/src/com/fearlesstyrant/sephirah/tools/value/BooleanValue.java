package com.fearlesstyrant.sephirah.tools.value;

public final class BooleanValue implements SephirahValue {

    public static final BooleanValue TRUE = new BooleanValue(true);
    public static final BooleanValue FALSE = new BooleanValue(false);

    private final boolean value;

    private BooleanValue(boolean value) {
        this.value = value;
    }

    public static BooleanValue of(boolean value) {
        return value ? TRUE : FALSE;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
