package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.CalculatorException;
import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;

public class Exit implements Command {
    ExecutionContext context;

    public Exit(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() { return "EXIT";}

    @Override
    public void execute() throws CalculatorException {
        System.exit(0);
    }
}