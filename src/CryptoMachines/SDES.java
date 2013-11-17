/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CryptoMachines;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Class and interface as described by sdb(2010)
 * http://elvis.rowan.edu/~bergmann/crypto/projects/project2/doc/ concrete
 * functionality coded by Thayer Altman, Brett Fallon, Michael Bevilacqua
 */
public class SDES {

    //static boolean[][] messageBool;
    static boolean[] k1;
    static boolean[] k2;
    static int[] keyPermTen = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};
    static int[] keyPermEight = {5, 2, 6, 3, 7, 4, 9, 8};
    static int[] msgPermEight = {1, 5, 2, 0, 3, 7, 4, 6};
    static int[] msgPermFour = {1, 3, 2, 0};
    static int[] msgExpEight = {3, 0, 1, 2, 1, 2, 3, 0};
    static String[] s0 = {"10", "00", "11", "01", "11", "00", "01", "10", "11", "01", "10", "00", "11", "10", "01", "00"};
    static String[] s1 = {"00", "11", "11", "01", "10", "00", "11", "10", "01", "11", "00", "01", "11", "01", "10", "00"};

    /**
     *
     */
    public SDES() {
    }
    /*
     * 2-demensional array represents [character][8-bit binary]
     */

    private boolean[][] stringToBinary(String msg) {
        boolean[][] returnBool = new boolean[msg.length()][8];
        try {
            String[] byteString = new String[msg.length()];
            byte[] bytes = msg.getBytes("US-ASCII");
            int i = 0;
            for (byte b : bytes) {
                byteString[i] = Integer.toBinaryString(0x100 + b).substring(1);
                i++;
            }
            //System.out.println("break");
            for (int j = 0; j < byteString.length; j++) {
                //for (String s : byteString) {
                for (i = 0; i < byteString[j].length(); i++) {
                    if (byteString[j].charAt(i) == '0') {
                        returnBool[j][i] = false;
                        //charBool[i] = false;
                    } else {
                        returnBool[j][i] = true;
                        //charBool[i] = true;
                    }
                }
            }
            return returnBool;

        } catch (UnsupportedEncodingException uee) {
            System.out.println("Encoding error");
        }
        return new boolean[0][0];
    }

    /*
     * 
     */
    private boolean[] keyStringToBinary(String key, int n) {

        boolean[] returnKey = new boolean[n];
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '0') {
                returnKey[i] = false;
            } else {
                returnKey[i] = true;
            }
        }
        return returnKey;
    }
    /*
     * 
     */

    private boolean[] expOrPermutation(boolean[] b, int[] perm) {
        boolean[] returnKey = new boolean[perm.length];
        for (int i = 0; i < perm.length; i++) {
            returnKey[i] = b[perm[i]];
        }
        return returnKey;
    }

    /*
     * 
     */
    private boolean[] shift(boolean[] b, int n) {
        boolean temp = b[0];
        while (n > 0) {
            for (int i = 0; i < b.length - 1; i++) {
                b[i] = b[i + 1];
            }
            b[b.length - 1] = temp;
            n = n - 1;
        }
        return b;
    }

    /*
     * 
     */
    private boolean[] concat(boolean[] a, boolean[] b) {
        boolean[] leftAndRight = new boolean[a.length + b.length];
        System.arraycopy(a, 0, leftAndRight, 0, a.length);
        System.arraycopy(b, 0, leftAndRight, a.length, b.length);
        return leftAndRight;
    }
    /*
     * 
     */

    private boolean[] xor(boolean[] a, boolean[] b) {
        boolean[] returnBool = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] ^ b[i]) {
                returnBool[i] = true;
            } else {
                returnBool[i] = false;
            }
        }
        return returnBool;
    }

    private int booleanToInteger(boolean[] b) {
        int returnInt = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                returnInt = returnInt + (int) Math.pow(2, b.length - 1 - i);
            }
        }
        return returnInt;
    }
    /*
     * 
     */

    private void generateKeys(String key) {
        boolean[] keyBool;
        boolean[] leftside;
        boolean[] rightside;

        keyBool = keyStringToBinary(key, 10);//convert 10 digit key to binary
        //keyBool = expOrPermutation(keyBool, keyPermTen);//permutate the key

        //leftside = Arrays.copyOfRange(keyBool, 0, 5);//leftside key
        //rightside = Arrays.copyOfRange(keyBool, 5, 10);//rightside key
        //leftside = shift(leftside, 1);//shift bits
        //rightside = shift(rightside, 1);//shift bits
        k1 = Arrays.copyOfRange(keyBool, 0, 9);
        k2 = Arrays.copyOfRange(keyBool, 1, 10);
//k1 = concat(leftside, rightside);//concat left and right side to make temp k1 10-bit
        //k1 = expOrPermutation(k1, keyPermEight);//make 8 bit k1 key to be used

        //shift(leftside, 2);//shift leftside 2 bits
        //shift(rightside, 2);//shift rightside 2 bits

        //k2 = concat(leftside, rightside);//concat left and right side to make temp k2 10-bit
        //k2 = expOrPermutation(k2, keyPermEight);//make 8 bit k2 key to be used
    }
    /*
     * 
     */

    private boolean[] encryptChar(boolean[] charBool, boolean[] key) {


        boolean[] leftside;
        boolean[] rightside;
        boolean[] rhsExp;
        boolean[] midR;
        boolean[] midL;
        boolean[] sbox0;
        boolean[] sbox1;

        //charBool = expOrPermutation(charBool,msgPermEight);
        leftside = Arrays.copyOfRange(charBool, 0, 4);//leftside msg
        rightside = Arrays.copyOfRange(charBool, 4, 8);//rightside msg

        rhsExp = expOrPermutation(rightside, msgExpEight);//middle expansion
        rhsExp = xor(rhsExp, key);//xor middle
        midL = Arrays.copyOfRange(rhsExp, 0, 4);
        midR = Arrays.copyOfRange(rhsExp, 4, 8);

        sbox0 = keyStringToBinary(s0[booleanToInteger(midL)], 2);//s1
        sbox1 = keyStringToBinary(s1[booleanToInteger(midR)], 2); //s2

        boolean[] returnBool = concat(sbox0, sbox1);//combine the s0 and s1
        //returnBool = expOrPermutation(returnBool,msgPermFour);//4 permutation
        returnBool = xor(returnBool, leftside);//xor
        returnBool = concat(rightside, returnBool);
        return returnBool;
    }
    /*
     * 
     */

    private String encrypt(String message) {
        String returnString = "";
boolean[][] messageBool;
        messageBool = stringToBinary(message);//convert message to binary

        //encrypt each character in message
        for (boolean[] b : messageBool) {
            b = encryptChar(b, k1);
            b = encryptChar(b, k2);
            int temp = booleanToInteger(b);
            char c = (char) temp;
            returnString += c;
            //returnString.concat(Character.toString((char)booleanToInteger(encryptChar(encryptChar(b)))));
        }

        //System.out.println("the return string:" + returnString + "end of string");
        return returnString;
    }

    private String decrypt(String cipherText) {
        String returnString = "";
        boolean[][] messageBool;
        messageBool = stringToBinary(cipherText);//convert message to binary

        //encrypt each character in message
        for (boolean[] b : messageBool) {
            b = encryptChar(b, k2);
            b = encryptChar(b, k1);
            int temp = booleanToInteger(b);
            char c = (char) temp;
            returnString += c;
            //returnString.concat(Character.toString((char)booleanToInteger(encryptChar(encryptChar(b)))));
        }

      //  System.out.println("the return string:" + returnString + "end of string");
        return returnString;
    }


    /*
     * this uses UTF-8 encoding for ascii values
     */
    public static void main(String[] args) {
        SDES sdes = new SDES();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your 10-bit Key: ");
        String key = scanner.nextLine();
        sdes.generateKeys(key);

        System.out.println("Enter your message: ");
        String message = scanner.nextLine();
        String cipherText =sdes.encrypt(message);
        System.out.println("Your encrypted message: " + cipherText);//your encrypted message
        String originalMsg =sdes.decrypt(cipherText);
        System.out.println("Decrypted message: "+originalMsg);
        
        //testing
        String temp = "clubs";
        System.out.println('\n' + temp+ '\n');
        System.out.println("This the thing: ");
                boolean[][] b = sdes.stringToBinary(temp);
                for(int i = 0; i < b.length; i++)
                {
                    System.out.println(Arrays.toString(sdes.concat(b[i],b[i])));
                }
                boolean[]x = {true,false,true,false};
                        
                System.out.println(Arrays.toString(sdes.expOrPermutation(x,sdes.msgExpEight)));
//end testing

    }
}
