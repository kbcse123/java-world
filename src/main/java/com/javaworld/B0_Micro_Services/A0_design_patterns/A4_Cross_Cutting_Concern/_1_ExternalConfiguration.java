package com.javaworld.B0_Micro_Services.A0_design_patterns.A4_Cross_Cutting_Concern;

/**
 * Problem Statement:
 * Microservices often interacts with infrastructure services or 3rd party services, Infrastructure services may include
 * a service registry, a message broker, database server and 3rd party services can be payment services, email services,
 * messaging services. Apart from varying services, environments often vary.
 * Consider the following cases −
 *  .Configuration Data − Configurations to external/3rd party services should be provided to the microservices
 *                        e.g. database credentials, network urls etc
 *  .Multiple Environments − There are often varying environments like dev, qa, staging or pre-prod and production.
 *                           A service should be deployed on each environment without any code modifications.
 *  .Varying configuration data − Configurations to external/3rd party services also varies from dev to production
 *                                e.g. dev database to production database, test payment processor vs original payment
 *                                processor services.
 *
 * Solution:
 * We can externalize all configurations from database credentials to network urls. Service will read the configuration
 * data during startup e.g. from a properties file/ system environment variables or using command line arguments.
 * This pattern helps in deploying the microservices without any modification/recompilation needed.
 *
 * For More:
 *      https://pankajtechblogs.dev/why-to-externalize-configurations-5ffe0d552aed
 *      https://pankajtechblogs.dev/spring-cloud-config-server-auto-reload-config-properties-zero-touch-63c4423beb59
 *      https://stackoverflow.com/questions/33416103/running-spring-clound-config-and-eureka-on-same-server
 */
public class _1_ExternalConfiguration {
}
