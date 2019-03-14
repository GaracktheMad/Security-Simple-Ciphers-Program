package view;

/**
 * @author Peter Vukas
 * Denotes the currently selected mode
 */
public enum CryptoMode {
	/**
	 * Caesar Shift encryption mode
	 */
	Shift_Encrypt, /**
	 * Caesar Shift decryption mode
	 */
	Shift_Decrypt, /**
	 * Substitution decryption mode
	 */
	SS_Decrypt, /**
	 * Substitution encryption mode
	 */
	SS_Encrypt, /**
	 * Substitution analyze mode
	 */
	SS_Analyze

}
