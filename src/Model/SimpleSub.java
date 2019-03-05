package model;

public class SimpleSub implements Decrypt, Encrypt, UsesAlphabet {

	@Override
	public String encrypt(String plainText, String key) throws InvalidKeyException, InvalidTextException {
		if(alphabetCheck(key) == false) {
			throw new InvalidKeyException(Identifier.BAD_KEY_IMPROPER_ALPHABET);
		}
		char[] plaintxt = plainText.toUpperCase().toCharArray();
		rangeCheck(plaintxt);
		for(int i = 0; i < plaintxt.length; i++) {
			plaintxt[i] = key.charAt(alphabet.indexOf(plaintxt[i]));
		}
		return new String(plaintxt);
	}

	@Override
	public String decrypt(String cipherText, String key) throws InvalidKeyException, InvalidTextException {
		if(alphabetCheck(key) == false) {
			throw new InvalidKeyException(Identifier.BAD_KEY_IMPROPER_ALPHABET);
		}char[] ciphertxt = cipherText.toUpperCase().toCharArray();
		rangeCheck(ciphertxt);
		for(int i = 0; i < ciphertxt.length; i++) {
			ciphertxt[i] = alphabet.charAt(key.indexOf(ciphertxt[i]));
		}
		return new String(ciphertxt);
	}

}
