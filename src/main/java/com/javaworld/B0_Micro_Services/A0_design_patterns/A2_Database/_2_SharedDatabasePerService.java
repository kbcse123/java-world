package com.javaworld.B0_Micro_Services.A0_design_patterns.A2_Database;

/**
 *
 * Use a (single) database that is shared by multiple services. Each service freely accesses data owned by other services
 * using local ACID transactions.
 * The OrderService and CustomerService freely access each other’s tables. For example, the OrderService can use the
 * following ACID transaction ensure that a new order will not violate the customer’s credit limit.
 *
 *      BEGIN TRANSACTION
 *      …
 *      SELECT ORDER_TOTAL FROM ORDERS WHERE CUSTOMER_ID = ?
 *      …
 *      SELECT CREDIT_LIMIT FROM CUSTOMERS WHERE CUSTOMER_ID = ?
 *      …
 *      INSERT INTO ORDERS …
 *      …
 *      COMMIT TRANSACTION
 * The database will guarantee that the credit limit will not be exceeded even when simultaneous transactions attempt to
 * create orders for the same customer.
 *
 * The benefits of this pattern are:
 *      .A developer uses familiar and straightforward ACID transactions to enforce data consistency
 *      .A single database is simpler to operate
 *
 * The drawbacks of this pattern are:
 *      .Development time coupling - a developer working on, for example, the OrderService will need to coordinate schema
 *       changes with the developers of other services that access the same tables. This coupling and additional
 *       coordination will slow down development.
 *      .Runtime coupling - because all services access the same database they can potentially interfere with one another.
 *       For example, if long-running CustomerService transaction holds a lock on the ORDER table then the OrderService
 *       will be blocked.
 *      .Single database might not satisfy the data storage and access requirements of all services.
 *      .This pattern is more of an anti-pattern. It's best to use the Database per Service pattern.
 *
 */
public class _2_SharedDatabasePerService {
}
