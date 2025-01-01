package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * @author Shaik Khader
 
 */


class ReferenceObject{
	String s="Actual";
}

class ShallowCopy implements Cloneable{
	ReferenceObject ro = new ReferenceObject();
	
	@Override
	protected ShallowCopy clone(){
		ShallowCopy clone = null;
		try {
			clone = (ShallowCopy) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}

class DeepCopy{
	
}


public class C1_Shallow_vs_Deep_copy {
	
	public static void main(String... args) {
		ShallowCopy shallowCopy = new ShallowCopy();
		ShallowCopy cloneCopy = shallowCopy.clone();
		System.out.println("shallowCopy hashcode="+shallowCopy.hashCode());
		System.out.println("shallowCopy.ro hashcode="+shallowCopy.ro.hashCode());
		System.out.println("cloneCopy hashcode="+cloneCopy.hashCode());
		System.out.println("cloneCopy.ro  hashcode="+cloneCopy.ro.hashCode());
		System.out.println("Before Modification shallowCopy.ro.s ="+shallowCopy.ro.s);
		cloneCopy.ro.s="modified";
		System.out.println("After Modification shallowCopy.ro.s ="+shallowCopy.ro.s);
		
	}
	

}
