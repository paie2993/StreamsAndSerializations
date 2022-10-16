package com.tora.calculator.rules.list;

import com.tora.program.InternalForm;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.listFunctionSymbolIndex;
import static com.tora.types.Functions.MIN;

final public class Min extends ListRule {

    @Override
    public boolean matchSyntax(InternalForm internalForm) {
        if (!matchStructure(internalForm)) {
            return false;
        }
        return internalForm.isTheFunction(listFunctionSymbolIndex, MIN);
    }

    @Override
    protected Optional<Double> execute(final List<Double> values) {
        return Optional.of(Collections.min(values));
    }
}