package com.tora.calculator.rules.unary;

import com.tora.calculator.rules.Rule;
import com.tora.program.InternalForm;
import com.tora.structure.StructureMatcher;

import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.unaryFunctionValueIndex;
import static com.tora.calculator.rules.RulesProperties.unaryStructure;

public abstract class UnaryRule extends Rule {

    @Override
    protected boolean matchStructure(InternalForm internalForm) {
        return StructureMatcher.match(internalForm, unaryStructure);
    }

    @Override
    public Optional<Double> compute(InternalForm internalForm) {
        if (matchSyntax(internalForm)) {
            final double value = internalForm.getValue(unaryFunctionValueIndex);
            return execute(value);
        }
        return Optional.empty();
    }

    protected abstract Optional<Double> execute(final double value);
}
