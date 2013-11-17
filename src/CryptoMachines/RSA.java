/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CryptoMachines;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Michael Bevilacqua, Thayer Altman, Brett Fallon
 */
public class RSA {

    /**
     *
     */
    public RSA() {
    }
/*
 * done, needs modification
 */
    private static BigInteger[] inverse(BigInteger a, BigInteger b) {
        // static int[] gcd(int p, int q) {
        if (b.equals(BigInteger.valueOf(0))) {
            return new BigInteger[]{a, BigInteger.valueOf(1), BigInteger.valueOf(0)};
        }
        BigInteger[] vals = inverse(b, a.mod(b));
        BigInteger d = vals[0];
        BigInteger e = vals[2];
        BigInteger f = vals[1].subtract((a.divide(b)).multiply(vals[2]));
        return new BigInteger[]{d, e, f};

        //     return null;
    }

    private static String longTo2Chars(long x) {
//not used we are using BigIntegers
        return "";
    }
/*
 * done
 */
    private static BigInteger modPower(BigInteger b, BigInteger e, BigInteger m) {

        BigInteger hold = b.mod(m);

        for (int i = 1; i < e.intValue(); i++) {
            hold = (hold.multiply(b)).mod(m);
        }

        return hold;
    }
/*
 * done
 */
    private static BigInteger randPrime(int m, int n, java.util.Random rand) {
        //n is not used because we are using BIGIntegers instead of long
        return BigInteger.probablePrime(m, rand);
    }
/*
 * needs work
 */
    private static BigInteger relPrime(BigInteger n, java.util.Random rand) {
     /*   for (BigInteger x = BigInteger.valueOf(rand.nextInt(n.intValue())).subtract(BigInteger.ONE); x.compareTo(BigInteger.valueOf(2)) > 0; x = x.subtract(BigInteger.ONE)) {
            if ((inverse(x, n)[2].max(inverse(x, n)[1])).compareTo(BigInteger.ONE) == 0) {
                return x;
            }
        }
        return relPrime(n, rand);*/
        return null;
    }

    private static void show(long[] cipher) {
    }

    private long toLong(String msg, int p) {
//this is not used
        return 0;
    }

    /*
     * Person class is used ot represent one side of communication which will have their own private
     * and public keys.
     */
    class Person {

        BigInteger publicKey;
        BigInteger privateKey;
        BigInteger exponent;
        BigInteger modulus;
        Random rand;
        /*
         *  Generate a public key for this person, consisting of exponent,e, and modulus, m.
         *  Generate a private key, consisting of an exponent, d.
         *  Provide access to the public key only.
         */

        public Person() {
            rand = new Random();
            //publicKey = RSA.randPrime(128, 0, rand);
            privateKey = RSA.randPrime(128, 0, rand);

            //start product and toeitent

            //end product and toeitent

        }
        /*
         * 
         */

        private String decrypt(long[] cipher) {

            return "";
        }
        /*
         * 
         */

        private BigInteger[] encryptTo(java.lang.String msg, Person she) {


            return new BigInteger[0];
        }
        /*
         * 
         */

        private long getE() {

            return 0;
        }
        /*
         * @return 
         */

        private long getM() {

            return 0;
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //36163 21199
        //System.out.println(RSA.randPrime(1000,new Random()));
        //System.out.println(RSA.inverse(BigInteger.valueOf(120),BigInteger.valueOf(23))[0]);
        //System.out.println(RSA.inverse(BigInteger.valueOf(120),BigInteger.valueOf(23))[1]);
        //System.out.println(RSA.inverse(BigInteger.valueOf(120),BigInteger.valueOf(23))[2]);
        //System.out.println(RSA.relPrime(BigInteger.valueOf(25),new Random()));
        // System.out.println(RSA.modPower(BigInteger.valueOf(4), BigInteger.valueOf(13), BigInteger.valueOf(497)));
    }
}
