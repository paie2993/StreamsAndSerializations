package com.tora.bigDecimalOperations.operationsSpecifications;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public interface Average extends Serializable {

    BigDecimal apply(final Collection<BigDecimal> collection);
}
