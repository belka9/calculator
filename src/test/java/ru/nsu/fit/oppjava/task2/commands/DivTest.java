package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.DivByZeroException;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

public class DivTest {
    
    public DivTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Div instance = new Div(context, null);

        context.stackPush(10d);

        Exception ex = assertThrows(MyEmptyStackException.class, () -> instance.execute());

        context.stackPush(5d);
        assertDoesNotThrow(() -> instance.execute());

        assertTrue(instance.context.stackPeek().equals(2d));
        
        context.stackPush(0d);
        ex = assertThrows(DivByZeroException.class, () -> instance.execute());
    }
    
}
