package com.tora.bigDecimalOperations.operationsSpecifications;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface Generate extends Serializable {

    List<BigDecimal> apply(final BigDecimal lowerLimit, final int numbers);
}
