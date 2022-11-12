package com.tora.bigDecimalOperations.operationsSpecifications.topTen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface TopTen extends Serializable {

    List<BigDecimal> apply(final List<BigDecimal> list);
}
