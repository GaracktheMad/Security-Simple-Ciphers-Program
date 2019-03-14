package model;

/**
 * @author Peter Vukas Indicates the alphabet is associated to the class in some
 *         way, and contains tools assocaited with this
 */
public interface UsesAlphabet {

	/**
	 * The alphabet in string format
	 */
	public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * The alphabet as a char array
	 */
	public final char[] staticAlphabet = alphabet.toCharArray();

	/**
	 * Checks a string to see if it is an alphabet
	 * 
	 * @param alphabet String to be checked
	 * @return True if this string is an alphabetical format
	 */
	public default boolean alphabetCheck(String alphabet) {
		char[] a = alphabet.toUpperCase().toCharArray();
		if (a.length != staticAlphabet.length) {
			return false;
		}
		int[] count = new int[a.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		try {
			for (char c : a) {
				count[Integer.valueOf(c) - Integer.valueOf('A')]++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		for (int i : count) {
			if (i != 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if this char array contains only capitalized alphabetical values
	 * 
	 * @param array Char array to be checked
	 * @throws InvalidTextException THrown if an invalid character is found.
	 */
	public default void rangeCheck(char[] array) throws InvalidTextException {
		for (char a : array) {
			if (a > 'Z' || a < 'A') {
				throw new InvalidTextException(Identifier.BAD_TEXT_INVALID_CHARACTER);
			}
		}
	}
}
