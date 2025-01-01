package com.javaworld.A8_JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Before - The annotated method will be run before each test method in the test class.
 * 
 * @After - The annotated method will be run after each test method in the test class.
 * 
 * @BeforeClass - The annotated method will be run before all test methods in the test class. This method must be static.
 * 
 * @AfterClass - The annotated method will be run after all test methods in the test class. This method must be static.
 * 
 * @Test - It is used to mark a method as junit test
 * 
 * @Ignore - It is used to disable or ignore a test class or method from test suite.
 * 
 * @FixMethodOrder - This class allows the user to choose the order of execution of the methods within a test class.
 * 
 * @Rule - Annotates fields that reference rules or methods that return a rule.
 * 
 * @ClassRule - Annotates static fields that reference rules or methods that return them.
 */
public class A1_WritingTests {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}

	@Test
	public void test1() {
		System.out.println("method1()");
	}

	@Test
	public void test2() {
		System.out.println("method2()");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
}
