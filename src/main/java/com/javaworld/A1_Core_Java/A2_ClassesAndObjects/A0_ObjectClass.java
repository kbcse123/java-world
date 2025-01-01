package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * The Object class is the parent class of all the classes in java by default. In other words, it is the
 * root of the class hierarchy. The Object class provides some common behaviors to all the objects such as
 * object can be compared, cloned, notified etc.
 *
 * Methods:
 *
 * protected Object clone() - Creates and returns a copy of this object.
 *
 * boolean equals(Object obj) - Indicates whether some other object is "equal to" this one.
 *
 * protected void finalize() - Called by the garbage collector on an object when garbage collection determines that
 * 			   there are no more references to the object.
 *
 * Class<?> getClass() - Returns the runtime class of this Object.
 *
 * int hashCode() - Returns a hash code value for the object.
 *
 * void notify() - Wakes up a single thread that is waiting on this object's monitor.
 *
 * void notifyAll() - Wakes up all threads that are waiting on this object's monitor.
 *
 * String toString() - Returns a string representation of the object.
 *
 * void wait() - Causes the current thread to wait until another thread invokes the notify() method or the notifyAll()
 * 		 method for this object.
 *
 * void wait(long timeout) - Causes the current thread to wait until either another thread invokes the notify() method
 *  			   or the notifyAll() method for this object, or a specified amount of time has elapsed.
 *
 * void wait(long timeout,int nanos) - Causes the current thread to wait until another thread invokes the notify()
 * 				   method or the notifyAll() method for this object, or some other thread
 * 				   interrupts the current thread, or a certain amount of real time has elapsed.
 */

public class A0_ObjectClass {
}