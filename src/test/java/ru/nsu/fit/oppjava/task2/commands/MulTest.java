package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

public class MulTest {
    
    public MulTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Mul instance = new Mul(context, null);

        context.stackPush(10);

        Exception ex = assertThrows(MyEmptyStackException.class, () -> instance.execute());

        context.stackPush(5);

        assertDoesNotThrow(() -> instance.execute());

        assertTrue(instance.context.stackPeek().equals(50d));
    }
    
}
