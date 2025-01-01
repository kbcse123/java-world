package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;
/**
 * 
 */

/**
 * @author Shaik Khader
 
 protected Object clone()  throws CloneNotSupportedException

	Creates and returns a copy of the object. By convention, the object returned by this method should be independent of this object
	(which is being cloned).  This method creates a new instance of the class of this object and initializes all its fields with
	exactly the contents of the corresponding fields of this object, as if by assignment; the contents of the fields are not 
	themselves cloned. Thus, this method performs a "shallow copy" of this object, not a "deep copy" operation.
	The class Object does not itself implement the interface Cloneable, so calling the clone method on an object whose class is 
	Object will result in throwing an exception at run time.

 Cloneable Interface:

	.A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a 
	 field-for-field copy of instances of that class. 
	
	.Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the exception 
	 CloneNotSupportedException being thrown.
	
	.By convention, classes that implement this interface should override Object.clone (which is protected) with a public method. 
	 See Object.clone() for details on overriding this method.
	
	.Note that this interface does not contain the clone method. Therefore, it is not possible to clone an object merely by virtue of 
	 the fact that it implements this interface. Even if the clone method is invoked reflectively, there is no guarantee that it will 
	 succeed.
 
 */


class CompositeObject{
	String str;
	CompositeObject(String s){
		str =s;
	}
}
class CloneDemo implements Cloneable{
	int num;
	String str;
	CompositeObject referenceObject;
	CloneDemo(int n,String s){
		num = n;
		str = s;
	}
	
	public void setReferenceObject(CompositeObject ref){
		referenceObject = ref;
	}

	public CompositeObject getReferenceObject(){
		return referenceObject;
	}

	@Override
	protected CloneDemo clone() {
		CloneDemo clone = null;
		try {
			clone = (CloneDemo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone; 
	}
	
	@Override
	public String toString(){
		return "num = "+num+", str = "+str+", hashcode ="+this.hashCode()+"\nReference Object: str ="
				+referenceObject.str+", hashcode = "+referenceObject.hashCode();
	}
}


public class B7_ObjectCloning {
	public static void main(String... args) {
		CloneDemo actualObj = new CloneDemo(10,"Ten");
		actualObj.setReferenceObject(new CompositeObject("Hi Reference Object"));
		CloneDemo clonedObj = actualObj.clone();
		System.out.println("Actual Object...");
		System.out.println(actualObj);
		System.out.println("\nCloned Object...");
		System.out.println(clonedObj);
		
		System.out.println("\nTesting Object Cloning contract");
		System.out.println("clone != actual : "+(clonedObj != actualObj));
		System.out.println("clone.equals(actual) : "+(clonedObj.equals(actualObj)));
		System.out.println("clone.getClass() == actual.getClass() : "+(clonedObj.getClass() == actualObj.getClass()));
	}

}
