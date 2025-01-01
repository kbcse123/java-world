package com.javaworld.B0_Micro_Services.A0_design_patterns.A2_Database;

/**
 * Problem Statement:
 * if we've used a database per service design pattern then how to implement a transaction which spans multiple services
 *
 * Solution:
 * We can use Event Sourcing Pattern for inter service communication. In this type of communication, each service persists
 * the events in event store for every action taken. Each service can subscribe to these events and correspondingly updates
 * its transaction status. Consider a case of Order Service vs Customer Service. A customer service can subscribe to events
 * updated by order service and update its status accordingly.
 *
 * Advantages;
 *  .Ideal for Event driven Architecture − This pattern allows to reliably publish events whenever a state changes.
 *  .Persistent Events − As events are persisted instead of domain objects, object-relational mismatch never happens.
 *  .Audit Log − As events captured every change, so audit logs covers 100% changes.
 *  .Entity State identification − We can create temporal queries on events database to check the current state of the
 *                                 entity at any point.
 *  .Monolith to Microservice architecture movement get easier − Using event sourcing pattern, we can create loosely
 *   coupled microservices which communicates via events. Thus, migration from a monolith to microservice based
 *   application development becomes easier.
 *
 */
public class _5_EventSourcing {
}
