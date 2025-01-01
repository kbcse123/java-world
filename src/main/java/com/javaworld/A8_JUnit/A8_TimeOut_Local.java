package com.javaworld.A8_JUnit;

import org.junit.Test;

/**
 * Sometimes, we have to write JUnit tests where we have to access some external systems on network. This is never 100% 
 * certainty that these external systems will be available while executing the test cases. That's why it is advisable
 * to use timeout property of JUnit framework while writing test cases with external dependencies.
 * 
 * Each JUnit test is run in a new thread. If the specified timeout elapses before the test completes, its execution is 
 * interrupted via Thread.interrupt().
 * 
 * To specify timeout period of a certain test case, 'timeout' attribute is mentioned on annotation @Test.
 */

public class A8_TimeOut_Local {

	@Test(timeout = 3000)
	public void testLocal1() {
		System.out.println("testLocal1 Execution Started....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("testLocal1 " + e.getMessage());
		}
	}

	@Test(timeout = 3000)
	public void testLocal2() {
		System.out.println("testLocal2 Execution Started....");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("testLocal2 " + e.getMessage());
		}
	}

}
