package com.tora.program;

import com.tora.types.Functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tora.types.Types.FUNCTION;
import static com.tora.types.Types.VALUE;

final public class InternalForm {

    private final List<Term> program = new ArrayList<>();
    private final Table<Functions> functions = new Table<>();
    private final Table<Double> values = new Table<>();

    public List<Term> program() {
        return Collections.unmodifiableList(program);
    }

    public void addFunction(Functions fun) {
        final int index = functions.add(fun);
        program.add(new Term(FUNCTION, index));
    }

    public void addValue(Double value) {
        final int index = values.add(value);
        program.add(new Term(VALUE, index));
    }

    public boolean isFunction(int index) {
        return program.get(index).type() == FUNCTION;
    }

    public boolean isValue(int index) {
        return program.get(index).type() == VALUE;
    }

    public boolean isTheFunction(int index, Functions fun) {
        if (!isFunction(index)) {
            return false;
        }
        final int functionsTableIndex = program.get(index).index();
        return functions.isEqual(functionsTableIndex, fun);
    }

    public double getValue(int index) {
        int valuesTableIndex = program.get(index).index();
        return values.get(valuesTableIndex);
    }

    public List<Double> getValues() {
        return values.getAll();
    }
}
