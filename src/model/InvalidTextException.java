package model;

public class InvalidTextException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699384096321955749L;
	public final Identifier i;

	public InvalidTextException(Identifier i) {
		super();
		this.i = i;
	}
}
