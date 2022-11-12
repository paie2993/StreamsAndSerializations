package com.tora.serializers.simple;

import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.Serializable;

public interface SimpleSerializer<T extends Serializable> extends Serializer {

    void serialize(final String fileName, final T object) throws IOException;

    T deserialize(final String fileName) throws IOException, ClassNotFoundException;
}
