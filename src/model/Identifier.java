package model;

/**
 * @author Peter Vukas Used to distinguish types of some exceptions.
 */
public enum Identifier {
	/**
	 * Key is not in integer format
	 */
	BAD_KEY_INT,
	/**
	 * Cipher/Plain text uses non-alphabetic characters
	 */
	BAD_TEXT_INVALID_CHARACTER,
	/**
	 * Key uses more letters or incorrect characters associated with an alphabet
	 */
	BAD_KEY_IMPROPER_ALPHABET;
}
