package com.javaworld.A5_Design_Patterns.A0_Solid_Design_Principle;

/**
 * LSP states that “Objects in a program should be replaceable with the instances of their subtypes without altering the
 * correctness of a program”. In other words, if class A is a subtype of class B, then we should be able to replace B
 * with A without interrupting the behavior of the program.
 *
 * Let’s say I have an abstract class called SocialMedia, which supports all social media activities for user like below.
 * Social media can have multiple implementations or can have multiple child like Facebook, WhatsApp ,instagram and
 * Twitter etc. Now instagram doesn’t support groupVideoCall() feature, so we say instagram child is not substitute of
 * parents SocialMedia, How to overcome this issue so that our code can follow LSP. solution - create multiple interfaces
 * and separate the functionalities.
 */

// old implementation
abstract class SocialMedia {
    public abstract  void chatWithFriend();
    public abstract void publishPost(Object post);
    public abstract  void sendPhotosAndVideos();
    public abstract  void groupVideoCall(String... users);
}

//New Implementation
interface Social_Media {
    public void chatWithFriend();
    public void sendPhotosAndVideos();
}

interface PostAndMediaManager {
    public void publishPost(Object post);
}

interface VideoCallManager{
    public void groupVideoCall(String... users);
}

//now its up to implementation class to support features , based on their desired feature they can use respective interface

class Instagram implements Social_Media ,PostAndMediaManager{

    @Override
    public void chatWithFriend() {

    }
    @Override
    public void sendPhotosAndVideos() {

    }
    @Override
    public void publishPost(Object post) {

    }
}

public class A3_Liskov_Substitution_Principle { }
