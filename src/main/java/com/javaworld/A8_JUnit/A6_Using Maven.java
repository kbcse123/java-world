/**
 * 1) "mvn test" : This command will execute all testcases present inside test folder irrespective of any other criteria.
 * 
 * 2) "mvn -Dtest=Assertions,Assumptions test" : This command will execute one or more test classes separated by comma. 
 * 
 * 3) "mvn -Dtest=Test*Class test" : This command uses wild cards in test class names to match a set of test classes.
 * 
 * 5) "mvn -Dtest=WritingTests#test1 test" : This command will execute only single test case method i.e. test1() inside 
 *                                           test class WritingTests.
 * 
 * 4) "mvn -Dtest=WritingTests#test* test" : This command will execute multiple test cases inside test class with wild card
 *                                           mapping.
 */
