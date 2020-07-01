package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.nsu.fit.oppjava.task2.core.DefineException;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;

public class DefineTest {
    
    public DefineTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Define instance = new Define(context, new String[]{"DEFINE", "a"});

        Exception ex = assertThrows(DefineException.class, () -> instance.execute());
        
        Define instance1 = new Define(context, new String[]{"DEFINE", "a", "a"});
        ex = assertThrows(DefineException.class, () -> instance1.execute());
        
        Define instance2 = new Define(context, new String[]{"DEFINE", "a", "5"});
        assertDoesNotThrow(() -> instance2.execute());
        
        assertTrue(context.defineGet("a").equals(5d));
        
        Define instance3 = new Define(context, new String[]{"DEFINE", "a", "50"});
        assertDoesNotThrow(() -> instance3.execute());
        
        assertTrue(context.defineGet("a").equals(50d));
    }
    
}
