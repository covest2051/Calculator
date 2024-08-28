package ru.marat.calculator.app;

import ru.marat.calculator.core.Calculator;
import ru.marat.calculator.factory.OperationFactory;
import ru.marat.calculator.logging.LoggingDecorator;
import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.model.Operation;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = Calculator.getInstance();

        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(1, 4);

        Operation addition = new LoggingDecorator(OperationFactory.getOperation("add"));
        Operation multiplication = new LoggingDecorator(OperationFactory.getOperation("multiply"));
        Operation division = new LoggingDecorator(OperationFactory.getOperation("divide"));

        System.out.println("Addition Result: " + calculator.calculate(addition, num1, num2));
        System.out.println("Multiplication Result: " + calculator.calculate(multiplication, num1, num2));
        System.out.println("Division Result: " + calculator.calculate(division, num1, num2));
    }
}