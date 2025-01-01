package com.javaworld.B0_Micro_Services.A0_design_patterns.A4_Cross_Cutting_Concern;

/**
 * Problem Statement:
 * Microservices often interacts with other microservices, Now there is always a possibility that a service is overloaded
 * or unavailable. In such a case the caller service will also wait. If multiple services are getting blocked then it will
 * hamper the performance and can cascade the impact on overall application. Now, how to prevent a service failure or
 * network failure from cascading to other services. If one service is down then it should not be given further requests.
 *
 * Solution:
 * We can use circuit breaker pattern where a proxy service acts as a circuit breaker. Each service should be invoked
 * through proxy service. A proxy service maintains a timeout and failures count. In case of consecutive failures crosses
 * the threshold failures count then proxy service trips the circuit breaker and starts a timeout period. During this
 * timeout period, all requests will fail. Once this timeout period is over, proxy service allows a given limited
 * number of test requests to pass to provider service. If requests succeed, the proxy service resumes the operations
 * otherwise, it again trips the circuit breaker and starts a timeout period and no requests will be entertained during
 * that period.
 *
 * Resilience4J:
 * Resilience4j is a lightweight, easy-to-use fault tolerance library, and it offers features like Rate Limiter, Retry
 * and Bulkhead, TimeLimiter, Cache, and Circuit Breaker. It integrates very easily with spring boot and using micrometer
 * libraries, it can develop the metrics for monitoring.
 *
 * How circuit breaker works:
 * The circuit breaker has 3 normal states:
 *      CLOSED — Backend service API call is invoked.
 *      OPEN — Response will be served from fallback methods (get the response from cache or send a static response).
 *      HALF_OPEN — Half_Open can appear from 2 ways, either the system is going in a CLOSED state, or in an OPEN state
 *                  (it derives using configured threshold), so Half_Open is an intermediate state.
 *
 * CircuitBreaker uses a sliding window to store and aggregate the outcome of calls and determines the change of State
 * is required or not.
 *
 * For Example code and configuration :
 *      https://jstobigdata.com/architecture/circuit-breaker-pattern-in-microservices/
 *      https://pankajtechblogs.dev/why-to-use-circuit-breaker-pattern-7c988c099f49
 *
 */
public class _3_CircuitBreaker {
}
