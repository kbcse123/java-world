package com.javaworld.A8_JUnit;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Assertions help in validating the expected output with actual output of a test case.
 * 
 * All the assertions are in the org.junit.Assert class and all assert methods are static.
 */

public class Assertions {
	@Test
	public void method() {
		Assert.assertTrue(new ArrayList<>().isEmpty());
	}
}
