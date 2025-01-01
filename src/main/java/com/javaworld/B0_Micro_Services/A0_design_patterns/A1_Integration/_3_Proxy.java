package com.javaworld.B0_Micro_Services.A0_design_patterns.A1_Integration;

/**
 * Problem Statement:
 * When a large, complex application is to be built using microservice architecture, we often need to prepare a unified
 * interface which can do the common work like authentication and authorization before each service call.
 * Solution:
 * Proxy microservice pattern is a variation of the aggregator model. In this model we will use proxy module instead of
 * the aggregation module. Proxy service may call different services individually.
 * In Proxy pattern, we can build one level of extra security by providing a dump proxy layer. This layer acts similar
 * to the interface.
 *
 * Advantages:
 *  .Proxy pattern provides a uniform interface instead of different interface per microservice.
 *  .Proxy pattern allows to apply uniform concerns like logging, security etc at one place.
 *
 */
public class _3_Proxy {
}
