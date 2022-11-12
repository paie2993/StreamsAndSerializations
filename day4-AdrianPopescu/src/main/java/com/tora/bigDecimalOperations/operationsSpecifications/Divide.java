package com.tora.bigDecimalOperations.operationsSpecifications;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Divide extends Serializable {

    BigDecimal apply(final BigDecimal numerator, final BigDecimal denominator);
}
