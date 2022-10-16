package com.tora.calculator.rules.binary;

import com.tora.program.InternalForm;

import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.*;
import static com.tora.types.Functions.MINUS;

final public class Minus extends BinaryRule {

    @Override
    public boolean matchSyntax(InternalForm internalForm) {
        if (!matchStructure(internalForm)) {
            return false;
        }
        return internalForm.isTheFunction(binaryFunctionSymbolIndex, MINUS);
    }

    @Override
    protected Optional<Double> execute(final double first, final double second) {
        return Optional.of(first - second);
    }
}
