package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.OneTenth;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class OneTenthSerializer implements SimpleSerializer<OneTenth> {

    private OneTenthSerializer() {
    }

    private static final class LazyHolder {
        private static final OneTenthSerializer INSTANCE = new OneTenthSerializer();
    }

    public static OneTenthSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final OneTenth object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public OneTenth deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (OneTenth) objectInput.readObject();
        }
    }
}
