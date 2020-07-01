package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.*;

public class Div implements Command {

    ExecutionContext context;

    public Div(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public void execute() throws CalculatorException {
        if (context.stackSize() < 2) {
            throw new MyEmptyStackException();
        }
        if(context.stackPeek().equals(0d)) {
            throw new DivByZeroException();
        }
        
        double val2 = context.stackPop();
        double val1 = context.stackPop();
        context.stackPush(val1 / val2);

    }
}
