package model;

/**
 * @author Peter Vukas Cryptographic classes which have a decryption method
 */
public interface Decrypt {
	/**
	 * @param cipherText Encrypted text to be decrypted
	 * @param key        The key which may decrypt the cipher text
	 * @return Plain text given by the given key
	 * @throws InvalidTextException An error with the format of the plain text
	 *                              preventing the decryption from continuing
	 * @throws InvalidKeyException  An error with the format of the key preventing
	 *                              decryption from continuing
	 */
	public String decrypt(String cipherText, String key) throws InvalidKeyException, InvalidTextException;
}
