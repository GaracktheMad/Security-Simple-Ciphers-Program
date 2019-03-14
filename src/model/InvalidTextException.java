package model;

/**
 * @author Peter Vukas
 * Thrown if plain or cipher text is formatted incorrectly
 */
public class InvalidTextException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699384096321955749L;
	/**
	 * Reason the format is incorrect
	 */
	public final Identifier i;

	/**
	 * Creates this exception, given a reason
	 * 
	 * @param i Reason for this exception
	 */
	public InvalidTextException(Identifier i) {
		super();
		this.i = i;
	}
}
