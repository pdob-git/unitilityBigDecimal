package com.synerset.unitsystem.pressure;

import java.util.Objects;

public class Bar implements Pressure {

    private static final String DEF_SYMBOL = "bar";
    private final double value;

    private Bar(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getSymbol() {
        return DEF_SYMBOL;
    }

    @Override
    public Pascal toPascal() {
        return Pascal.of(value * 1E5);
    }

    @Override
    public HectoPascal toHectoPascal() {
        return HectoPascal.of(toPascal().getValue() / 1E2);
    }

    @Override
    public MegaPascal toMegaPascal() {
        return MegaPascal.of(toPascal().getValue() / 1E6);
    }

    @Override
    public Bar toBar() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bar bar)) return false;
        return Double.compare(bar.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static Bar of(double value) {
        return new Bar(value);
    }

}
