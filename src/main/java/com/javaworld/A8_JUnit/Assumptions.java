package com.javaworld.A8_JUnit;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Assumption indicate the conditions in which a test is meaningful. A failed assumption does not mean the code is broken,
 * but that the test provides no useful information.
 * 
 * Assume basically means "don-t run this test if these conditions don-t apply". The default JUnit runner skips tests with
 * failing assumptions.
 */

public class Assumptions {
	@BeforeClass
	public static void setUp() {
		System.out.println("Before setting ENV= "+System.getProperty("ENV"));
		System.setProperty("ENV", "DEV");
		System.out.println("After setting ENV= "+System.getProperty("ENV"));
	}

	@Test
	public void testOnDev() {
		assumeTrue("DEV".equals(System.getProperty("ENV")));
		System.out.println("testOnDev()");
	}
	
	@Test
	public void testOnProd() {
		assumeTrue("PROD".equals(System.getProperty("ENV")));
		System.out.println("testOnProd()");
	}
	
	@Test
	public void testOnProd2() {
		assumeFalse("PROD".equals(System.getProperty("ENV")));
		System.out.println("testOnProd2()");
	}

}
