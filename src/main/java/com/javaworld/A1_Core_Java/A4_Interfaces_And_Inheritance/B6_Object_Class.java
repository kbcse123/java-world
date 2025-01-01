package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;


import com.javaworld.A1_Core_Java.z_helperbeans.PersonObject;

/**
 * @author Shaik Khader
 * 
 *         . The Object class, in the java.lang package, sits at the top of the
 *         class hierarchy tree. Every class is a descendant, direct or
 *         indirect, of the Object class. Every class you use or write inherits
 *         the instance methods of Object. You need not use any of these
 *         methods, but, if you choose to do so, you may need to override them
 *         with code that is specific to your class. The methods inherited from
 *         Object that are discussed in this section are:
 * 
 *         protected Object clone() - Creates and returns a copy of this object.
 * 
 *         public boolean equals(Object obj) - Indicates whether some other
 *         object is "equal to" this one.
 * 
 *         public int hashCode() - Returns a hash code value for the object.
 * 
 *         protected void finalize() - Called by the garbage collector on an
 *         object when it determines that there are no more references to that
 *         object
 * 
 *         public final Class getClass() - Returns the runtime class of an
 *         object.
 * 
 *         public String toString() - Returns a string representation of the
 *         object.
 * 
 *         . The notify, notifyAll, and wait methods of Object all play a part
 *         in synchronizing the activities of independently running threads in a
 *         program, which is discussed in a later lesson and won't be covered
 *         here.
 * 
 *         The clone() Method:
 * 
 *         . If a class, or one of its superclasses, implements the Cloneable
 *         interface, you can use the clone() method to create a copy from an
 *         existing object. To create a clone, you write:
 *         cloneableObject.clone();
 * 
 *         . Object's implementation of this method checks to see whether the
 *         object on which clone() was invoked implements the Cloneable
 *         interface. If the object does not, the method throws a
 *         CloneNotSupportedException exception. If you are going to write a
 *         clone() method to override the one in Object then it must be declared
 *         as:
 * 
 *         protected Object clone() throws CloneNotSupportedException (or)
 *         public Object clone() throws CloneNotSupportedException
 * 
 *         . If the object on which clone() was invoked does implement the
 *         Cloneable interface, Object's implementation of the clone() method
 *         creates an object of the same class as the original object and
 *         initializes the new object's member variables to have the same values
 *         as the original object's corresponding member variables.
 * 
 *         . The simplest way to make your class cloneable is to add implements
 *         Cloneable to your class's declaration. then your objects can invoke
 *         the clone() method.
 * 
 *         . For some classes, the default behavior of Object's clone() method
 *         works just fine. If, however, an object contains a reference to an
 *         external object, say ObjExternal, you may need to override clone() to
 *         get correct behavior. Otherwise, a change in ObjExternal made by one
 *         object will be visible in its clone also. This means that the
 *         original object and its clone are not independent,to decouple them,
 *         you must override clone() so that it clones the object and
 *         ObjExternal. Then the original object references ObjExternal and the
 *         clone references a clone of ObjExternal, so that the object and its
 *         clone are truly independent.
 * 
 *         The equals() Method:
 * 
 *         . The equals() method compares two objects for equality and returns
 *         true if they are equal. The equals() method provided in the Object
 *         class uses the identity operator (==) to determine whether two
 *         objects are equal. For primitive data types, this gives the correct
 *         result. For objects, however, it does not. The equals() method
 *         provided by Object tests whether the object references are equal,that
 *         is, if the objects compared are the exact same object.
 * 
 *         . To test whether two objects are equal in the sense of equivalency
 *         (containing the same information), you must override the equals()
 *         method.
 * 
 *         . You should always override the equals() method if the identity
 *         operator is not appropriate for your class.
 * 
 *         The hashCode() Method:
 * 
 *         . The value returned by hashCode() is the object's hash code, which
 *         is the object's memory address in hexadecimal.
 * 
 *         . By definition, if two objects are equal, their hash code must also
 *         be equal. If you override the equals() method, you change the way two
 *         objects are equated and Object's implementation of hashCode() is no
 *         longer valid. Therefore, if you override the equals() method, you
 *         must also override the hashCode() method as well. Failure to do so
 *         will result in a violation of the general contract for
 *         Object.hashCode(), which will prevent your class from functioning
 *         properly in conjunction with all hash-based collections, including
 *         HashMap, HashSet, and Hashtable.
 * 
 * 
 *         The finalize() Method:
 * 
 *         . The Object class provides a callback method, finalize(), that may
 *         be invoked on an object when it becomes garbage. Object's
 *         implementation of finalize() does nothing,you can override finalize()
 *         to do cleanup, such as freeing resources.
 * 
 *         . The finalize() method may be called automatically by the system,
 *         but when it is called, or even if it is called, is uncertain.
 *         Therefore, you should not rely on this method to do your cleanup for
 *         you. For example, if you don't close file descriptors in your code
 *         after performing I/O and you expect finalize() to close them for you,
 *         you may run out of file descriptors.
 * 
 *         The getClass() Method:
 * 
 *         . You cannot override getClass. The getClass() method returns a Class
 *         object, which has methods you can use to get information about the
 *         class, such as its name (getSimpleName()), its superclass
 *         (getSuperclass()), and the interfaces it implements
 *         (getInterfaces()).
 * 
 *         . The Class class, in the java.lang package, has a large number of
 *         methods (more than 50). For example, you can test to see if the class
 *         is an annotation (isAnnotation()), an interface (isInterface()), or
 *         an enumeration (isEnum()). You can see what the object's fields are
 *         (getFields()) or what its methods are (getMethods()), and so on.
 * 
 *         The toString() Method:
 * 
 *         . You should always consider overriding the toString() method in your
 *         classes.
 * 
 *         . The Object's toString() method returns a String representation of
 *         the object, which is very useful for debugging. The String
 *         representation for an object depends entirely on the object, which is
 *         why you need to override toString() in your classes.
 * 
 *         . You can use toString() along with System.out.println() to display a
 *         text representation of an object.
 * 
 *         Writing Final Classes and Methods:
 * 
 *         . You can declare some or all of a class's methods final. You use the
 *         final keyword in a method declaration to indicate that the method
 *         cannot be overridden by subclasses. The Object class does this,a
 *         number of its methods are final.
 * 
 *         . You might wish to make a method final if it has an implementation
 *         that should not be changed and it is critical to the consistent state
 *         of the object. For example, you might want to make the getFirstPlayer
 *         method in this ChessAlgorithm class final:
 * 
 *         class ChessAlgorithm { enum ChessPlayer { WHITE, BLACK } ... final
 *         ChessPlayer getFirstPlayer() { return ChessPlayer.WHITE; } ... } .
 *         Methods called from constructors should generally be declared final.
 *         If a constructor calls a non-final method, a subclass may redefine
 *         that method with surprising or undesirable results.
 * 
 *         . Note that you can also declare an entire class final. A class that
 *         is declared final cannot be subclassed. This is particularly useful,
 *         for example, when creating an immutable class like the String class.
 * 
 */

public class B6_Object_Class {

	public static void main(String... args) {
		PersonObject person1 = new PersonObject("1", "Shaik");
		PersonObject person2 = new PersonObject("2", "Khader");

		System.out.print("equals() Example: ");
		if (person1.equals(person2)) {
			System.out.println("objects are equal");
		} else {
			System.out.println("objects are not equal");
		}

		System.out.print("getClass() Example: ");
		person1.printClassName();
		System.out.print("toString() Example: ");
		System.out.println(person2);
	}

}
