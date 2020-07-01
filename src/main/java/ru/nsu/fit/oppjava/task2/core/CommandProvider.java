package ru.nsu.fit.oppjava.task2.core;

import java.util.logging.Logger;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;

public class CommandProvider {
    private static final Logger log = Logger.getLogger(CommandProvider.class.getName());

    private Scanner scanner;
    private ExecutionContext context;
    CommandList commandList;

    public CommandProvider(Reader reader, PrintWriter writer, String resource) {
        scanner = new Scanner(reader);
        context = new ExecutionContext(writer);
        commandList = new CommandList(resource);
        log.info("CommandProvider was created");
    }

    public Command getCommand() {
        String[] args;
        try {
            while (true) {
                try {
                    if (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        log.log(Level.INFO, "Got command: {0}", line);
                        args = line.split(" ");
                        if (args.length == 0) {
                            throw new IllegalCommandException(line);
                        }
                        if (!commandList.containsKey(args[0])) {
                            throw new IllegalCommandException(args[0]);
                        }
                        return commandList.get(args[0], context, args);
                    } else {
                        return null;
                    }
                } catch (IllegalCommandException ex) {
                    log.log(Level.SEVERE, ex.getMyMessage());
                }
            }
        } catch (CommandListException cl){
            log.log(Level.SEVERE, cl.getMyMessage());
            return null;
        }

    }
}
