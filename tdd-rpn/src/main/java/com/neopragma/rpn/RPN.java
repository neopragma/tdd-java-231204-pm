package com.neopragma.rpn;

import java.util.Set;
import java.util.Stack;

public class RPN {
    private Stack<String> stack = new Stack<>();
    private Set<String> operators = Set.of("+", "*", "-", "/");
    public String enter(String value) {
        Double value1 = 0.0;
        Double value2 = 0.0;
        if (operators.contains(value)) {
            value1 = Double.valueOf(stack.pop());
            value2 = Double.valueOf(stack.pop());
            if (value.equals("+")) {
                value = String.valueOf(value1 + value2);
            } else if (value.equals("*")) {
                value = String.valueOf(value1 * value2);
            } else if (value.equals("-")) {
                value = String.valueOf(value1 - value2);
            } else if (value.equals("/")) {
                value = String.valueOf(value1 / value2);
            }
        }
        stack.push(value);
        return stack.peek();
    }
}
