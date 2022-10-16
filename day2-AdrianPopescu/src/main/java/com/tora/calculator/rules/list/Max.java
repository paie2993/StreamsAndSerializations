package com.tora.calculator.rules.list;

import com.tora.program.InternalForm;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.tora.calculator.rules.RulesProperties.listFunctionSymbolIndex;
import static com.tora.types.Functions.MAX;

final public class Max extends ListRule {

    @Override
    public boolean matchSyntax(InternalForm internalForm) {
        if (!matchStructure(internalForm)) {
            return false;
        }
        return internalForm.isTheFunction(listFunctionSymbolIndex, MAX);
    }

    @Override
    protected Optional<Double> execute(final List<Double> values) {
        return Optional.of(Collections.max(values));
    }
}
