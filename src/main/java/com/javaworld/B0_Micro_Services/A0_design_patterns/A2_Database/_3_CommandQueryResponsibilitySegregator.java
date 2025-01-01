package com.javaworld.B0_Micro_Services.A0_design_patterns.A2_Database;

/**
 * Problem Statement:
 * if we've used a database per service design pattern then how to make query which needs data from multiple services.
 *
 * Solution:
 * We can define a view database which is a read-only data to support the required query. Application will keep the view
 * database up to date by subscribing to the events raised by the services which owns the data. In this design pattern,
 * we segregate the update and read operations. One service will only read the data and other services will update the
 * data.
 *
 * In order to implement this pattern, we often need to refactor the domain model to support seperate operations for
 * querying data and to update data so that each operation can be handled by microservices independently. CQRS patterns
 * ensures that operation that reads data is seperate from that which updates the data. So an operation can either read
 * or write data but cannot perform both together.
 *
 * Now multiple services can update the records and send events to application to update the view database. This helps
 * the Query service to get the consistent data without any performance hit.
 *
 */
public class _3_CommandQueryResponsibilitySegregator {
}
