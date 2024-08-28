package ru.marat.calculator.factory;

import ru.marat.calculator.model.Operation;
import ru.marat.calculator.operations.Addition;
import ru.marat.calculator.operations.Division;
import ru.marat.calculator.operations.Multiplication;

public class OperationFactory {
    public static Operation getOperation(String operation) {
        switch (operation) {
            case "add":
                return new Addition();
            case "multiply":
                return new Multiplication();
            case "divide":
                return new Division();
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }
}