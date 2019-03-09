package model;

public interface Decrypt {
	public String decrypt (String cipherText, String key) throws InvalidKeyException, InvalidTextException;
}
