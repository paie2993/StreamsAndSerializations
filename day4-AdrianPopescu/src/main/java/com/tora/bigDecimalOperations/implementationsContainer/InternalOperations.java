package com.tora.bigDecimalOperations.implementationsContainer;

import com.tora.bigDecimalOperations.operationsSpecifications.*;
import com.tora.bigDecimalOperations.operationsSpecifications.topTen.SerializableComparator;
import com.tora.bigDecimalOperations.operationsSpecifications.topTen.TopTen;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class InternalOperations implements Serializable {
    public Sum sum;
    public Divide divide;
    public Average average;
    public SerializableComparator<BigDecimal> comparator;
    public OneTenth oneTenth;
    public TopTen topTen;
    public Generate generate;
}
