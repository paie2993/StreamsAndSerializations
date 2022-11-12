package com.tora.serializers;

import java.io.*;

public interface Serializer {

    static ObjectOutput openOutputStream(final String fileName) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(fileName));
    }

    static ObjectInput openInputStream(final String fileName) throws IOException {
        return new ObjectInputStream(new FileInputStream(fileName));
    }
}
