package com.javaworld.B0_Micro_Services.A0_design_patterns;

/**
 * Problem Statement:
 * Microservices handle requests from clients and often need to communicate with other microservices to fulfill the
 * requests. So there is a requirement for inter-process communication protocol.
 *
 * Solution:
 * We can use Asynchronous Messaging Pattern for inter service communication as using synchronous communication will
 * result in tight coupling of services and also requires both client and service to be available during request.
 * Using Asynchronous Messaging, a service can communicate by exchanging messages over messaging channels. Following are
 * some different ways of asynchronous messaging communications.
 *      .Request / Synchronous Response − In this method, service makes a request to another service and expects a reply
 *                                        promptly.
 *      .Notifications − In this method, service sends a message to a recipient but is not expecting any response.
 *                       Recipient is not expected to send a response as well.
 *      .Request / Asynchronous Response − In this method, service makes a request to another service and expects a reply
 *                                         within reasonable timeframe.
 *      .Publish / Subscribe − In this method, service publishes a message to zero or more recipients. Services which
 *                            subscribe the message will receive the same. No response needed.
 *      .Publish / Asynchronous Response − In this method, service publishes a message to zero or more recipients. Services which subscribe the message will receive the same. Some of the them sends back an acknowledgement/reply.
 *
 * Example:
 *  RabbitMQ and Apache Kafka are good examples of asynchronous messaging in microservices arena.
 *
 */
public class AsynchronousMessaging {
}
