/**
 * 
 */
package A4_Interfaces_And_Inheritance;

/**
 * @author Shaik khader
 * 
 *  . An abstract class is a class that is declared abstract,it may or
 *  may not include abstract methods. Abstract classes cannot be
 *  instantiated, but they can be subclassed.
 * 
 *  . A class automatically becomes abstract class when any of its method
 *  declared as abstract(compiler will complain to make the class
 *  abstract).
 * 
 *  . An abstract method is a method that is declared without an
 *  implementation : abstract void moveTo(double deltaX, double deltaY);
 * 
 *  . When an abstract class is subclassed, the subclass usually provides
 *  implementations for all of the abstract methods in its parent class.
 *  However, if it does not, then the subclass must also be declared
 *  abstract.
 * 
 *  . Variables cannot be made abstract, its only behavior or methods
 *  which would be abstract.
 * 
 *  . Note: Methods in an interface (see the Interfaces section) that are
 *  not declared as default or static are implicitly abstract, so the
 *  abstract modifier is not used with interface methods. (It can be
 *  used, but it is unnecessary.)
 * 
 * 
 *  Abstract Classes Compared to Interfaces:
 * 
 *  Abstract class:
 * 
 *  1) Abstract class can have abstract and non-abstract methods.
 * 
 *  2) Abstract class doesn't support multiple inheritance.
 * 
 *  3) Abstract class can have final, non-final, static and non-static
 *  variables.
 * 
 *  4) Abstract class can provide the implementation of interface.
 * 
 *  5) The abstract keyword is used to declare abstract class.
 * 
 *  6) Example: public abstract class Shape{
 * 
 *  public abstract void draw();
 * 
 *  }
 * 
 * 
 *  Interface:
 * 
 *  Interface can have abstract methods, default and static methods.
 * 
 *  Interface supports multiple inheritance.
 * 
 *  Interface has only static and final variables.
 * 
 *  Interface can't provide the implementation of abstract class.
 * 
 *  The interface keyword is used to declare interface.
 * 
 *  Example: public interface Drawable{
 * 
 *  void draw();
 * 
 *  }
 * 
 * 
 * 
 *  Abstract class achieves partial abstraction (0 to 100%) whereas
 *  interface achieves full abstraction (100%).
 * 
 *  Which should you use, abstract classes or interfaces?
 * 
 *  . Consider using abstract classes if any of these statements apply to
 *  your situation:
 * 
 *  - You want to share code among several closely related classes. - You
 *  expect that classes that extend your abstract class have many common
 *  methods or fields, or require access modifiers other than public
 *  (such as protected and private). - You want to declare non-static or
 *  non-final fields. This enables you to define methods that can access
 *  and modify the state of the object to which they belong.
 * 
 *  . Consider using interfaces if any of these statements apply to your
 *  situation:
 * 
 *  - You expect that unrelated classes would implement your interface.
 *  For example, the interfaces Comparable and Cloneable are implemented
 *  by many unrelated classes. - You want to specify the behavior of a
 *  particular data type, but not concerned about who implements its
 *  behavior. - You want to take advantage of multiple inheritance of
 *  type.
 * 
 *  An example of an abstract class in the JDK is AbstractMap, which is
 *  part of the Collections Framework. Its subclasses (which include
 *  HashMap, TreeMap, and ConcurrentHashMap) share many methods
 *  (including get, put, isEmpty, containsKey, and containsValue) that
 *  AbstractMap defines.
 * 
 *  When an Abstract Class Implements an Interface:
 * 
 *  . In the section on Interfaces, it was noted that a class that
 *  implements an interface must implement all of the interface's
 *  methods. It is possible, however, to define a class that does not
 *  implement all of the interface's methods, provided that the class is
 *  declared to be abstract. For example,
 * 
 *  abstract class X implements Y { // implements all but one method of Y
 *  }
 * 
 *  class XX extends X { // implements the remaining method in Y } . In
 *  this case, class X must be abstract because it does not fully
 *  implement Y, but class XX does, in fact, implement Y.
 * 
 *  Class Members:
 * 
 *  . An abstract class may have static fields and static methods. You
 *  can use these static members with a class reference (for example,
 *  AbstractClass.staticMethod()) as you would with any other class.
 * 
 */

abstract class GraphicAbstractClass {
	// declare fields

	abstract void draw(); // abstract methods

	abstract void resize();

	void moveTo(int newX, int newY) {
		// shared to all subclasses
	}

}

class Circle extends GraphicAbstractClass {

	// different implementations
	@Override
	void draw() {

	}

	@Override
	void resize() {

	}

}

class Rectangle extends GraphicAbstractClass {

	// different implementations
	@Override
	void draw() {

	}

	@Override
	void resize() {

	}

}

public class B7_Abstract_Methods_and_Classes {

	public B7_Abstract_Methods_and_Classes() {
		// TODO Auto-generated constructor stub
	}

}
