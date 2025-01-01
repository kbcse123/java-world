/**
 * . Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic
 *   programming. To implement generics, the Java compiler applies type erasure to:
 *     - Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. 
 *       The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
 *     - Insert type casts if necessary to preserve type safety.
 *     - Generate bridge methods to preserve polymorphism in extended generic types.
 *    
 * . Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no 
 *   runtime overhead.
 *   
 * . Erasure of Generic Types: During the type erasure process, the Java compiler erases all type parameters and replaces
 *   each with its first bound if the type parameter is bounded, or Object if the type parameter is unbounded.
 *   Consider the following generic class that represents a node in a singly linked list:
     public class Node&lt;T> {
	  private T data;
	  private Node&lt;T> next;
		
	  public Node(T data, Node&lt;T> next) {
		this.data = data;
		this.next = next;
	  }
	  public T getData() { return data; }
	  // ...
     }
		
 *   Because the type parameter T is unbounded, the Java compiler replaces it with Object:
     public class Node {
	  private Object data;
	  private Node next;
		
	  public Node(Object data, Node next) {
	    this.data = data;
	    this.next = next;
		    }
	  public Object getData() { return data; }
	  // ...
     }
 *   Similarly in the following example, the generic Node class uses a bounded type parameter:
     public class Node&lt;T extends Comparable&lt;T>> {
		
	  private T data;
	  private Node&lt;T> next;
		
	  public Node(T data, Node&lt;T> next) {
	    this.data = data;
	    this.next = next;
	  }
	  public T getData() { return data; }
	  // ...
     }
		
 *   The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:
     public class Node {
		
	  private Comparable data;
	  private Node next;
		
	  public Node(Comparable data, Node next) {
	    this.data = data;
	    this.next = next;
	  }
	  public Comparable getData() { return data; }
	  // ...
     }
 * 
 * . Erasure of Generic Methods: The Java compiler also erases type parameters in generic method arguments. Consider the
 *   following generic method that counts the number of occurrences of elem in anArray.
      public static &lt;T> int count(T[] anArray, T elem) {
       int cnt = 0;
       for (T e : anArray)
        if (e.equals(elem))
         ++cnt;

       return cnt;
      }
 *   Because T is unbounded, the Java compiler replaces it with Object:
      public static int count(Object[] anArray, Object elem) {
       int cnt = 0;
       for (Object e : anArray)
         if (e.equals(elem))
            ++cnt;
       return cnt;
      }
 * 
 * . Effects of Type Erasure: Sometimes type erasure causes a situation that you may not have anticipated. The following
 *   example shows how this can occur. 
	 class Node&lt;T> {
	    public T data;
	    public Node(T data) { this.data = data; }
	    public void setData(T data) {
	        System.out.println("Node.setData");
	        this.data = data;
	    }
	}
	
	class MyNode extends Node&lt;Integer> {
	    public MyNode(Integer data) { super(data); }
	    public void setData(Integer data) {
	        System.out.println("MyNode.setData");
	        super.setData(data);
	    }	
	}
	
	public class Main {
		public static void main(String[] args) {
		 MyNode mn = new MyNode(5);
		 // A raw type - compiler throws an unchecked warning
		 Node n = mn;            
		 n.setData("Hello");   
		 // Causes a ClassCastException in the Runtime.  
		 Integer x = mn.data;    
		}
	}
 
 *   After type erasure, the main method code becomes:

		MyNode mn = new MyNode(5);
		// A raw type - compiler throws an unchecked warning
		Node n = (MyNode)mn;         
		n.setData("Hello");
		// Causes a ClassCastException to be thrown.
		Integer x = (String)mn.data; 

 *  
 *  
 *  Bridge Methods:
 *  
 *  . When compiling a class or interface that extends a parameterized class or implements a parameterized interface, the
 *   compiler may need to create a synthetic method, called a bridge method, as part of the type erasure process. You 
 *   normally don't need to worry about bridge methods, but you might be puzzled if one appears in a stack trace.
 *  
 *   After type erasure, the Node and MyNode classes become:
 	public class Node {

	    public Object data;
	
	    public Node(Object data) { this.data = data; }
	
	    public void setData(Object data) {
	        System.out.println("Node.setData");
	        this.data = data;
	    }
	}

	public class MyNode extends Node {
	
	    public MyNode(Integer data) { super(data); }
	
	    public void setData(Integer data) {
	        System.out.println("MyNode.setData");
	        super.setData(data);
	    }
	}
 * 
 *  After type erasure, the method signatures do not match. The Node method becomes setData(Object) and the MyNode method
 *  becomes setData(Integer). Therefore, the MyNode setData method does not override the Node setData method.
 *  
 *  To solve this problem and preserve the polymorphism of generic types after type erasure, a Java compiler generates a
 *  bridge method to ensure that subtyping works as expected.
 *  
 *  the compiler generates the following bridge method for setData:

	class MyNode extends Node {
	
	    // Bridge method generated by the compiler
	    public void setData(Object data) {
	        setData((Integer) data);
	    }
	
	    public void setData(Integer data) {
	        System.out.println("MyNode.setData");
	        super.setData(data);
	    }
	
	    // ...
	}
 *  
 */