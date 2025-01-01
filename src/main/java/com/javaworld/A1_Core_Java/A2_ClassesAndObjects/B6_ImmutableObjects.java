package A2_ClassesAndObjects;
/**
 * 
 */

/**
 *
 .An object is considered immutable if its state cannot change after it is constructed. Maximum reliance on immutable objects is 
  widely accepted as a sound strategy for creating simple, reliable code. Immutable objects are particularly useful in concurrent 
  applications. Since they cannot change state, they cannot be corrupted by thread interference or observed in an inconsistent state.
 
 .A Strategy for Defining Immutable Objects: The following rules define a simple strategy for creating immutable objects.

	1)Ensure that the class can't be extended. 
	  	This will prevent the subclasses to override the behavior (methods). The simplest way to do this is to declare the class as 
	  	final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
	  	
    2)Make all fields final and private.
    
    3)Don't provide any methods that modify the object's state (fields).
    
    4)Ensure exclusive access to any mutable objects.
    	If the instance fields include references to mutable objects, don't allow those objects to be changed:
        - Don't provide methods that modify the mutable objects.
        - Don't share references to the mutable objects.Never store references to external, mutable objects passed to the 
          constructor;if necessary, create copies, and store references to the copies. Similarly, create copies (using copy 
          constructor) of your internal mutable objects when necessary to avoid returning the originals in your methods.
  
  
  @author Shaik Khader
 
 
 */


class MutableClass {
	int intVal;
	String stringVal;
	MutableClass(int iVal,String sVal){
		intVal =iVal;
		stringVal = sVal;
	}
	//copy constructor
	MutableClass(MutableClass mut){
		intVal =mut.getIntVal();
		stringVal = mut.getStringVal();
	}
	public int getIntVal() {
		return intVal;
	}
	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}
	public String getStringVal() {
		return stringVal;
	}
	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}
	
	public final MutableClass clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("This Object cannot be cloned");
    }
	
}

//Rule 1
final class ImmutableClass{
	//Rule 2
	final private int intVal;
	private final String stringVal;
	private MutableClass mutableClass = null;
	
	public ImmutableClass(int iVal,String sVal){
		intVal =iVal;
		stringVal = sVal;
		mutableClass = new MutableClass(intVal, stringVal);
		System.out.println("Actual Object Hashcode = "+mutableClass.hashCode()); 
	}
	//Rule 3
	public int getIntVal() {
		return intVal;
	}
	public String getStringVal() {
		return stringVal;
	}
	//Rule 4
	public MutableClass getMutableClass(){ 
		//return mutableClass.clone(); //Use copy constructor if available instead of clone() 
		return new MutableClass(mutableClass); 
	}
}


public class B6_ImmutableObjects {
	public static void main(String... args) throws CloneNotSupportedException { 
		ImmutableClass im = new ImmutableClass(1, "Hi"); 
		MutableClass mutableClass = im.getMutableClass();
		System.out.println("Returned Object Hashcode = "+mutableClass.hashCode()); 
		System.out.println("Returned Object stringVal = "+mutableClass.stringVal);
		mutableClass.setStringVal("Bye"); 
		System.out.println("After modification Returned Object stringVal = "+mutableClass.stringVal);
		System.out.println("Actual Object stringVal = "+im.getMutableClass().getStringVal());
		//mutableClass = mutableClass.clone();
	}
}
