package com.javaworld.A1_Core_Java.A6_Generics;

/**
 * . We already know, it is possible to assign an object of one type to an object of another type provided that the types 
 *   are compatible(IS-A relationship). For example, you can assign an Integer to an Number, since Number is one of 
 *   Integer's supertypes.
 *   
 * . The same is also true with generics. You can perform a generic type invocation, passing Number as its type argument,
 *   and any subsequent invocation of add will be allowed if the argument is compatible with Number:
       GenericBox<Number> box = new GenericBox<Number>();
       //OK
       box.set(new Integer(10)); 
       //OK  
       box.set(new Double(10.1));  
 * 
 * . Given two concrete types Number and Integer, GenericBox<Number> has no relationship to GenericBox<Integer>, 
 *   regardless of whether or not Number and Integer are related. The common parent of GenericBox<Number> and 
 *   GenericBox<Integer> is Object. For example consider the following method:
       public void boxTest(GenericBox<Number> n) { }
       
 *   By looking at its signature, you can see that it accepts a single argument whose type is GenericBox<Number>. 
 *   That means you are not allowed to pass in GenericBox<Integer> or GenericBox<Double>, because GenericBox<Integer>
 *   and GenericBox<Double> are not subtypes of GenericBox<Number>.
 *   
 * . You can subtype a generic class or interface by extending or implementing it. The relationship between the type 
 *   parameters of one class or interface and the type parameters of another are determined by the extends and implements
 *   clauses.
 *   
 * . For example, ArrayList<E> implements List<E>, and List<E> extends Collection<E>. So ArrayList<String> 
 *   is a subtype of List<String>, which is a subtype of Collection<String>. So as long as you do not vary the type 
 *   argument, the subtyping relationship is preserved between the types.
 */

interface Vehicle<T>{
	void start();
	void stop();
}
interface ElectricVehicle<T> extends Vehicle<T>{
	void recharge();
}
class Car<T> implements ElectricVehicle<T>{
	T carType;
	public Car(T cType){
		carType = cType;
	}
	@Override
	public void start() {
		System.out.println(carType+" Started...");
	}
	@Override
	public void stop() {
		System.out.println(carType+" Stopped...");
		
	}
	@Override
	public void recharge() {
		System.out.println(carType+" is charging...");
		
	}
}

public class A7_InheritanceAndSubtypes {
	public static void main(String[] args) {
		ElectricVehicle<String> car = new Car<>("Tesla Model 3");
		car.start();
		car.stop();
		car.recharge();
	}
}