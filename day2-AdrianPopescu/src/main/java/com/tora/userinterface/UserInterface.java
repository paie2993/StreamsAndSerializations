package com.tora.userinterface;

import com.tora.calculator.Calculator;
import com.tora.parser.Parser;
import com.tora.program.InternalForm;

import java.util.Optional;
import java.util.Scanner;

final public class UserInterface {


    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Specify stop in lowercase
     */
    private static final String stop = "x";
    private static final String menu =
            "The rules are the following:\n" +
                    "x + / - / * / / y\n" +
                    "min/max x1 x2 x3 x4 ... \n" +
                    "sqrt x\n" +
                    "Introduce the expression from the terminal, replacing x/y/x1/... with your numbers\n" +
                    "Type " + stop + " to exit. Have fun and few bugs (or none at all)";

    public static void run() {
        printMenu();

        boolean done = false;
        while (!done) {
            final String command = getCommand();

            if (command.equals(stop)) {
                done = true;
                continue;
            }

            Optional<Double> result = Optional.empty();

            try {
                result = processCommand(command);
            } catch (final RuntimeException exception) {
                System.out.println(exception.getMessage());
            }

            if (result.isPresent()) {
                System.out.println(result.get());
            } else {
                System.out.println("Wrong syntax");
            }
        }
    }

    private static void printMenu() {
        System.out.println(menu);
    }

    private static String getCommand() {
        return scanner.nextLine().trim().toLowerCase();
    }

    private static Optional<Double> processCommand(final String command) {
        final InternalForm internalForm = Parser.parse(command);
        return Calculator.compute(internalForm);
    }
}
