package com.javaworld.A8_JUnit;

import org.junit.Test;

/**
 * In below 3 test cases, first two fails because they were expecting ArithmeticException which they didn't get while test
 * case execution.
 * 
 * Third test case gets pass because, it was expecting the NullPointerException and test case threw it.
 * 
 * This way you can write your test cases which are dependent on some exceptions to test the behavior of application on 
 * failure.
 */

public class A7_Expected_Exceptions {
	// This test case fails because it was expecting ArithmeticException
	@Test(expected = ArithmeticException.class)
	public void expectArithmeticException() {
		System.out.println("Everything was fine here !!");
	}

	// This test case fails because it was expecting ArithmeticException
	@Test(expected = ArithmeticException.class)
	public void expectArithmeticException2() {
		throw new NullPointerException();
	}

	// This test case passes because it was expecting NullPointerException
	@Test(expected = NullPointerException.class)
	public void expectNullPointerException() {
		// some code which throw NullPointerException in run time
		throw new NullPointerException();
	}

}
