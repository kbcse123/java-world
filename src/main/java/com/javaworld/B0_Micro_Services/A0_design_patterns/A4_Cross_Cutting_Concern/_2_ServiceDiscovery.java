package com.javaworld.B0_Micro_Services.A0_design_patterns.A4_Cross_Cutting_Concern;

/**
 * Problem Statement:
 * In MSA services often run in containerized/virtual environments and their number of instances and location changes
 * dynamically. So we require a mechanism to enable client of a microservice to make requests to dynamically changing
 * service instances.
 *
 * Solution:
 * We can use Service Discovery pattern. To implement this pattern, we need a router/load balancer running at a
 * particular fixed location and a service registry where all microservice instances are registered.
 * Now a client makes a service request, it will come to the load balancer which then inquires the service registry.
 * If service instance is available, then the request is redirected to the available service instance.
 *
 * For More: https://jstobigdata.com/architecture/service-discovery-pattern-in-microservices/
 */
public class _2_ServiceDiscovery {
}
