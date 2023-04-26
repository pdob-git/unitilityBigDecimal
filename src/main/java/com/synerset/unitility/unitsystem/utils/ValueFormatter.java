package com.synerset.unitility.unitsystem.utils;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ValueFormatter {

    private ValueFormatter() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatDoubleToRelevantPrecision(BigDecimal value, int relevantDigits) {

        int relevantScale = calculateRelevantScale(value);

        int numDecimalPlaces = value.compareTo(BigDecimal.ONE) >= 0 ? 6 : Math.max(relevantDigits, relevantScale + relevantDigits);

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(numDecimalPlaces);
        numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        return numberFormat.format(value);
    }

    private static int calculateRelevantScale(BigDecimal value) {

        BigDecimal abs = value.abs(MathContext.DECIMAL64);
        if (abs.compareTo(BigDecimal.ZERO) == 0) {
            return  0;
        }
        BigDecimal log10 = BigDecimalMath.log10(abs, MathContext.DECIMAL64);
        BigDecimal log10abs = log10.abs(MathContext.DECIMAL64);

        return log10abs.intValue();

    }

}
