package com.javaworld.B0_Micro_Services.A0_design_patterns.A1_Integration;

/**
 * Problem Statement:
 * consider a case where one service needs output of another service as dependency and client can call any service.
 *
 * Solution:
 * We can use Branch Microservices Design Pattern here. Branch microservice pattern is the extended version of aggregator
 * pattern and chain pattern. This pattern is often used in scenarios where a business process involves multiple
 * independent tasks that can be executed concurrently. The Branch pattern allows these tasks to be executed in parallel,
 * reducing the overall execution time of the business process.
 *
 * Here's a simple example of how the Branch Microservice Design Pattern works:
 *
 *  1.The client makes a request to the Branch service.
 *  2.The Branch service splits the request into multiple sub-requests, each corresponding to a task that can be executed
 *  3.independently.
 *  4.The Branch service sends these sub-requests to the appropriate services concurrently.
 *  5.Each of these services processes the sub-request and returns a response to the Branch service.
 *  6.The Branch service waits for all responses, then combines (aggregates) the data from each service into a single
 *  7.response.
 *  8.The Branch service sends the aggregated response to the client.
 *
 * This pattern can significantly improve performance by reducing the overall execution time of the business process.
 * However, it also adds complexity to the system, as the Branch service needs to handle concurrent requests, data
 * aggregation, and error handling.
 *
 * You should use the Branch pattern when:
 *  The business process involves multiple independent tasks that can be executed concurrently.
 *  The performance improvement from parallel execution outweighs the added complexity of managing concurrent requests
 *  and aggregating responses.
 *  The services involved are reliable and can handle concurrent requests without failing or becoming a bottleneck.
 *
 *
 */
public class _6_Branch {
}
