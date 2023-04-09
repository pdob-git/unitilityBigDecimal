package com.synerset.unitility.unitsystem.mass;

import com.synerset.unitility.unitsystem.Unit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class MassTest {

    @Test
    @DisplayName("should convert to kg from g and vice versa")
    void shouldProperlyConvertToKilogramsFromGrams() {
        // Given
        Mass initialMassInGrams = Mass.ofGrams(1000.0);

        // When
        Mass actualInKilograms = initialMassInGrams.toUnit(MassUnits.KILOGRAM);
        Mass actualInGrams = actualInKilograms.toUnit(MassUnits.GRAM);

        // Then
        Mass expectedInKilograms = Mass.ofKilograms(1.0);
        assertThat(actualInKilograms).isEqualTo(expectedInKilograms);
        assertThat(actualInGrams).isEqualTo(initialMassInGrams);
    }

    @Test
    @DisplayName("should convert to kg from t and vice versa")
    void shouldProperlyConvertToKilogramsFromTonneSi() {
        // Given
        Mass initialMassInTonneSi = Mass.ofTonneSI(1.0);

        // When
        Mass actualInKilograms = initialMassInTonneSi.toBaseUnit();
        Mass actualInTonneSi = actualInKilograms.toUnit(MassUnits.TONNE_SI);

        // Then
        Mass expectedInKilograms = Mass.ofKilograms(1000.0);
        assertThat(actualInKilograms).isEqualTo(expectedInKilograms);
        assertThat(actualInTonneSi).isEqualTo(initialMassInTonneSi);
    }

    @Test
    @DisplayName("should convert to kg from mg and vice versa")
    void shouldProperlyConvertToKilogramsFromMilligrams() {
        // Given
        Mass initialMassInMilligrams = Mass.ofMiligrams(1000.0);

        // When
        Mass actualInKilograms = initialMassInMilligrams.toBaseUnit();
        Mass actualInMilligrams = actualInKilograms.toUnit(MassUnits.MILLIGRAM);

        // Then
        Mass expectedInKilograms = Mass.ofKilograms(0.001);
        assertThat(actualInKilograms).isEqualTo(expectedInKilograms);
        assertThat(actualInMilligrams.getValue()).isEqualTo(initialMassInMilligrams.getValue(), withPrecision(1E-13));
    }

    @Test
    @DisplayName("should convert to kg from oz and vice versa")
    void shouldProperlyConvertToKilogramsFromOunces() {
        // Given
        Mass initialMassInOunces = Mass.ofOunces(10.0);

        // When
        Mass actualInKilograms = initialMassInOunces.toUnit(MassUnits.KILOGRAM);
        Mass actualInOunces = actualInKilograms.toUnit(MassUnits.OUNCE);

        // Then
        Mass expectedInKilograms = Mass.ofKilograms(0.28349523125);
        assertThat(actualInKilograms.getValue()).isEqualTo(expectedInKilograms.getValue(), withPrecision(1E-15));
        assertThat(actualInOunces).isEqualTo(initialMassInOunces);
    }

    @Test
    @DisplayName("should convert to kg from lb and vice versa")
    void shouldProperlyConvertToKilogramsFromPounds() {
        // Given
        Mass initialMassInPounds = Mass.ofPounds(10.0);

        // When
        Mass actualInKilograms = initialMassInPounds.toUnit(MassUnits.KILOGRAM);
        Mass actualInPounds = actualInKilograms.toUnit(MassUnits.POUND);

        // Then
        Mass expectedInKilograms = Mass.ofKilograms(4.5359237);
        assertThat(actualInKilograms.getValue()).isEqualTo(expectedInKilograms.getValue(), withPrecision(1E-15));
        assertThat(actualInPounds).isEqualTo(initialMassInPounds);
    }

    @Test
    @DisplayName("should have kg as base unit")
    void shouldHaveKilogramAsBaseUnit() {
        // Given
        MassUnits expectedBaseUnit = MassUnits.KILOGRAM;

        // When
        Mass massInLb = Mass.ofPounds(10);
        Unit<Mass> actualBaseUnit = massInLb.getUnit().getBaseUnit();

        // Then
        assertThat(actualBaseUnit).isEqualTo(expectedBaseUnit);
    }

}
