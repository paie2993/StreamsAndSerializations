package com.tora.calculator.rules.unary;

import com.tora.program.InternalForm;

import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.unaryFunctionSymbolIndex;
import static com.tora.types.Functions.SQRT;

final public class Sqrt extends UnaryRule {

    @Override
    public boolean matchSyntax(InternalForm internalForm) {
        if (!matchStructure(internalForm)) {
            return false;
        }
        return internalForm.isTheFunction(unaryFunctionSymbolIndex, SQRT);
    }

    @Override
    protected Optional<Double> execute(final double value) {
        return Optional.of(Math.sqrt(value));
    }
}
