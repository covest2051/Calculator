package ru.marat.calculator.model;

public interface Operation {
    ComplexNumber execute(ComplexNumber a, ComplexNumber b);
}
