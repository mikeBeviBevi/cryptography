/*
 * This interface provides funcationality for various crypto machines
 * A crypto machine executes algorithims to encrypt or decrypt messages
 * Each crypto machine should be limted to one particular cipher
 * See Crypto.GUI package for user I/O handeling.
 */
package CryptoMachines;
import java.util.ArrayList;
//import java.util.Arrays;
/**
 *
 * @author Michael Bevilacqua (Bevi)
 * @version 09/2013
 * @
 */
public interface CryptoMachine {
    
    //this is a collection of English alphabet characters (A-Z)
     /**
     *
     */
    public char[] alphabet ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    // if need for an arraylist then uncomment below
    // public ArrayList alphabet = new ArrayList(Arrays.asList(array));
    
    /**method to encrypt a plain text message broken into a collection of characters
     * @param key 
     * @param message 
     * @return  
    */
    String encrypt (String key, String message);
    
    /**method to decrypt a cipher text message broken into a collection of characters
     *  @param key
     * @param message
     * @return  
    */
    String decrypt (String key, String message);
}
