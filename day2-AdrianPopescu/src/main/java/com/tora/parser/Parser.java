package com.tora.parser;

import com.tora.calculator.Calculator;
import com.tora.helpers.StringHelper;
import com.tora.program.InternalForm;
import com.tora.types.Functions;

import java.util.*;
import java.util.stream.Collectors;

final public class Parser {

    private static final Set<String> separators = new HashSet<>(Arrays.asList(" ", "\t"));
    private static final String separatorsSequence = StringHelper.concatenate(separators);

    private static final Map<String, Functions> functionMapping = mapSymbolsToFunctions();

    public static InternalForm parse(String sequence) {
        final String[] tokens = tokenize(sequence);
        return createInternalForm(tokens);
    }

    private static String[] tokenize(String sequence) {
        return sequence.split("[" + separatorsSequence + "]" + "+");
    }

    private static InternalForm createInternalForm(String[] tokens) {
        final InternalForm internalForm = new InternalForm();
        Arrays.stream(tokens).forEach(token -> classifyToken(token, internalForm));
        return internalForm;
    }

    private static void classifyToken(String token, InternalForm internalForm) {
        if (functionMapping.containsKey(token)) {
            internalForm.addFunction(functionMapping.get(token));
        } else {
            final double value = Double.parseDouble(token);
            internalForm.addValue(value);
        }
    }

    private static Map<String, Functions> mapSymbolsToFunctions() {
        return Calculator.functions().stream().collect(Collectors.toMap(Functions::symbol, fun -> fun));
    }
}
