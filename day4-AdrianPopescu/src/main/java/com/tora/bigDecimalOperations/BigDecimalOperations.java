package com.tora.bigDecimalOperations;

import java.math.BigDecimal;
import java.util.List;

public interface BigDecimalOperations {

    BigDecimal sum(final List<BigDecimal> list);

    BigDecimal average(final List<BigDecimal> list);

    List<BigDecimal> topTen(final List<BigDecimal> list);

    List<BigDecimal> generate(final BigDecimal lowerLimit, final int numbers);
}
