package model;

public class InvalidKeyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -261413480813400630L;
	
	public final Identifier i;

	public InvalidKeyException(Identifier i) {
		super();
		this.i = i;
	}
	

}
