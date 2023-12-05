package com.neopragma.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzbuzzTest
{
    private Fizzbuzz fizzbuzz;

    @BeforeEach
    public void beforeEachTestCase() {
        fizzbuzz = new Fizzbuzz();
    }

    @ParameterizedTest
    @MethodSource("provideValuesForFizzBuzz")
    public void it_returns_1_as_a_string(String expected, int input) {
        assertEquals(expected, fizzbuzz.processNumber(input));
    }

    private static Stream<Arguments> provideValuesForFizzBuzz() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("2", 2)
        );
    }
    @Test
    public void it_returns_Fizz_for_3() {
        assertEquals("Fizz", fizzbuzz.processNumber(3));
    }

}
