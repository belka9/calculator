package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.CalculatorException;
import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

public class Mul implements Command {

    ExecutionContext context;

    public Mul(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public void execute() throws CalculatorException {
        if (context.stackSize() < 2) {
            throw new MyEmptyStackException();
        }

        double val2 = context.stackPop();
        double val1 = context.stackPop();
        context.stackPush(val1 * val2);
    }
}
