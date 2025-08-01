package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;


/**
 * Solid Summary:
 * S: Single Responsibility Principle
 *  “a class should have only one responsibility or one purpose and should have only one reason to
 *   change”, It doesn't mean that your classes should only contain one method or property.
 *   Eg: BankService which performs following operations:  Withdraw, Deposit, Print Pass Book,
 *   Get Loan Info, Send OTP in one class.
 *   Solution: BankService should be divided into DepositService, WithDrawService, PrintService,
 *   LoanService and NotificationService etc. instead of having single class which does all these
 *   operations
 *
 * O: Open-Closed Principle
 *  "Open to extension" means that you should design your classes so that new functionality can be
 *   added as new requirements are generated. "Closed for modification" means that once you have
 *   developed a class you should never modify it, except to correct bugs. Generally you achieve this
 *   by referring to abstractions such as interfaces or abstract classes. Functionality can be added
 *   by creating new classes that implement the core interfaces.
 *   Eg: Notification class contains sendOTP() with if else logic to send OTP to email, mobile.
 *   In future If you want to send OTP to WhatsApp then you need to modify Notification class which
 *   will violate OCP.
 *   Solution: create an interface Notification with sendOTP() method. Now if you want to send OTP via
 *   WhatsApp then you can create WhatsAppNotification class which will implement Notification interface
 *   and override sendOTP() method with WhatsApp logic.
 *
 * L: Liskov Substitution Principle:
 *  LSP states that “Derived types must be completely substitutable for their base types
 *  without altering the correctness of a program”. In other words, if class A is a subtype of
 *  class B, then we should be able to replace B with A without interrupting the behavior of the
 *  program.
 *  Eg:Let’s say I have an abstract class called SocialMedia, which supports all social media
 *  activities. Social media can have multiple implementations or can have multiple child
 *  like Facebook, WhatsApp, instagram and Twitter etc. Now instagram doesn’t support groupVideoCall()
 *  feature, so we say instagram child is not substitute of parents SocialMedia, How to overcome this
 *  issue so that our code can follow LSP.
 *  Solution: create multiple interfaces like SocialMedia, PostAndMediaManager, VideoCallManager.
 *  Now we can create Instagram class which implements SocialMedia and PostAndMediaManager interfaces.
 *
 * I: Interface Segregation Principle
 *  ISP states that "Clients should not be forced to depend upon interfaces that they don't use". In
 *  other words segregate interfaces as per the requirements of the program, rather than one general
 *  purpose implementation.
 *
 *  Eg: Let’s say you have an interface called UPIPayment with methods like payMoney(), getScratchCard()
 *  and getCashBackAsCreditBalance(). Google Pay support these
 *  features, so it can directly implement UPIPayments but Paytm doesn’t support
 *  getCashBackAsCreditBalance() feature so here we shouldn’t force paytm to override this method.
 *  Solution: create multiple interfaces like
 *   UPIPayment - payMoney(),getScratchCard()
 *   CashBackManager - getCashBackAsCreditBalance()
 *
 * D: Dependency Inversion Principle:
 *  DIP states that "High-level modules should not depend on low-level modules. Both should depend
 *  on abstractions. Abstractions should not depend on details. Details should depend on abstractions".
 *  In other words, we should depend on abstractions and not on concrete classes.
 *
 *  Eg: Let’s say we have a high-level class Shelf which is tightly coupled with low-level class Book.
 *  Now, if we want to add a DVD to the Shelf, we need to modify the Shelf class to accept DVDs.
 *  But this would break the Open-Closed Principle, as we are modifying the Shelf class to accept DVDs.
 *
 *  Solution: The solution is to create an abstraction layer for the lower-level classes (Book and DVD).
 *  Create a Product interface with seeReviews() and getSample() methods, and let both Book and DVD
 *  classes implement it. Now, Shelf can reference the Product interface instead of its implementations
 *  (Book and DVD). The refactored code also allows us to later introduce new product types
 *  (for instance, Magazine) that customers can put on their shelves, too.
 *
 *
 *
 */
public class A6_SolidSummary {
}
