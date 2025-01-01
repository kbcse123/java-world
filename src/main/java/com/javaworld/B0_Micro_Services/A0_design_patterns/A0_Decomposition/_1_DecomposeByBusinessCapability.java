package com.javaworld.B0_Micro_Services.A0_design_patterns.A0_Decomposition;

/**
 * Problem Statement:
 * Microservice architecture structures an application as a set of loosely coupled microservices and each service should
 * be developed independently in agile manner to enable continuous delivery/deployment. When a large, complex application
 * is to be built using microservice architecture, the major problem is how to design loosely coupled microservices or
 * to break a large application into small loosely coupled services?
 * Example
 * Consider an example of an Online Book Store. It can have following business capabilities and corresponding microservices
 *      Books Catalog Management
 *      Inventory Management
 *      Order Management
 *      Warranty Management
 *
 * Advantages
 *  Stable Architecture − As business capabilities are stable, this architecture is highly stable.
 *  Cross-functional Teams − Development Teams works independently, are cross-functional and are organized around
 *                           functional features instead of technical features.
 *  Loosely Coupled Services − Developed services will be loosely coupled and cohesive.
 *
 * Dis-advantages
 *   Need good understand of Business − Business capabilities needs be indentified after understanding the business.
 *                                      Understanding organizational structure can help as organizations are structured
 *                                      based on their capabilities.
 *   High Level Domain Model needed − Business domain objects required as they correspond to business capabilities.
 *
 */
public class _1_DecomposeByBusinessCapability {
}
