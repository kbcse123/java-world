package com.javaworld.A8_JUnit;

import com.javaworld.A8_JUnit.A1_WritingTests;
import com.javaworld.A8_JUnit.Assumptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Allow us to test multiple test classes.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        A1_WritingTests.class,
        Assumptions.class
})


public class A5_TestSuite {
}
