/**
 * Good written tests are assets while badly written tests are burden to your application. 
 * Acronym FIRST stand for: Fast Isolated Repeatable Self-validating Timely
 * 
 * If you follow these five principles in writing your unit tests, you will have more robust unit tests and thus more 
 * stable application code. Let-s learn about these FIRST principles - in detail.
 * 
 * Fast:
 * 
 * Unit tests should be fast otherwise they will slow down your development/deployment time and will take longer time to 
 * pass or fail. Typically on a sufficient large system, there will be few thousand unit tests - let's say 2000 unit tests.
 * If average unit test take 200 milliseconds to run (which shall be considered fast), then it will take 6.5 minutes to run
 * complete suite.
 * One of the major cause of slow tests is dependency that must handle external necessities such as databases, files, and
 * network calls. They take thousands of milliseconds. So to make suite fast, you must avoid creating these dependencies
 * by using mock testing.
 * 
 * Isolated:
 * 
 * Never ever write tests which depend on other test cases.To make situation worse, you may end up spending more time in 
 * figuring out which test in the chain has caused the failure. In best case scenario, you should be able to run any one 
 * test at any time, in any order.
 * The Single Responsibility Principle (SRP) of SOLID Class-Design Principles says that classes should be small and 
 * single-purpose. This can be applied to your tests as well.
 * 
 * Repeatable:
 * 
 * A repeatable test is one that produces the same results each time you run it. To accomplish repeatable tests, you must
 * isolate them from external environment that is not under your direct control. In these cases, use mock objects, They 
 * have been designed for this very purpose.
 * 
 * Self-validating:
 * 
 * A self-validating test must be able to determine that the output is expected or not, it is failed or pass. There must 
 * be no manual interpretation of results. Manually verifying the results of tests is a time-consuming process that can
 * also introduce more risk. Create in-memory database, create schema and put dummy data and then test the code. In this
 * way, you can run this test N number of times without fearing any external factor which can affect test execution and 
 * it's result.
 * 
 * Timely:
 * 
 * Practically, You can write unit tests at any time. You can wait upto code is production ready or you are better off 
 * focusing on writing unit tests in a timely fashion. As a suggestion, you should have guidelines or strict rules around 
 * unit testing. You can use review processes or even automated tools to reject code without sufficient tests.
 * 
 * Bonus Tip: If you use Eclipse or IntelliJ IDEA, consider incorporating a tool like Infinitest. As you make changes to 
 * your system, Infinitest identifies and runs (in the background) any tests that are potentially impacted.
 */
