package com.javaworld.B0_Micro_Services.A0_design_patterns.A1_Integration;

/**
 * Problem Statement:
 * if one service needs output of another service as dependency then how to handle such a case.
 *
 * Solution:
 * We can use Chain of Responsibilities Pattern. As the name suggests, this type of composition pattern will follow the
 * chain structure. Here, we will not be using anything in between the client and service layer. Instead, we will allow
 * the client to communicate directly with the services and all the services will be chained up in a such a manner that
 * the output of one service will be the input of the next service.
 *
 * Disadvantage:
 * One major drawback of this architecture is, the client will be blocked until the entire process is complete.
 * Thus, it is highly recommendable to keep the length of the chain as short as possible.
 *
 */
public class _5_ChainOfResponsibilities {
}
