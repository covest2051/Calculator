package ru.marat.calculator.operations;

import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.model.Operation;

public class Multiplication implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginary = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(real, imaginary);
    }
}
