package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.Divide;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class DivideSerializer implements SimpleSerializer<Divide> {

    private DivideSerializer() {
    }

    private static final class LazyHolder {
        private static final DivideSerializer INSTANCE = new DivideSerializer();
    }

    public static DivideSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final Divide object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public Divide deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (Divide) objectInput.readObject();
        }
    }
}