package com.tora.calculator;

import java.util.*;

public class CommandLineCalculator implements Calculator {

    private final Scanner scanner = new Scanner(System.in);

    private final static String menu = "'X' to quit";

    public void run() {
        boolean done = false;
        while (!done) {
            String command = scanner.nextLine();



        }
    }

}

interface SyntaxRule {
    boolean match(List<String> tokens);
}

class BinaryRule implements SyntaxRule {

    public final static Set<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*", "/")) ;

    @Override
    public boolean match(List<String> tokens) {
        if (tokens.size() != 3) {
            return false;
        }
        return operators.contains(tokens.get(1));
    }
}