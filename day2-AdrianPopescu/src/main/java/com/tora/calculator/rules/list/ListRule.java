package com.tora.calculator.rules.list;

import com.tora.calculator.rules.Rule;
import com.tora.program.InternalForm;
import com.tora.structure.StructureMatcher;

import java.util.List;
import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.listFunctionStructure;

public abstract class ListRule extends Rule {

    @Override
    protected boolean matchStructure(InternalForm internalForm) {
        return StructureMatcher.match(internalForm, listFunctionStructure);
    }

    @Override
    public final Optional<Double> compute(InternalForm internalForm) {
        if (matchSyntax(internalForm)) {
            final List<Double> values = internalForm.getValues();
            return execute(values);
        }
        return Optional.empty();
    }

    protected abstract Optional<Double> execute(final List<Double> values);
}
