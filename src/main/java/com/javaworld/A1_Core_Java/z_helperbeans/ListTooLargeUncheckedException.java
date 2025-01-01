package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author 16945

 Do not use 'checked' or 'unchecked' words while creating custom exception handler classes. Here it is used for better understanding and readability.

 */
public class ListTooLargeUncheckedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ListTooLargeUncheckedException(String message) {
        super(message);
	}

}
