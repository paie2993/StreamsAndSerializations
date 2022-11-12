package com.tora.bigDecimalOperations.withStreams;

import com.tora.bigDecimalOperations.BigDecimalOperations;
import com.tora.bigDecimalOperations.implementationsContainer.InternalOperations;
import com.tora.bigDecimalOperations.implementationsContainer.InternalOperationsImplementations;

import java.math.BigDecimal;
import java.util.List;

public final class BigDecimalOperationsWithStreams implements BigDecimalOperations {

    private final InternalOperations implementations = InternalOperationsImplementations.defaultImplementationsInstance();

    private BigDecimalOperationsWithStreams() {
    }

    private static class LazyHolder {
        private static final BigDecimalOperationsWithStreams INSTANCE = new BigDecimalOperationsWithStreams();
    }

    public static BigDecimalOperationsWithStreams instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BigDecimal sum(final List<BigDecimal> list) {
        return implementations.sum.apply(list);
    }

    @Override
    public BigDecimal average(final List<BigDecimal> list) {
        return implementations.average.apply(list);
    }

    @Override
    public List<BigDecimal> topTen(final List<BigDecimal> list) {
        return implementations.topTen.apply(list);
    }

    @Override
    public List<BigDecimal> generate(final BigDecimal lowerLimit, final int numbers) {
        return implementations.generate.apply(lowerLimit, numbers);
    }
}











