package com.javaworld.B0_Micro_Services.A0_design_patterns.A1_Integration;

/**
 * Problem Statement:
 * When a large, complex application is to be built using microservice architecture, microservices can use different
 * protocols. For example, some microservices are using REST and some are following AMQP. Now problem is how to allow
 * clients to access each microservice seamlessly without worrying about protocols and other intricacies.
 *
 * Solution:
 * We can define an API Gateway which will acts as single entry point for all type of clients. Following are the other
 * benefits of API Gateway −
 *  .Simple Proxy − API Gateway can act as simple proxy to some requests to redirects them to relevant service.
 *  .Multiple Services − API Gateway can redirect call to multiple services.
 *  .Client Specific API − API Gateway can provide client specific API as well, like a different API for Desktop version
 *   than a Mobile Application.
 *  .Protocol Handling − API Gateway handles the communication protocols to each service call internally and clients are
 *   concerned only with request/response.
 *  .Security and Authentication − API Gateway can implement a security that each request goes to service only after
 *   authentication and authorization.
 *
 * Advantages:
 *  .Client Insulation − Clients are insulated from knowing the location of microservices or how to call them.
 *  .Multiple Service Calls − API Gateway can handle multiple services and give result as one and thus can reduce the
 *   round trips and increase the performance.
 *  .Standard Interface − API Gateway provides a standard interface to Clients to get responses from microservices.
 *
 *  Example - Spring Cloud Gateway
 *  Key Features -
 *      Request Routing: Ability to match routes on any request attribute.
 *      Filtering: Enable you to apply filters specific to routes
 *      Circuit Breaker Integration: Out-of-the-box integration with the Resilience4j circuit breaker.
 *      Spring Cloud DiscoveryClient integration
 *      Easy-to-write Predicates and Filters
 *      Request Rate Limiting: Apply rate limiting for incoming requests.
 *      Path Rewriting: Rewrite the path while routing to backend endpoints.
 *      WebSocket support
 *
 * For More:
 *      https://jstobigdata.com/architecture/the-api-gateway-pattern-in-microservices/
 *      https://pankajtechblogs.dev/why-to-use-an-api-gateway-b36c9988f581
 */
public class _1_APIGateway {
}
