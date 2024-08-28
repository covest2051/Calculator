package ru.marat.calculator.operations;

import ru.marat.calculator.model.ComplexNumber;
import ru.marat.calculator.model.Operation;

public class Addition implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }
}