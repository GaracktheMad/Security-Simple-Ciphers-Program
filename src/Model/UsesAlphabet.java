package model;

public interface UsesAlphabet {
	
	public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";public final char[] staticAlphabet = alphabet.toCharArray();

	public default boolean alphabetCheck(String alphabet) {
		char[] a = alphabet.toUpperCase().toCharArray();
		if (a.length != staticAlphabet.length) {
			return false;
		}
		int[] count = new int[a.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (char c : a) {
			count[Integer.valueOf(c) - Integer.valueOf('A')]++;
		}
		for (int i : count) {
			if (i != 1) {
				return false;
			}
		}
		return true;
	}
	public default void rangeCheck(char[] array) throws InvalidTextException {
		for (char a : array) {
			if (a > 'Z' || a < 'A') {
				throw new InvalidTextException(Identifier.BAD_TEXT_INVALID_CHARACTER);
			}
		}
	}
}
