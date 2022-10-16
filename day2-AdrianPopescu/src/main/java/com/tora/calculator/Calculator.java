package com.tora.calculator;

import com.tora.calculator.rules.Rule;
import com.tora.program.InternalForm;
import com.tora.types.Functions;

import java.util.*;

import static com.tora.types.Functions.*;

final public class Calculator {

    private static final Set<Functions> functions = new HashSet<>(Arrays.asList(PLUS, MINUS, PRODUCT, DIVISION, MIN, MAX, SQRT));

    public static Set<Functions> functions() {
        return Collections.unmodifiableSet(functions);
    }

    public static Optional<Double> compute(InternalForm internalForm) {
        final Optional<Functions> optionalFun = identifyRule(internalForm);
        if (optionalFun.isPresent()) {
            final Rule rule = optionalFun.get().rule();
            return rule.compute(internalForm);
        }
        return Optional.empty();
    }

    private static Optional<Functions> identifyRule(InternalForm internalForm) {
        return functions.stream().filter(fun -> fun.rule().matchSyntax(internalForm)).findFirst();
    }
}
