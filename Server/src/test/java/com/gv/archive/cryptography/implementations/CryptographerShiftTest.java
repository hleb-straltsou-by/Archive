package com.gv.archive.cryptography.implementations;

import com.gv.archive.cryptography.interfaces.Cryptographer;
import org.junit.Assert;
import org.junit.Test;

public class CryptographerShiftTest {

    private Cryptographer cryptographer = new CryptographerShift();
    private String testStr;
    private String encryptStr;

    @Test
    public void encryptAndDecryptWithShortStrTest() throws Exception {
        testStr = "44447777";
        encryptStr = cryptographer.encrypt(testStr);
        Assert.assertEquals(testStr, cryptographer.decrypt(encryptStr));
    }

    @Test
    public void encryptAndDecryptWithEmptyStrTest() throws Exception {
        testStr = "";
        encryptStr = cryptographer.encrypt(testStr);
        Assert.assertEquals(testStr, cryptographer.decrypt(encryptStr));
    }

    @Test
    public void encryptAndDecryptWithNullStrTest() throws Exception {
        testStr = null;
        encryptStr = cryptographer.encrypt(testStr);
        Assert.assertEquals(testStr, cryptographer.decrypt(encryptStr));
    }

    @Test
    public void encryptAndDecryptWithComplicatedStrTest() throws Exception {
        testStr = "hello hello hello hello hello 4444 7777!!! Test Test";
        encryptStr = cryptographer.encrypt(testStr);
        Assert.assertEquals(testStr, cryptographer.decrypt(encryptStr));
    }
}