package com.tora.types;

import com.tora.calculator.rules.Rule;
import com.tora.calculator.rules.binary.Division;
import com.tora.calculator.rules.binary.Minus;
import com.tora.calculator.rules.binary.Plus;
import com.tora.calculator.rules.binary.Product;
import com.tora.calculator.rules.list.Max;
import com.tora.calculator.rules.list.Min;
import com.tora.calculator.rules.unary.Sqrt;

public enum Functions {
    PLUS("+", new Plus()),
    MINUS("-", new Minus()),
    PRODUCT("*", new Product()),
    DIVISION("/", new Division()),
    MIN("min", new Min()),
    MAX("max", new Max()),
    SQRT("sqrt", new Sqrt());

    private final String symbol;
    private final Rule rule;

    Functions(String symbol, Rule rule) {
        this.symbol = symbol;
        this.rule = rule;
    }

    public String symbol() {
        return symbol;
    }

    public Rule rule() {
        return rule;
    }
}
