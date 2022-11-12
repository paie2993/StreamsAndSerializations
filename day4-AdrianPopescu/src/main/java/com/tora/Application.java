package com.tora;

import com.tora.bigDecimalOperations.withStreams.BigDecimalOperationsWithStreams;
import com.tora.serializers.collection.BigDecimalCollectionSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public final class Application {

    private static final String fileName = "day4-AdrianPopescu/src/main/java/com/tora/serialized.txt";

    public static void main(String[] args) {
        final List<BigDecimal> list = BigDecimalOperationsWithStreams.instance().generate(BigDecimal.ONE, 100);

        try {
            BigDecimalCollectionSerializer.instance().serialize(fileName, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            final Collection<BigDecimal> collection = BigDecimalCollectionSerializer.instance().deserialize(fileName);

            for (final BigDecimal item : collection) {
                System.out.println(item);
            }
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
