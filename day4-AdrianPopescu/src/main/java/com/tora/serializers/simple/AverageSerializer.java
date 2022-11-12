package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.Average;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class AverageSerializer implements SimpleSerializer<Average> {

    private AverageSerializer() {
    }

    private static final class LazyHolder {
        private static final AverageSerializer INSTANCE = new AverageSerializer();
    }

    public static AverageSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final Average object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public Average deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (Average) objectInput.readObject();
        }
    }
}
