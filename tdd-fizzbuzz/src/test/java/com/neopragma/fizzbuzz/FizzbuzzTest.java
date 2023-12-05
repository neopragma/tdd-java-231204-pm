package com.neopragma.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FizzbuzzTest
{
    private Fizzbuzz fizzbuzz;

    @BeforeEach
    public void beforeEachTestCase() {
        fizzbuzz = new Fizzbuzz();
    }

    @ParameterizedTest
    @MethodSource("provideValuesForFizzBuzz")
    public void it_returns_Fizz_or_Buzz_or_FizzBuzz_or_the_number(
            String expected, int input, String message) {
        assertEquals(expected, fizzbuzz.processNumber(input), message);
    }

    private static Stream<Arguments> provideValuesForFizzBuzz() {
        return Stream.of(
                Arguments.of("1", 1, "1 -> 1"),
                Arguments.of("2", 2, "2 -> 2"),
                Arguments.of("Fizz", 3, "3 -> Fizz"),
                Arguments.of("Buzz", 5, "5 -> Buzz"),
                Arguments.of("FizzBuzz", 15, "15 -> FizzBuzz"),
                Arguments.of("FizzBuzz", 30, "30 -> FizzBuzz"),
                Arguments.of("Fizz", 9, "9 -> Fizz"),
                Arguments.of("Buzz", 10, "10 -> Buzz")
        );
    }

}
