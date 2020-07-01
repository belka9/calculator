package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

public class PopTest {
    
    public PopTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Pop instance = new Pop(context, null);

        Exception ex = assertThrows(MyEmptyStackException.class, () -> instance.execute());
        
        context.stackPush(10);
        assertDoesNotThrow(() -> instance.execute());
        assertTrue(context.stackSize() == 0);
    }
    
}
