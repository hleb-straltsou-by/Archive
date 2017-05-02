package com.gv.archive.serialization.interfaces;

import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer<T> {

    boolean serialize(T object, OutputStream os);

    T deserialize (InputStream is);
}
