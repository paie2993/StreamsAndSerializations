package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.Sum;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class SumSerializer implements SimpleSerializer<Sum> {

    private SumSerializer() {
    }

    private static final class LazyHolder {
        private static final SumSerializer INSTANCE = new SumSerializer();
    }

    public static SumSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final Sum object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public Sum deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (Sum) objectInput.readObject();
        }
    }
}
