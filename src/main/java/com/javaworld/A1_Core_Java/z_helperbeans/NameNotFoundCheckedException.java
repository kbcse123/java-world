package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik Khader
 
It is discouraged to use 'checked' or 'unchecked' words while creating custom exception handler classes. Here it is used for better understanding and readability.
 
 */
public class NameNotFoundCheckedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public NameNotFoundCheckedException(String message) {
        super(message);
	}
	/**
	 * 
	 */
	public NameNotFoundCheckedException(String message, Throwable cause) {
        super(message,cause);
	}
	/**
	 * 
	 */
	public NameNotFoundCheckedException(Throwable cause) {
        super(cause);
	}
	/**
	 * 
	 */
	public NameNotFoundCheckedException() {
        super();
	}
}
