package com.tora.program;

import com.tora.types.Types;

final public class Term {

    private final Types type;
    private final int index;

    public Term(Types type, int index) {
        this.type = type;
        this.index = index;
    }

    public Types type() {
        return type;
    }

    public int index() {
        return index;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Term)) {
            return false;
        }
        final Term term = (Term) other;
        return this.type.equals(term.type) && this.index == term.index;
    }
}