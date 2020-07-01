package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;
import ru.nsu.fit.oppjava.task2.core.NegativeSqtrException;

public class SqrtTest {

    public SqrtTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Sqrt instance = new Sqrt(context, null);

        Exception ex = assertThrows(MyEmptyStackException.class, () -> instance.execute());

        context.stackPush(-5);
        
        ex = assertThrows(NegativeSqtrException.class, () -> instance.execute());
        
        context.stackPush(4);

        assertDoesNotThrow(() -> instance.execute());

        assertTrue(instance.context.stackPeek().equals(2d));
    }

}
