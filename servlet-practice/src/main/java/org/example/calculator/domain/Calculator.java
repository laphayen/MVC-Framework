package org.example.calculator.domain;

import org.example.calculator.tobe.*;

import java.util.List;

public class Calculator {

    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator(), new MultiplicationOperator());

    public static int calculate(PositiveNumber positiveOperand1, String operator, PositiveNumber positiveOperand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(positiveOperand1, positiveOperand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
