package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;

/**
 * This principle states that “a class should have only single responsibility or single purpose and should have
 * one and only one reason to change”, It does not mean that your classes should only contain one method or property.
 *
 * The principle can be well understood with an example. Imagine there is a class called BankService which performs
 * following operations:  Withdraw, Deposit, Print Pass Book, Get Loan Info, Send OTP
 * Here the class does not follow SRP since it has many responsibilities to perform.
 *
 * The solution to this problem is to create multiple classes for each task i.e, DepositService, WithDrawService,
 * PrintService, LoanService and NotificationService etc.
 */

class DepositService {

    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

}

class WithDrawService {
    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }
}

class PrintService {
    public void printPassbook() {
        //update transaction info in passbook
    }
}

class LoanService {
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }
}

class NotificationService {
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }

}



public class A1_Single_Responsiblity_Principle {
}
