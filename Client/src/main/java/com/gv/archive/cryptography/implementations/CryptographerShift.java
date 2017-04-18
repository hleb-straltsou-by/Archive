package com.gv.archive.cryptography.implementations;

import com.gv.archive.cryptography.interfaces.Cryptographer;

public class CryptographerShift implements Cryptographer {

    @Override
    public String encrypt(String str) {
        if(str != null) {
            StringBuilder strBuilder = new StringBuilder(str);
            for (int i = 0; i < strBuilder.length(); i++) {
                strBuilder.setCharAt(i, (char) (strBuilder.charAt(i) + 1));
            }
            return strBuilder.toString();
        }
        return null;
    }

    @Override
    public String decrypt(String str) {
        if(str != null) {
            StringBuilder strBuilder = new StringBuilder(str);
            for (int i = 0; i < strBuilder.length(); i++) {
                strBuilder.setCharAt(i, (char) (strBuilder.charAt(i) - 1));
            }
            return strBuilder.toString();
        }
        return null;
    }
}