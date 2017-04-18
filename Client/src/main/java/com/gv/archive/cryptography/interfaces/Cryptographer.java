package com.gv.archive.cryptography.interfaces;

/**
 * specifies contract for cryptography algorithm
 */
public interface Cryptographer {

    /**
     * encrypts input string
     * @param str - input string object
     * @return encrypt string object
     */
    String encrypt(String str);

    /**
     * decrypts input string
     * @param str - input string object
     * @return decrypt string object
     */
    String decrypt(String str);
}



