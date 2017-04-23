package com.gv.archive.cryptography.implementations;

import com.gv.archive.cryptography.interfaces.Cryptographer;
import org.junit.Assert;
import org.junit.Test;

public class CryptographerXORTest {

    private Cryptographer cryptographer = new CryptographerXOR();
    private String testStr;
    private String encryptStr;

    @Test
    public void encryptAndDecryptWithShortStrTest() throws Exception {
        testStr = "44447777";
        encryptStr = cryptographer.encrypt(testStr);
        String errorMessage = "Values of original and decrypt strings are different.";
        Assert.assertEquals(errorMessage ,testStr, cryptographer.decrypt(encryptStr));
    }

    @Test
    public void encryptAndDecryptWithEmptyStrTest() throws Exception {
        testStr = "";
        encryptStr = cryptographer.encrypt(testStr);
        String errorMessage = "Result string after decrypting is not empty as original.";
        Assert.assertEquals(errorMessage, testStr, cryptographer.decrypt(encryptStr));
    }

    @Test
    public void encryptAndDecryptWithNullStrTest() throws Exception {
        testStr = null;
        encryptStr = cryptographer.encrypt(testStr);
        String errorMessage = "Result result of encrypting null must be also null.";
        Assert.assertNull(errorMessage, encryptStr);
    }

    @Test
    public void encryptAndDecryptWithComplicatedStrTest() throws Exception {
        testStr = "hello hello hello hello hello 4444 7777!!! Test Test";
        encryptStr = cryptographer.encrypt(testStr);
        String errorMessage = "Values of original and decrypt strings are different.";
        Assert.assertEquals(errorMessage, testStr, cryptographer.decrypt(encryptStr));
    }
}

