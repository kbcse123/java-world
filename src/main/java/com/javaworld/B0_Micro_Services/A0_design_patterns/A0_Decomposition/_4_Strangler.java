package com.javaworld.B0_Micro_Services.A0_design_patterns.A0_Decomposition;

/**
 * Problem Statement:
 * When a large, complex application is to be built using microservice architecture, the major problem is how to design
 * loosely coupled microservices or to break a large application into small loosely coupled services?
 *
 * Solution:
 * We can define a microservice using strangler pattern. A strangler application has two types of services −
 *  Existing Behavior − These services exhibits the behavior that previously resides in Monolith.
 *  New Functionalities − These services implements new behavior.
 * So over the time of development, microservices increases and monolith shrinks with features moving out from monolith
 * to Strangler Application.
 *
 * Example:
 * Consider an example of an Online Book Store. Initially we have only developed Book Catalog management service and
 * other services are supported in legacy monolith application. During the course of development, more and more services
 * are developed and functionalities are moved away from a monolith.
 *
 * So when a new service is developed, the monolith  strangled, the old component decommissioned and new microservice
 * is deployed and supports the new functionality. A strangler pattern can be implemented using three steps −
 *  .Transformation − Develop the microservices independently to implement a particular functionality of a monolith.
 *  .Co-Exist − Both Monolith and Microservices will work. User can access functionality from both components.
 *  .Eliminate − Once the newly developed functionality is production ready, remove the functionality from the monolith.
 *
 * Advantages:
 *  .Test Driven Development − As services are developed in chunks, we can use TDD for business logic and ensure the code
 *   quality.
 *  .Independent Teams − Teams can work in parallel fashion on both monolith and microservices thus making a robust
 *   delivery mechanism.
 *
 */
public class _4_Strangler {
}
