package com.neopragma.rpn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPNTest {

    private RPN rpn;

    @BeforeEach
    public void instantiateRPN() {
        rpn = new RPN();
    }

    @Test
    public void it_returns_the_number_entered() throws Exception {
        assertEquals("1.0", rpn.enter("1.0"));
    }
    @Test
    public void it_returns_the_only_number_entered() throws Exception {
        rpn.enter("1.0");
        assertEquals("2.0", rpn.enter("2.0"));
    }

    @Test
    public void it_returns_the_last_value_entered() throws Exception {
        rpn.enter("1.0");
        rpn.enter("2.0");
        rpn.enter("+");
        assertEquals("99.0", rpn.enter("99.0"));
    }

    @ParameterizedTest
    @MethodSource("provideValuesForRPNOperations")
    public void it_handles_addition(
            String expected, String value1, String value2,
            String operation, String message) throws Exception {
        rpn.enter(value1);
        rpn.enter(value2);
        assertEquals(expected, rpn.enter(operation), message);
    }

    private static Stream<Arguments> provideValuesForRPNOperations() {
        return Stream.of(
                Arguments.of("9.5", "4.25", "5.25", "+", "Addition"),
                Arguments.of("15.0", "3.0", "5.0", "*", "Multiplication"),
                Arguments.of("1.0", "6.0", "7.0", "-", "Subtraction"),
                Arguments.of("2.0", "3.0", "6.0", "/", "Division"));
    }


}
