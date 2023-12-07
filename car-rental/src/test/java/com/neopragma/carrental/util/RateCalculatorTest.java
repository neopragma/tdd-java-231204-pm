package com.neopragma.carrental.util;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateCalculatorTest {

    private RateCalculator rateCalculator;

    @BeforeEach
    public void setup() {
        rateCalculator = new RateCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideValuesForVehicleClass")
    public void testDailyRateForVehicleTypeAndState(
            Money startingDailyRate, String vehicleType, String pickupCountry, String pickupState,
            Money expectedDailyRate) {
        assertEquals(expectedDailyRate,
                rateCalculator.vehicleTypeDailyRate(
                        startingDailyRate, vehicleType, pickupCountry, pickupState));
    }

    private static Stream<Arguments> provideValuesForVehicleClass() {
        return Stream.of(
                Arguments.of(Money.of(50, "USD"),
                        "city car", "US", "SC", Money.of(50, "USD")),
                Arguments.of(Money.of(50, "USD"),
                        "standard sedan", "US", "SC", Money.of(105, "USD"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForCaliforniaNotCityCar")
    public void testDailyRateForVehicleTypeAndCityInCalifornia(
            Money startingDailyRate, String vehicleType, String pickupCity, Money expectedDailyRate) {
        assertEquals(expectedDailyRate,
                rateCalculator.caDailyRateNotCityCar(
                        startingDailyRate, vehicleType, pickupCity));
    }

    private static Stream<Arguments> provideValuesForCaliforniaNotCityCar() {
        return Stream.of(
                Arguments.of(Money.of(50, "USD"), "economy", "San Francisco", Money.of(102, "USD")),
                Arguments.of(Money.of(50, "USD"), "standard sedan", "San Francisco", Money.of(115, "USD"))
        );
    }
}
