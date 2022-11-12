package com.tora.serializers.collection;

import com.tora.serializers.Serializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

public interface CollectionSerializer<T extends Serializable> extends Serializer {

    void serialize(final String fileName, final Collection<T> container) throws IOException;

    Collection<T> deserialize(final String fileName) throws IOException, ClassNotFoundException;
}
