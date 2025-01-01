package com.javaworld.A8_JUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Rather than specifying timeout attribute for all tests separately, we can define JUnit Rule for all tests in a class.
 */

public class A9_TimeOut_Global {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(3);

	@Test
	public void testGlobal1() {
		System.out.println("testGlobal1 Execution Started....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("testGlobal1 " + e.getMessage());
		}
	}

	@Test
	public void testGlobal2() {
		System.out.println("testGlobal2 Execution Started....");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("testGlobal2 " + e.getMessage());
		}
	}
}
