package com.javaworld.B0_Micro_Services.A0_design_patterns.A1_Integration;

/**
 * Problem Statement:
 *  When a large, complex application is to be built using microservice architecture, we often need to get the combined
 *  result of multiple microservices and show on the application.
 *
 * Solution:
 *  We can define an Aggregator as a simple web module which will act as a load balancer, which means it will call different
 *  services as per requirements. Following is a diagram depicting a simple microservice web app with aggregator design.
 *  As seen in the following image, the "Aggregator" is responsible for calling different services one by one. If we need
 *  to apply any business logic over the results of the service A, B and C, then we can implement the business logic in
 *  the aggregator itself.
 *
 *  An aggregator can be again exposed as another service to the outer world, which can be consumed by others whenever
 *  required. While developing aggregator pattern web service, we need to keep in mind that each of our services A, B
 *  and C should have its own caching layers and it should be full stack in nature.
 *
 */
public class _2_Aggregator {
}
