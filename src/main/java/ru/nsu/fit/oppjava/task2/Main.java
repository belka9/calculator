package ru.nsu.fit.oppjava.task2;

import java.util.logging.Logger;
import ru.nsu.fit.oppjava.task2.core.Calculator;
import ru.nsu.fit.oppjava.task2.providers.ReaderProvider;
import ru.nsu.fit.oppjava.task2.providers.WriterProvider;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.log(Level.INFO, "Program begins, try to get reader/writer");
        try (Reader reader = new ReaderProvider(args).get();
            PrintWriter writer = new WriterProvider(args).get()) {
            String resource = "/Resource.properties";
            log.log(Level.INFO, "Create calculator");
            Calculator calculator = new Calculator(reader, writer, resource);
            log.log(Level.INFO, "Run calculator");
            calculator.run();
            log.log(Level.INFO, "Calculator has completed work");
        } catch (IOException io) {
            log.log(Level.SEVERE, "Main error: {0}", io.getMessage());
        }
    }
}
