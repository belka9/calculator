package ru.nsu.fit.oppjava.task2.core;

import java.util.logging.Logger;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;

public class Calculator {
    private static final Logger log = Logger.getLogger(Calculator.class.getName());

    private PrintWriter writer;
    private Reader reader;
    private String resource;

    public Calculator(Reader reader, PrintWriter writer, String resource) {
        this.reader = reader;
        this.writer = writer;
        this.resource = resource;
    }

    public void run() {
        Command command;
        log.log(Level.INFO, "Try to create CommandProvider");
        CommandProvider provider = new CommandProvider(reader, writer, resource);
        while ((command = provider.getCommand()) != null) {
            try {
                command.execute();
            } catch (DivByZeroException | MyEmptyStackException ex) {
                log.log(Level.SEVERE, "Error in command \"{0}\": {1}", new Object[]{command.getName(), ex.getMyMessage()});
            } catch (CalculatorException ex) {
                log.log(Level.SEVERE, "Error in command \"{0}\": {1}", new Object[]{command.getName(), ex.getMyMessage()});
            }
        }
    }
}
