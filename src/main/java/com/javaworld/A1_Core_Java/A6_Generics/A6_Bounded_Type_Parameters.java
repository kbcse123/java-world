/**
 * . There may be times when you want to restrict the types that can be used as type arguments in a parameterized type. 
 *   For example, a method that operates on numbers might only want to accept instances of Number or its subclasses.
 *   
 * . To declare a bounded type parameter, list the type parameter's name, followed by the 'extends' keyword, followed by its
 *   upper bound, which in our below example is Number.
 * 
 * . In addition to limiting the types you can use to instantiate a generic type, bounded type parameters allow you to 
 *   invoke methods defined in the bounds: See isEven() in class BoundedClassWithBoundedMethods.
 * 
 * . Multiple Bounds: 
 *   - a type parameter can have multiple bounds: 
 *     For example: class D <T extends A & B & C&gt;{} where A is a class, B and C are interfaces. 
 *   - a type variable with multiple bounds is a subtype of all the types listed in the bound. If one of the bounds is a 
 *     class, it must be specified first otherwise it will lead to compile-time error.
 *     For example: class D <T extends B & A & C&gt; {} will lead to compile-time error.
 *     
 * . Bounded type parameters are key to the implementation of generic algorithms. Consider the method that counts the 
 *   number of elements in an array T[] that are greater than a specified element. A type parameter bounded by the
 *   Comparable <T&gt; interface is used because the greater than operator (&gt;) applies only to primitive types.
 *   You cannot use the &gt; operator to compare objects.
 */

import java.util.ArrayList;
import java.util.List;

interface ElementRestrictions<T> {
	public void addElement(T t);
	public List<T> getElements();
}
interface GreaterThanZeroRestriction<T> {
	int value();
	boolean isGreaterThanZero(int val);
}
interface EvenNumberRestriction<T> {
	boolean isEvenNumber(int val);
}
class RestrictedClass<T extends GreaterThanZeroRestriction<T> & EvenNumberRestriction<T>>
		implements ElementRestrictions<T> {
	List<T> tElements = new ArrayList<T>();
	@Override
	public void addElement(T element) {
		if (element.isEvenNumber(element.value()) && element.isGreaterThanZero(element.value())) {
			tElements.add(element);
		} else {
			System.out.println("Invalid Element: " + element.value());
		}
	}
	@Override
	public List<T> getElements() {
		return tElements;
	}
}

class Element implements GreaterThanZeroRestriction<Element>, EvenNumberRestriction<Element> {
	int value;
	public Element(int val) {
		value = val;
	}
	public String toString() {
		return String.valueOf(value);
	}
	@Override
	public int value() {
		return value;
	}
	@Override
	public boolean isGreaterThanZero(int val) {
		return val > 0;
	}
	@Override
	public boolean isEvenNumber(int val) {
		return val % 2 == 0;
	}
}

public class A6_Bounded_Type_Parameters {
	public static void main(String[] args) {
		ElementRestrictions<Element> er = new RestrictedClass<Element>();
		for (int i = -1; i <= 10; i++) {
			er.addElement(new Element(i));
		}
		System.out.println("\nValid Elements: " + er.getElements());
	}
}
