package com.javaworld.A5_Design_Patterns.A2_Structural_Design_Patterns;
/**
 * 
 */

/**
 * @author Shaik Khader
 
 According to GoF, bridge design pattern is:

    "Decouple an abstraction from its implementation so that the two can vary independently".
    
 When we have interface hierarchies in both interfaces as well as implementations, then bridge design pattern is used to decouple the
 interfaces from implementation and hiding the implementation details from the client programs.    

 The implementation of bridge design pattern follows the notion to prefer Composition over inheritance.
 
 If we look into bridge design pattern with example, it will be easy to understand. Lets say we have an interface hierarchy in both 
 interfaces and implementations like bridge1.jpg.
 
 Now we will use bridge design pattern to decouple the interfaces from implementation. UML diagram for the classes and interfaces 
 after applying bridge pattern will look like bridge2.jpg.
 
 Notice the bridge between Shape and Color interfaces and use of composition in implementing the bridge pattern.
 
 Bridge design pattern can be used when both abstraction and implementation can have different hierarchies independently and we want
 to hide the implementation from the client application.
 
 */


interface Color {

	public void applyColor();
}

abstract class Shape {
	//Composition - implementor
	protected Color color;
	
	//constructor with implementor as input argument
	public Shape(Color c){
		this.color=c;
	}
	
	abstract public void applyColor();
}

class Triangle extends Shape{

	public Triangle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	} 

}

class Pentagon extends Shape{

	public Pentagon(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	} 

}

class RedColor implements Color{

	public void applyColor(){
		System.out.println("red.");
	}
}

class GreenColor implements Color{

	public void applyColor(){
		System.out.println("green.");
	}
}


public class _6_Bridge_Pattern {
	public static void main(String... args) {
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();
		
		Shape pent = new Pentagon(new GreenColor());
		pent.applyColor();
	}

}
