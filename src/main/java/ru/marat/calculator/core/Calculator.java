package ru.marat.calculator.core;

import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.model.Operation;

public class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public ComplexNumber calculate(Operation operation, ComplexNumber a, ComplexNumber b) {
        return operation.execute(a, b);
    }
}