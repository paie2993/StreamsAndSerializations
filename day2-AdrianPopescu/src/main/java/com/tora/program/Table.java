package com.tora.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final public class Table<T> {

    private final List<T> values = new ArrayList<>();

    public int add(T value) {
        values.add(value);
        return values.lastIndexOf(value);
    }

    public boolean isEqual(int index, T value) {
        return values.get(index).equals(value);
    }

    public T get(int index) {
        return values.get(index);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(values);
    }
}
