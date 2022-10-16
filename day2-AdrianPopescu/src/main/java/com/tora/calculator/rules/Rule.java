package com.tora.calculator.rules;

import com.tora.program.InternalForm;

import java.util.Optional;

public abstract class Rule {

    public abstract boolean matchSyntax(InternalForm internalForm);

    public abstract Optional<Double> compute(InternalForm internalForm);

    protected abstract boolean matchStructure(InternalForm internalForm);
}