package com.tora.calculator.rules.binary;

import com.tora.calculator.rules.Rule;
import com.tora.program.InternalForm;
import com.tora.structure.StructureMatcher;

import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.*;

public abstract class BinaryRule extends Rule {

    @Override
    protected boolean matchStructure(InternalForm internalForm) {
        return StructureMatcher.match(internalForm, binaryStructure);
    }

    @Override
    public final Optional<Double> compute(InternalForm internalForm) {
        if (matchSyntax(internalForm)) {
            final double firstValue = internalForm.getValue(binaryFirstValueIndex);
            final double secondValue = internalForm.getValue(binarySecondValueIndex);
            return execute(firstValue, secondValue);
        }
        return Optional.empty();
    }

    protected abstract Optional<Double> execute(final double first, final double second);
}
