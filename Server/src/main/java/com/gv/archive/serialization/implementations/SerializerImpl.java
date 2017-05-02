package com.gv.archive.serialization.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.serialization.interfaces.Serializer;
import java.io.*;

public class SerializerImpl<T> implements Serializer<T> {

    @Override
    public boolean serialize(T object, OutputStream os) {
        boolean flag = false;
        ObjectOutputStream objectStream = null;
        try{
            if(os != null && object != null) {
                objectStream = new ObjectOutputStream(os);
                objectStream.writeObject(object);
                flag = true;
            }
        } catch (IOException e){
            AppLogger.getLogger().error(e);
        } finally {
            try {
                if (objectStream != null) {
                    objectStream.close();
                }
            }catch (IOException e){
                AppLogger.getLogger().error(e);
            }
            return flag;
        }
    }

    @Override
    public T deserialize(InputStream is) {
        ObjectInputStream inputStream = null;
        T object = null;
        try{
            inputStream = new ObjectInputStream(is);
            object = (T)inputStream.readObject();
        } catch (ClassNotFoundException | IOException e){
            AppLogger.getLogger().error(e);
        } finally {
            return object;
        }
    }
}
