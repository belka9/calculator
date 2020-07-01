package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;
import ru.nsu.fit.oppjava.task2.core.CalculatorException;
import ru.nsu.fit.oppjava.task2.core.NegativeSqtrException;

public class Sqrt implements Command {

    ExecutionContext context;

    public Sqrt(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() {
        return "SQRT";
    }

    @Override
    public void execute() throws CalculatorException {
        if (context.stackSize() < 1) {
            throw new MyEmptyStackException();
        }
        if(context.stackPeek() < 0) {
            throw new NegativeSqtrException();
        }
        
        double val = context.stackPop();
        context.stackPush(Math.sqrt(val));
    }
}
