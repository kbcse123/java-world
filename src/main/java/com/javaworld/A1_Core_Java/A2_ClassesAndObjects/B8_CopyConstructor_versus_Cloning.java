package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;
/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Shaik Khader
 
 Words of Joshua Bloch:
 	I think clone is deeply broken: There are a few design flaws, the biggest of which is that the Cloneable interface does not have a
 	clone method. And that means it simply doesn't work: making something Cloneable doesn't say anything about what you can do with 
 	it. Instead, it says something about what it can do internally. It says that if by calling super.clone repeatedly it ends up 
 	calling Object's clone method, this method will return a field copy of the original. 
 	
 	Object's clone method is very tricky: It's based on field copies, and it's "extra-linguistic." It creates an object without
 	calling a constructor. There are no guarantees that it preserves the invariants established by the constructors. There have been
 	lots of bugs over the years, both in and outside Sun, stemming from the fact that if you just call super.clone repeatedly up the
 	chain until you have cloned an object, you have a shallow copy of the object. The clone generally shares state with the object 
 	being cloned. If that state is mutable, you don't have two independent objects. If you modify one, the other changes as well. And
 	all of a sudden, you get random behavior.
 	
 	There are very few things for which I use Cloneable anymore. I often provide a public clone method on concrete classes because 
 	people expect it. I don't have abstract classes implement Cloneable, nor do I have interfaces extend it, because I won't place the
 	burden of implementing Cloneable on all the classes that extend (or implement) the abstract class (or interface). It's a real 
 	burden, with few benefits.

	Doug Lea goes even further. He told me that he doesn't use clone anymore except to copy arrays. You should use clone to copy 
	arrays, because that's generally the fastest way to do it. But Doug's types simply don't implement Cloneable anymore. He's given 
	up on it. And I think that's not unreasonable.

	It's a shame that Cloneable is broken, but it happens. The original Java APIs were done very quickly under a tight deadline to 
	meet a closing market window. The original Java team did an incredible job, but not all of the APIs are perfect. Cloneable is a 
	weak spot, and I think people should be aware of its limitations.  
 
 source: https://www.artima.com/intv/bloch13.html
 
 Other sources:
 	
 	Cloning is a basic programming paradigm. The fact that Java may have implemented it poorly in many ways does not at all diminish 
 	the need for cloning. And, it is easy to implement cloning that will work however you want it to work, shallow, deep, mixed, 
 	whatever. You can even use the name clone for the function and not implement Cloneable if you like. 
 	
 	Suppose I have classes A, B, and C, where B and C are derived from A. If I have a list of objects of type A like this:

	ArrayList<A> list1;
	
	Now, that list can contains objects of type A, B, or C. You don't know what type the objects are.So, you can't copy the list like
	this:
	
	ArrayList<A> list2 = new ArrayList<A>();
	for(A a : list1) {
	    list2.add(new A(a));
	}
	
	If the object is actually of type B or C, you will not get the right copy. And, what if A is abstract? Now, some people have 
	suggested this:
	
	ArrayList<A> list2 = new ArrayList<A>();
	for(A a : list1) {
	    if(a instanceof A) {
	        list2.add(new A(a));
	    } else if(a instanceof B) {
	        list2.add(new B(a));
	    } else if(a instanceof C) {
	        list2.add(new C(a));
	    }
	}
	
	This is a very, very bad idea.What if you add a new derived type? What if B or C are in another package and you don't have access
	to them in this class?
	
	What you would like to do is this:
	
	ArrayList<A> list2 = new ArrayList<A>();
	for(A a : list1) {
	    list2.add(a.clone());
	}
	
	Lots of people have indicated why the basic Java implementation of clone is problematic. But, it's easily overcome this way:
	
	In class A:
	
	public A clone() {
	    return new A(this);
	}
	
	In class B:
	
	@Override
	public B clone() {
	    return new B(this);
	}
	
	In class C:
	
	@Override
	public C clone() {
	    return new C(this):
	}
	
	I'm not implementing Cloneable, just using the same function name. If you don't like that, name it something else.
 
 */

class Parent{
	private String name;
	
	Parent(){
		
	}
	
	Parent(String n){
		name = n;
	}
	
	Parent(Parent p){
		name = p.name;
	}
	
	@Override
	public Parent clone() {
		//System.out.println("Parent clone()");
	    return new Parent(this);
	}
	@Override
	public String toString(){
		return "Parent: name -> "+name;
	}

	public String getName(){
		return name;
	}
}

class Child1 extends Parent{
	private String name;
	
	Child1(String n){
		name = n;
	}
	
	Child1(Child1 ch1){
		name = ch1.name;
	}
	
	@Override
	public Child1 clone() {
		//System.out.println("Child1 clone()");
	    return new Child1(this);
	}
	@Override
	public String toString(){
		return "Child1: name -> "+name;
	}
	public String getName(){
		return name;
	}
}
class Child2 extends Parent{
	private String name;
	
	Child2(String n){
		name = n;
	}
	
	Child2(Child2 ch2){
		 name = ch2.name;
	}
	
	@Override
	public Child2 clone() {
		//System.out.println("Child2 clone() - "+name);
	    return new Child2(this);
	}
	@Override
	public String toString(){
		return "Child2: name -> "+name;
	}
	public String getName(){
		return name;
	}
}

public class B8_CopyConstructor_versus_Cloning {
	public static void main(String... args) {
		ArrayList<Parent> actualList = new ArrayList<>(20);
		for(int i=1;i<=5;i++){
			actualList.add(new Parent("Parent"+i)); 
			actualList.add(new Child1("Child1"+i)); 
			actualList.add(new Child2("Child2"+i)); 
		}
		ArrayList<Parent> clonedList = new ArrayList<>(actualList.size());
		for(Parent p : actualList) {
			clonedList.add(p.clone());
		}
		System.out.println("Displaying Cloned objects data...\n");
		for(Parent p : clonedList) {
			System.out.println(p); 
		}
		
	}

}
