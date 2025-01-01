 package com.javaworld.A1_Core_Java.A1_OOP_Concepts;
/**
 * Abstraction:
 * - The process of hiding the implementation details and showing only the functionality.
 * - It is more about 'What' functionality a class can offer (Specification)
 * - Is Achieved by using interface and abstract class.
 * <p>
 * Encapsulation:
 * - The process of providing proper access to the object's state(data members) and behaviors(members functions)
 * in order to protect from other objects.
 * - This is done using access modifiers (private, protected and public).
 * - It is more about 'How' to achieve the class functionality (Implementation)
 * <p>
 * Inheritance:
 * - The capability of a class to inherit the (non-private) properties and methods of another class while adding its own
 *   functionality.
 * - Use Inheritance when a "Is-A"relationship(classification) exists between two classes.
 * - Don't use inheritance just to get code reuse, If all you really want is to reuse code and if there is no is-a
 *   relationship in sight then use composition.
 * <p>
 * Polymorphism:
 * - The ability of an object to take on many forms, That is to treat objects of different types in a similar manner.
 * - Generally it can be classified into:
 *    .Compile time polymorphism (Method Overloading): A class having multiple methods(can be constructors too) by same
 *     name but different arguments. Method overloading is not possible with changing return type of methods.
 *    .Runtime polymorphism (Method Overriding): Subclasses of a class can define their own unique behaviors and yet share
 *     some of the same functionality of the parent class.
 * <p>
 * Composition:
 * - Composition simply means referencing the class or interface as an instance variables(fields) instead of inheriting it.
 * - Use Composition when a "HAS-A" relationship exists between two classes or between a class and interface.
 * - Using inheritance we can achieve both polymorphism and code reuse whereas composition provides only code reuse.
 * <p>
 * Aggregation:
 * - Aggregation and Composition are very closely related terms. In aggregation child can exist independently without
 * the parent whereas in composition a child cannot exist without parent.
 * For example: Library and book, A book can exist without library, But a library cannot exist without books. So here,
 * you should consider the direction also, From book to library it is aggregation but from library to book it is
 * composition, dependency matters.
 * - Therefore Composition is a STRONGER relationship whereas Aggregation is a WEAKER relationship.
 * - Please note that Aggregation and Composition are not OOPs concepts.
 */