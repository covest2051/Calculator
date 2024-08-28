package ru.marat.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.marat.calculator.core.Calculator;
import ru.marat.calculator.factory.OperationFactory;
import ru.marat.calculator.logging.LoggingDecorator;
import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.operations.Addition;
import ru.marat.calculator.operations.Division;
import ru.marat.calculator.operations.Multiplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private ComplexNumber num1;
    private ComplexNumber num2;

    @BeforeEach
    public void setUp() {
        calculator = Calculator.getInstance();
        num1 = new ComplexNumber(3, 2);
        num2 = new ComplexNumber(1, 7);
    }

    @Test
    public void testAddition() {
        Addition addition = new Addition();
        LoggingDecorator additionWithLogging = new LoggingDecorator(addition);
        ComplexNumber result = calculator.calculate(additionWithLogging, num1, num2);
        assertEquals(4, result.getReal());
        assertEquals(9, result.getImaginary());
    }

    @Test
    public void testMultiplication() {
        Multiplication multiplication = new Multiplication();
        LoggingDecorator multiplicationWithLogging = new LoggingDecorator(multiplication);
        ComplexNumber result = calculator.calculate(multiplicationWithLogging, num1, num2);
        assertEquals(-11, result.getReal());
        assertEquals(23, result.getImaginary());
    }

    @Test
    public void testDivision() {
        Division division = new Division();
        LoggingDecorator divisionWithLogging = new LoggingDecorator(division);
        ComplexNumber result = calculator.calculate(divisionWithLogging, num1, num2);
        assertEquals(0.3829787234042553, result.getReal(), 1e-9);
        assertEquals(-0.425531914893617, result.getImaginary(), 1e-9);
    }

    @Test
    public void testFactoryCreation() {
        Addition addition = (Addition) OperationFactory.getOperation("add");
        LoggingDecorator additionWithLogging = new LoggingDecorator(addition);
        ComplexNumber result = calculator.calculate(additionWithLogging, num1, num2);
        assertEquals(4, result.getReal());
        assertEquals(9, result.getImaginary());
    }
}
