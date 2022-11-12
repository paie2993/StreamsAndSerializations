package com.tora.serializers.collection;

import com.tora.serializers.Serializer;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public final class BigDecimalCollectionSerializer implements CollectionSerializer<BigDecimal> {

    private BigDecimalCollectionSerializer() {
    }

    private static final class LazyHolder {
        private static final BigDecimalCollectionSerializer INSTANCE = new BigDecimalCollectionSerializer();
    }

    public static BigDecimalCollectionSerializer instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void serialize(final String fileName, final Collection<BigDecimal> collection) throws IOException {
        try (final ObjectOutput outputStream = Serializer.openOutputStream(fileName)) {
            writeBigDecimals(outputStream, collection);
        }
    }

    @Override
    public Collection<BigDecimal> deserialize(final String fileName) throws IOException, ClassNotFoundException {
        final Collection<BigDecimal> collection = new ArrayList<>();

        try (final ObjectInput inputStream = Serializer.openInputStream(fileName)) {
            readBigDecimalsIntoCollection(inputStream, collection);
        }

        return collection;
    }

    private static void writeBigDecimals(
            final ObjectOutput outputStream,
            final Collection<BigDecimal> collection
    ) throws IOException {
        for (final BigDecimal item : collection) {
            outputStream.writeObject(item);
        }
    }

    private static void readBigDecimalsIntoCollection(
            final ObjectInput inputStream,
            final Collection<BigDecimal> collection
    ) throws IOException, ClassNotFoundException {
        while (true) {
            try {
                final BigDecimal item = readBigDecimal(inputStream);
                collection.add(item);
            } catch (EOFException e) {
                return;
            }
        }
    }

    private static BigDecimal readBigDecimal(final ObjectInput inputStream) throws IOException, ClassNotFoundException {
        return (BigDecimal) inputStream.readObject();
    }
}
