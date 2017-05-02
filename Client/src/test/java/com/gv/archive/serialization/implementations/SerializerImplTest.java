package com.gv.archive.serialization.implementations;

import com.gv.archive.communication.implementations.BasicRequest;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.serialization.interfaces.Serializer;
import org.junit.Assert;
import org.junit.Test;
import java.io.*;

public class SerializerImplTest {

    private final static String FILE_PATH = "src" + File.separator + "test" + File.separator + "java" +
            File.separator + "com" + File.separator  + "gv" + File.separator + "archive" +
            File.separator + "serialization" + File.separator  + "serialization";

    private Serializer serializer = new SerializerImpl();

    @Test
    public void serializeAndDeserializeTestWithString() throws Exception {
        String testStr = "Hello, baby!";

        OutputStream fileOutputStream = new FileOutputStream(FILE_PATH );
        Assert.assertTrue(serializer.serialize(testStr, fileOutputStream));

        InputStream fileInputStream = new FileInputStream(FILE_PATH );
        String str = (String)serializer.deserialize(fileInputStream);
        Assert.assertEquals(str, testStr);

        fileOutputStream.close();
        fileInputStream.close();
    }

    @Test
    public void serializeAndDeserializeTestWithEmptyString() throws Exception {
        String emptyString = "";

        OutputStream fileOutputStream = new FileOutputStream(FILE_PATH );
        Assert.assertTrue(serializer.serialize(emptyString, fileOutputStream));

        InputStream fileInputStream = new FileInputStream(FILE_PATH );
        String str = (String)serializer.deserialize(fileInputStream);
        Assert.assertEquals(str, emptyString);

        fileOutputStream.close();
        fileInputStream.close();
    }

    @Test
    public void serializeTestWithNull() throws Exception {
        OutputStream fileOutputStream = new FileOutputStream(FILE_PATH );
        Assert.assertFalse(serializer.serialize(null, fileOutputStream));

        fileOutputStream.close();
    }

    @Test
    public void serializeTestWithInterfaces() throws Exception {
        Request before = new BasicRequest("GET", "hello");

        OutputStream fileOutputStream = new FileOutputStream(FILE_PATH );
        serializer.serialize(before, fileOutputStream);

        InputStream fileInputStream = new FileInputStream(FILE_PATH );
        Request after = (Request)serializer.deserialize(fileInputStream);

        Assert.assertEquals(before.getRequestType(), after.getRequestType());
        Assert.assertEquals(before.getRequestBody(), after.getRequestBody());
    }
}