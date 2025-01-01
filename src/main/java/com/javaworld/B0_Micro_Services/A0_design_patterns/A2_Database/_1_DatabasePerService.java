package com.javaworld.B0_Micro_Services.A0_design_patterns.A2_Database;

/**
 * Problem Statement:
 * What should be the database structure/architecture in microservices based application.
 *
 * We can keep each microservice data private to that microservice and this data will be accessible only via relevant
 * microservice. The microservice will use its own database for transactions.
 *
 * Benefits:
 *  • Each database can scale independently
 *  • Microservices domain data is encapsulated within the service
 *  • If one of the database servers is down, this will not affect other services
 *  • Also Polyglot data persistence [different DB type (sql / Nosql)] gives the ability to select the best-optimized
 *    storage needs per Microservices.
 *    Eg: an e-commerce application with Microservices,
 *      • The product Microservice use a NoSQL document database for storing catalog-related data, which is storing
 *        JSON objects to accommodate high volumes of read operations
 *      • The shopping cart Microservice use a distributed cache that supports its simple, key-value datastore
 *      • The ordering Microservice use a relational database to accommodate the rich relational structure of its
 *        underlying data
 *
 * Database per Service does not always need to have separate databases provisioned. We can implement the pattern using
 * following ways considering a relational database:
 *  Private tables per Service − Each microservice can utilize a set of tables and these tables should be accessible only
 *                              via their relevant microservice.
 *  Schema per Service − A separate schema can be defined per microservice.
 *  Database Server per Service − Entire database server can be configured per microservice.
 *
 * For More: https://pankajtechblogs.dev/database-per-service-microservices-design-pattern-30bad3a385bd
 */

public class _1_DatabasePerService {

}
