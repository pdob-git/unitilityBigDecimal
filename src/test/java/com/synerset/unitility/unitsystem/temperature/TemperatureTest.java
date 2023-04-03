package com.synerset.unitility.unitsystem.temperature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemperatureTest {

    @Test
    @DisplayName("should convert to Kelvin from Celsius and vice versa")
    void shouldProperlyConvertToKelvinFromCelsius() {
        // Given
        Temperature initialTempInCelsius = Temperature.ofCelsius(20.5);

        // When
        Temperature actualInKelvins = initialTempInCelsius.toBaseUnit();
        Temperature actualInCelsius = actualInKelvins.toUnit(TemperatureUnits.CELSIUS);

        // Then
        Temperature expectedInKelvins = Temperature.ofKelvins(20.5 + 273.15);
        assertThat(actualInKelvins).isEqualTo(expectedInKelvins);
        assertThat(actualInCelsius).isEqualTo(initialTempInCelsius);
    }

}