package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;

/**
 * The OCP states that classes should be open for extension but closed for modification.
 * "Open to extension" means that you should design your classes so that new functionality can be
 * added as new requirements are generated. "Closed for modification" means that once you have
 * developed a class you should never modify it, except to correct bugs. Generally you achieve this
 * by referring to abstractions for dependencies, such as interfaces or abstract classes, rather
 * than using concrete classes. Functionality can be added by creating new classes that implement
 * the interfaces.
 *
 * let’s understand this principle with NotificationOld example. Here as discussed earlier if you
 * want to introduce send OTP via mobile Phone or WhatsApp number then you need to modify source
 * code in Notification Class which will violate OCP. So to overcome this we need to design our code
 * in such a way that everyone can reuse our feature by just extending it and if they need any
 * customization they can extend it and add their feature on top of it like an abstraction
 */


class NotificationOld {
    public void sendOTP(String notificationType, String sendTo, String message) {
        if (notificationType.equals("email")) {
            //send OTP through mail logic
        }
        if (notificationType.equals("mobile")) {
            //send OTP through mail logic
        }

    }
    void sendTransactionNotification(String notificationType, String sendTo, String message){
        if (notificationType.equals("email")) {
            //send Transaction Notification through mail logic
        }
        if (notificationType.equals("mobile")) {
            //send OTP through mail logic
        }

    }
}

//New Implementation using OCP
interface Notification {
    void sendOTP(String sendTo, String message);
    void sendTransactionNotification(String sendTo, String message);
}

class EmailNotification implements Notification {
    @Override
    public void sendOTP(String sendTo, String message) {
        // write Logic using JavaEmail api
    }
    @Override
    public void sendTransactionNotification(String sendTo, String message) {
        // log transaction notification to file or DB
    }
}

class MobileNotification implements Notification {
    public void sendOTP(String sendTo, String message) {
        // write Logic using Twilio SMS API
    }

    public void sendTransactionNotification(String sendTo, String message) {
    }
}

class WhatsAppNotification implements Notification {
    public void sendOTP(String sendTo, String message) {
        // write Logic using whatsapp API
    }

    public void sendTransactionNotification(String sendTo, String message) {
    }
}

public class A2_Open_Closed_Principle { }
