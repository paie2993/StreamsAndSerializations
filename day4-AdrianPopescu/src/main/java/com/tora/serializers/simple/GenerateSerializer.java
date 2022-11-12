package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.Generate;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class GenerateSerializer implements SimpleSerializer<Generate> {

    private GenerateSerializer() {
    }

    private static final class LazyHolder {
        private static final GenerateSerializer INSTANCE = new GenerateSerializer();
    }

    public static GenerateSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final Generate object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public Generate deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (Generate) objectInput.readObject();
        }
    }
}
