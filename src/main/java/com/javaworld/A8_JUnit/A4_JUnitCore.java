package com.javaworld.A8_JUnit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * JUnitCore is an inbuilt class in JUnit package that is used to run specified test classes.
 * 
 * It is based on facade design pattern.
 * 
 * To run test classes from command prompt manually, we can run following command from console. test classes must be 
 * separated by space:  $ java org.junit.runner.JUnitCore TestFeatureOne TestFeatureTwo
 * 
 * It is highly advisable to create JUnit suites and execute application wide all test cases.
 */
@SuppressWarnings("rawtypes")
public class A4_JUnitCore {

	public static void main(String[] args) {
		List<Class> testCases = new ArrayList<>();
		testCases.add(A1_WritingTests.class);
		testCases.add(Assumptions.class);
		for (Class testCase : testCases) {
			runTestCase(testCase);
		}
	}

	private static void runTestCase(Class testCase) {
		Result result = JUnitCore.runClasses(testCase);
		System.out.println("Runtime= " + result.getRunTime());
		if (result.getFailureCount() > 0) {
			System.out.println("Errors Found while Executing Test " + testCase);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		} else {
			System.out.println("No Errors found while Executing Test " + testCase);
		}
	}
}
