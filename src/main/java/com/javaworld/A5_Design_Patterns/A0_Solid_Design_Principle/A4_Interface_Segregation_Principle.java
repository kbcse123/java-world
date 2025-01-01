package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;

/**
 * This principle states that segregate interfaces as per the requirements of the program, rather than one general purpose
 * implementation.
 *
 * For example let’s say you have an interface called UPIPayment like below. Google Pay support these features,
 * so it can directly implement UPIPayments but Paytm doesn’t support getCashBackAsCreditBalance() feature so here
 * we shouldn’t force paytm to override this method. so to support ISP we can design something like below
 */

//old implementation
interface UPIPayments {

    public void payMoney();

    public void getScratchCard();

    public void getCashBackAsCreditBalance();
}

//New Implementation
interface UPI_Payments {

    public void payMoney();

    public void getScratchCard();

}

interface CashbackManager{
    public void getCashBackAsCreditBalance();
}

public class A4_Interface_Segregation_Principle {
}