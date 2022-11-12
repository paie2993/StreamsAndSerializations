package com.tora.serializers.simple;

import com.tora.bigDecimalOperations.operationsSpecifications.topTen.TopTen;
import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class TopTenSerializer implements SimpleSerializer<TopTen> {

    private TopTenSerializer() {
    }

    private static final class LazyHolder {
        private static final TopTenSerializer INSTANCE = new TopTenSerializer();
    }

    public static TopTenSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final TopTen object) throws IOException {
        try (final ObjectOutput objectOutput = Serializer.openOutputStream(fileName)) {
            objectOutput.writeObject(object);
        }
    }

    @Override
    public TopTen deserialize(final String fileName) throws IOException, ClassNotFoundException {
        try (final ObjectInput objectInput = Serializer.openInputStream(fileName)) {
            return (TopTen) objectInput.readObject();
        }
    }
}
