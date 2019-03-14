package model;

/**
 * @author Peter Vukas Encrypts and Decrypts text via the
 */
public class Caesar implements Decrypt, Encrypt, UsesAlphabet {
	/**
	 * Temporary shifted alphabet
	 */
	private char[] alpha = new char[26];

	@Override
	public String encrypt(String plainText, String key) throws InvalidTextException, InvalidKeyException {
		char[] plaintxt = plainText.toUpperCase().toCharArray();
		rangeCheck(plaintxt);
		try {
			shiftAlphabet(Integer.valueOf(key));
		} catch (NumberFormatException e) {
			throw new InvalidKeyException(Identifier.BAD_KEY_INT);
		}
		for (int i = 0; i < plaintxt.length; i++) {
			plaintxt[i] = alpha[Integer.valueOf(plaintxt[i]) - Integer.valueOf('A')];
		}
		return new String(plaintxt);
	}

	@Override
	public String decrypt(String cipherText, String key) throws InvalidKeyException, InvalidTextException {
		char[] ciphertxt = cipherText.toUpperCase().toCharArray();
		rangeCheck(ciphertxt);
		try {
			shiftAlphabet(Integer.valueOf(key));
		} catch (NumberFormatException e) {
			throw new InvalidKeyException(Identifier.BAD_KEY_INT);
		}
		String alphabetString = new String(alpha);
		for (int i = 0; i < ciphertxt.length; i++) {
			ciphertxt[i] = staticAlphabet[alphabetString.indexOf(ciphertxt[i])];
		}
		return new String(ciphertxt);
	}

	/**
	 * Creates a shifted alphabet stored in "Alpha"
	 * 
	 * @param shift The integer value of the shifted alphabet
	 */
	private void shiftAlphabet(int shift) {
		int realShift = 0;
		if (shift >= 26) {
			realShift = (int) (shift - (Math.floor(shift / 26) * 26));
		} else if (shift < 0) {
			realShift = 0;
		} else {
			realShift = shift;
		}
		int shifty = 0;
		for (int i = 0; i < staticAlphabet.length; i++) {
			shifty = realShift + i;
			if (shifty >= alpha.length) {
				shifty = shifty - alpha.length;
			}
			alpha[shifty] = staticAlphabet[i];
		}

	}

}
