package com.javaworld.A8_JUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Writing JUnit ordered test cases is considered bad practice. But, still if you caught in a situation where test case 
 * ordering is the only way out then you can use MethodSorters class.
 * 
 * MethodSorters was introduced since JUnit 4.11 release. This class declares three types of execution order, which can be
 * used in your test cases while executing them.
 * 
 *   MethodSorters.DEFAULT - Sorts the test methods in a deterministic, but not predictable, order.
 * 
 *   MethodSorters.JVM - Leaves the test methods in the order returned by the JVM.
 * 
 *   MethodSorters.NAME_ASCENDING - Sorts the test methods by the method name, in lexicographic order, with 
 *   Method.toString() used as a tiebreaker.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class B1_Ordered_Tests {

	@Test
	public void secondTest() {
		System.out.println("Executing second test");
	}

	@Test
	public void thirdTest() {
		System.out.println("Executing third test");
	}

	@Test
	public void firstTest() {
		System.out.println("Executing first test");
	}

}
