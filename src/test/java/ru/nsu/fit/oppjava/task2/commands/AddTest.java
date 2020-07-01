package ru.nsu.fit.oppjava.task2.commands;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class AddTest {

    public AddTest() {
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ExecutionContext context = new ExecutionContext(null);
        Add instance = new Add(context, null);

        context.stackPush(10);

        Exception ex = assertThrows(MyEmptyStackException.class, () -> instance.execute());

        context.stackPush(5);

        assertDoesNotThrow(() -> instance.execute());

        assertTrue(instance.context.stackPeek().equals(15d));
    }

}
