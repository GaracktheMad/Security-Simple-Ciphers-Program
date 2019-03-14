package model;

/**
 * @author Peter Vukas
 * Cryptographic classes which have an encryption method
 */
public interface Encrypt {
	/**
	 * Contains the associated encryption algorithm for a given class
	 * 
	 * @param plainText Text to be encrypted
	 * @param key       Associated key to encrypt with
	 * @return Encrypted cipher text
	 * @throws InvalidTextException An error with the format of the plain text
	 *                              preventing the encryption from continuing
	 * @throws InvalidKeyException  An error with the format of the key preventing
	 *                              encryption from continuing
	 */
	public String encrypt (String plainText, String key) throws InvalidTextException, InvalidKeyException;
}
