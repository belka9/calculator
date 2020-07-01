package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.PushException;

public class PushTest {
    
    public PushTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Push instance = new Push(context, new String[]{"PUSH"});

        assertThrows(PushException.class, () -> instance.execute());
        
        Push instance1 = new Push(context, new String[]{"PUSH", "a"});
        assertThrows(PushException.class, () -> instance1.execute());
        
        Push instance2 = new Push(context, new String[]{"PUSH", "5"});
        assertDoesNotThrow(() -> instance2.execute());
        assertTrue(context.stackSize()== 1);
        assertTrue(context.stackPeek().equals(5d));
        
        context.definePut("a", new Double(10));
        Push instance3 = new Push(context, new String[]{"PUSH", "a"});
        assertDoesNotThrow(() -> instance3.execute());
        assertTrue(context.stackSize()== 2);
        assertTrue(context.stackPeek().equals(10d));

    }
    
}
