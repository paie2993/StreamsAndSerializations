package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.topTen.BigDecimalComparator;
import com.tora.bigDecimalOperations.operationsSpecifications.topTen.SerializableComparator;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;

public final class BigDecimalComparatorSerializer implements SimpleSerializer<SerializableComparator<BigDecimal>> {

    private BigDecimalComparatorSerializer() {
    }

    private static final class LazyHolder {
        private static final BigDecimalComparatorSerializer INSTANCE = new BigDecimalComparatorSerializer();
    }

    public static BigDecimalComparatorSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final SerializableComparator<BigDecimal> object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public SerializableComparator<BigDecimal> deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (BigDecimalComparator) objectInput.readObject();
        }
    }
}
