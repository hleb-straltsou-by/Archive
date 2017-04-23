package com.gv.archive.cryptography.implementations;

import com.gv.archive.cryptography.interfaces.Cryptographer;
import java.util.ResourceBundle;

/**
 * implements Cryptographer interface according XOR crypt algorithm
 */
public class CryptographerXOR implements Cryptographer {

    /** object for extracting properties from resource bundle cryptoKey.properties */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("cryptoKey");

    /** name of property in resource bundle that correspond to crypto key */
    private static final String KEY_PROPERTY_NAME = "key";

    @Override
    public String encrypt(String str) {
        if(str != null) {
            byte[] key = RESOURCE_BUNDLE.getString(KEY_PROPERTY_NAME).getBytes();
            byte[] text = str.getBytes();
            byte[] result = new byte[str.length()];
            for (int i = 0; i < text.length; i++) {
                result[i] = (byte) (text[i] ^ key[i % key.length]);
            }
            return new String(result);
        }
        return null;
    }

    @Override
    public String decrypt(String str) {
        return encrypt(str);
    }
}
