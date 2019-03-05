package model;

public interface Encrypt {
	public String encrypt (String plainText, String key) throws InvalidTextException, InvalidKeyException;
}
