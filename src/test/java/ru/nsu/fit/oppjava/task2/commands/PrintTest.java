package ru.nsu.fit.oppjava.task2.commands;

import java.io.PrintWriter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

public class PrintTest {
    
    public PrintTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(new PrintWriter(System.out));
        Print instance = new Print(context, null);
        
        assertThrows(MyEmptyStackException.class, () -> instance.execute());
        
        context.stackPush(10);
        assertDoesNotThrow(() -> instance.execute());
        assertTrue(context.stackSize() == 1);
    }
    
}
