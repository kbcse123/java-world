package com.javaworld.B0_Micro_Services.A0_design_patterns.A2_Database;

/**
 * Problem Statement:
 * if we've used a database per service design pattern then how to implement a transaction which spans multiple services.
 *
 * Solution:
 * We can use Saga Pattern. A saga is a sequence of local transactions. In this pattern, each transaction updates the
 * database and triggers an event or publishes a message for next transaction in saga. In case, any local transaction
 * fails, saga will trigger series of transactions to undo the changes done so far by the local transactions.
 *
 * Consider an example of order service and customer service. Order service can make an order and then ask customer
 * service if credit limit is crossed or not. In case credit is crossed, the customer service will raise an event to
 * order service to cancel the order otherwise to place the order successfully.
 *
 * In order to implement this pattern, we often need to Choreography based saga or Orchestrator based saga.
 * In choreography based saga, services handles the domain events during local transactions and either complete the
 * transaction or undo the same while in orchestrator based saga, an orchestrator object handles events during local
 * transactions and then tell coordinate which local transaction is to be executed.
 *
 */
public class _4_Saga {
}
