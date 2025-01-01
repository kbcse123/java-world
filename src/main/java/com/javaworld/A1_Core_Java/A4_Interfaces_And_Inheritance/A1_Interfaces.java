package com.javaworld.A1_Core_Java.A4_Interfaces_And_Inheritance;

import com.javaworld.A1_Core_Java.z_helperbeans.OperateCar;
import com.javaworld.A1_Core_Java.z_helperbeans.OperateCar.Direction;

/**
 * @author Shaik Khader
 
 	. Generally speaking, interfaces are contracts that shows how the software interacts.
 	
 	. In the Java programming language, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static
 	  methods, and nested types. Method bodies exist only for default methods and static methods.
 	  
 	. Interfaces cannot be instantiated,they can only be implemented by classes or extended by other interfaces. A class can implement more than one interface, so the 
 	  implements keyword is followed by a comma-separated list of the interfaces implemented by the class.
 	  
 	. To use an interface, you write a class that implements the interface. When an instantiable class implements an interface, it provides a method body for each of the
 	  methods declared in the interface.	
 	  
 	. In the robotic car example below, it is the automobile manufacturers who will implement the interface. Chevrolet's implementation will be substantially different 
 	  from that of Toyota, of course, but both manufacturers will adhere to the same interface. The guidance manufacturers, who are the clients of the interface, will 
 	  build systems that use GPS data on a car's location, digital street maps, and traffic data to drive the car. In so doing, the guidance systems will invoke the 
 	  interface methods: turn, change lanes, brake, accelerate, and so forth.  			
 	
 Interfaces as APIs:

	. The robotic car example shows an interface being used as an industry standard Application Programming Interface (API). APIs are also common in commercial software 
	  products. Typically, a company sells a software package that contains complex methods that another company wants to use in its own software product. An example would
	  be a package of digital image processing methods that are sold to companies making end-user graphics programs. The image processing company writes its classes to
	  implement an interface, which it makes public to its customers. The graphics company then invokes the image processing methods using the signatures and return types
	  defined in the interface. While the image processing company's API is made public (to its customers), its implementation of the API is kept as a closely guarded
	  secret,in fact, it may revise the implementation at a later date as long as it continues to implement the original interface that its customers have relied on.

 Defining an Interface:

	. An interface declaration consists of modifiers, the keyword interface, the interface name, a comma-separated list of parent interfaces (if any), and the interface 
	  body. 
	  	  			
 	. The public access specifier indicates that the interface can be used by any class in any package. If you do not specify that the interface is public, then your 
 	  interface is accessible only to classes defined in the same package as the interface.  			
 	
 	. An interface can extend other interfaces, just as a class extends another class. However, whereas a class can extend only one other class, an interface
 	  can extend any number of interfaces. The interface declaration includes a comma-separated list of all the interfaces that it extends.
 	
 	. All abstract, default, and static methods in an interface are implicitly public, so you can omit the public modifier.
 	
 	. Similarly all constant values defined in an interface are implicitly public, static, and final. Once again, you can omit these modifiers.

 Using an Interface as a Type:

	. When you define a new interface, you are defining a new reference data type. If you define a reference variable whose type is an interface, any object you assign to
	  it must be an instance of a class that implements the interface.	
 	  			
 */

class OperateBMW760i implements OperateCar {

    // the OperateCar method signatures, with implementation --
	
	@Override
    public int signalTurn(Direction direction, boolean signalOn) {
		
       // code to turn BMW's LEFT turn indicator lights on
       // code to turn BMW's LEFT turn indicator lights off
       // code to turn BMW's RIGHT turn indicator lights on
       // code to turn BMW's RIGHT turn indicator lights off
    	return 0;
    }

	@Override
	public int turn(Direction direction, double radius, double startSpeed, double endSpeed) {
		System.out.println("in turn()");
		return 0;
	}

	@Override
	public int changeLanes(Direction direction, double startSpeed, double endSpeed) {
		System.out.println("in changeLanes()");
		return 0;
	}

	@Override
	public int getRadarFront(double distanceToCar, double speedOfCar) {
		System.out.println("in getRadarFront()");
		return 0;
	}

	@Override
	public int getRadarRear(double distanceToCar, double speedOfCar) {
		System.out.println("in getRadarRear()");
		return 0;
	}

   
}


public class A1_Interfaces {
	public static void main(String... args) {
		OperateCar interfaceAsReferenceType = new OperateBMW760i();
		interfaceAsReferenceType.turn(Direction.LEFT, 12.34, 20, 50.2);
	}

}
