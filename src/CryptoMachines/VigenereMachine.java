/*
 * This Crypto Machine provides Vigenere cipher encryption/decryption
 * Giovan Battista Bellaso(16th century) is credited with originally describing this encryption method
 * Friedrich Kasiski(1805-1881) is credited with publishing first deciphering method
 */
package CryptoMachines;

import java.util.ArrayList;

/**
 *
 * @author Michael Bevilacqua (Bevi)
 * @author Thayer Altman
 * @author Brett Fallon
 */
public class VigenereMachine implements CryptoMachine {

    @Override
    public String encrypt(String key, String msg) {

        String cipherText = "";
        key = key.toUpperCase();
        msg = msg.toUpperCase();
        int keyLength = key.length();
        for (int i = 0; i < msg.length(); i++) {
            int A = enumerate(msg.charAt(i));

            int B = enumerate(key.charAt(i % keyLength));

            int C = ((A + B) % 26);

            char D = denumerate(C);

            cipherText += D;
        }
        return cipherText;
    }

    @Override
    public String decrypt(String key, String cipherText) {

        String msg = "";
        key = key.toUpperCase();
        cipherText = cipherText.toUpperCase();
        int keyLength = key.length();
        for (int i = 0; i < cipherText.length(); i++) {
            int A = enumerate(cipherText.charAt(i));

            int B = enumerate(key.charAt(i % keyLength));

            int C = ((A - B) % 26);
            //when i gave mod a negative number it returned a negative, so I fixed                   //that.
            if (C < 0) {
                C += 26;
            }

            char D = denumerate(C);

            msg += D;
        }
        return msg;
    }
/**
 * * @param c comment to follow
 */
    private int enumerate(char c) {
        return (int) (c - 65);
    }
/**
 * @param c comment to follow
 */
    private char denumerate(int c) {
        return (char) (c + 65);
    }
}
