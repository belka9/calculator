package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;
import ru.nsu.fit.oppjava.task2.core.CalculatorException;

public class Add implements Command {

    ExecutionContext context;

    public Add(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() {
        return "+";
    }

    @Override
    public void execute() throws CalculatorException {
        if (context.stackSize() < 2) {
            throw new MyEmptyStackException();
        }
        
        double val1 = context.stackPop();
        double val2 = context.stackPop();
        context.stackPush(val1 + val2);
    }
}
