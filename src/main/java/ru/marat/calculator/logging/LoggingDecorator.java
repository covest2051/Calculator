package ru.marat.calculator.logging;

import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.model.Operation;

import java.util.logging.Logger;

public class LoggingDecorator implements Operation {
    private final Operation operation;
    private static final Logger logger = Logger.getLogger(LoggingDecorator.class.getName());

    public LoggingDecorator(Operation operation) {
        this.operation = operation;
    }

    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        logger.info("Executing operation with operands: " + a + " and " + b);
        ComplexNumber result = operation.execute(a, b);
        logger.info("Result: " + result);
        return result;
    }
}
