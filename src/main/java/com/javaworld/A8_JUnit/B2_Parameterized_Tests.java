package com.javaworld.A8_JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A parameterized test is normal test, which is executed over and over again using different test parameters. 
 * It helps developer to save time in executing same test with different input types to test function robustness and
 * possibly function boundaries.
 * 
 * Parameterized test make use of @RunWith annotation along with @Parameters annotations to feed inputs.
 */

@RunWith(Parameterized.class)
public class B2_Parameterized_Tests {
	private Integer inputNumber;
	private Boolean expectedResult;
	private PrimeNumberChecker primeNumberChecker = new PrimeNumberChecker();

	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	// from parameters we defined in primeNumbers() method

	public B2_Parameterized_Tests(Integer inputNumber, Boolean expectedResult) {
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } });
	}

	// This test will run 5 times since we have 5 parameters defined
	@Test
	public void testPrimeNumberChecker() {
		System.out.println("Parameterized Number is : " + inputNumber);
		assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
	}
}

class PrimeNumberChecker {
	public Boolean validate(final Integer primeNumber) {
		for (int i = 2; i < (primeNumber / 2); i++) {
			if (primeNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
}
