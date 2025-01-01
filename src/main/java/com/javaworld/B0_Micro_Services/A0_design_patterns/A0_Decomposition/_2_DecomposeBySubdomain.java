package com.javaworld.B0_Micro_Services.A0_design_patterns.A0_Decomposition;

/**
 * Problem Statement:
 * When a large, complex application is to be built using microservice architecture, the major problem is how to design
 * loosely coupled microservices or to break a large application into small loosely coupled services?
 *
 * Solution:
 * We can define a microservice corresponding to Domain-Driven Design(DDD) subdomains. DDD refers to business as a domain
 * and a domain can have multiple subdomains. Now each subdomain refers to different areas
 *
 * Advantages:
 *  Stable Architecture − As business subdomains are stable, this architecture is highly stable.
 *  Cross-functional Teams − Development Teams works independently, are cross-functional and are organized around
 *                           functional features instead of technical features.
 *  Loosely Coupled Services − Developed services will be loosely coupled and cohesive.
 *
 * Dis-advantages:
 * Need good understand of Business − Business subdomains needs be indentified after understanding the business.
 *                                    Understanding organizational structure can help as organizations are structured
 *                                    based on their capabilities.
 * High Level Domain Model needed − Business domain objects required as they correspond to business subdomains.
 */
public class _2_DecomposeBySubdomain {
}
