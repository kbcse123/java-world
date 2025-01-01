package com.javaworld.B0_Micro_Services.A0_design_patterns.A4_Cross_Cutting_Concern;

/**
 * Case 1: old - new versions release (Blue-green case 1.gif)
 *
 * Blue-green deployment is a software development technique that uses two identical environments to reduce downtime
 * and risk when updating an application:
 *  Blue environment: The current application version is running in this environment.
 *  Green environment: The new application version is running in this environment.
 * Here's how a blue-green deployment works:
 *  .Develop the new version of the application in the green environment.
 *  .Once the new version is ready and tested, redirect traffic from the blue environment to the green environment.
 *  .If any issues are found, roll back to the blue environment.
 *  .After the green version has been live for a while and is deemed bug-free, the blue environment is deprecated.
 *  .Create a new clone of the production environment to become the new green environment.
 * Blue-green deployment is also known as red/black deployment or A/B deployment. It's useful for product
 * experimentation and can help with simple rollouts, quick rollbacks, and easy disaster recovery.
 * Cloud computing has made it easier and more cost-effective to adopt blue-green deployment. Some AWS deployment
 * services that support blue-green deployment include Elastic Beanstalk, OpsWorks, CloudFormation, CodeDeploy, and
 * Amazon ECS
 *
 * Case 2: Migrating from a monolith to microservices (Blue-green case 2.gif)
 *
 * This mode of deployment helps in reducing the downtime or even zero downtime while migrating from a monolith to
 * microservices based application.
 *  .During the course of development, more and more services are developed and functionalities are moved away from a
 *   monolith.
 *  .Once a microservice is available in production, the load balancer redirects the requests targeted for
 *   old application to the new microservice gradually.
 *
 */
public class _4_BlueGreenDeployment {
}
