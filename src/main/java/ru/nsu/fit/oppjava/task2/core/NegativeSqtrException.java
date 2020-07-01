package ru.nsu.fit.oppjava.task2.core;

public class NegativeSqtrException extends CalculatorException {
    @Override
    public String getMyMessage() {
        return "Negative number!";
    }
}
