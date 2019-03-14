package model;

/**
 * @author Peter Vukas Thrown when a key value is improperly formatted
 */
public class InvalidKeyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -261413480813400630L;

	/**
	 * Reason for the exception
	 */
	public final Identifier i;

	/**
	 * Creates this exception given a reason
	 * 
	 * @param i Reason
	 */
	public InvalidKeyException(Identifier i) {
		super();
		this.i = i;
	}

}
