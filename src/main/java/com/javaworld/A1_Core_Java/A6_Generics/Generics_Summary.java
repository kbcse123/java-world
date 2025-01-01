/**
 * Introduction:
 *  - Generics were added to the Java language to enforce "type safety at compile time" by enabling types to be parameters
 *    when defining classes, interfaces and methods.
 *  - Code that uses generics has many benefits over non-generic code:
 *      . Stronger type checks at compile time
 *      . Elimination of casts
 *      . Implementation of generic algorithms
 *  
 * Generic Types Single Type Parameter: 
 *  - A generic type is a generic class or interface that is parameterized over types.
 *  - A type variable T can be any non-primitive type like any class type, any interface type, any array type, or even 
 *    another type variable.
 *  - By convention, type parameter names are single, uppercase letters.
 * 
 * Generic Types Multiple Type Parameters:
 *  - A generic class can have multiple type parameters defined with the format: class name&lt;T1, T2, ..., Tn> { }.
 *  - In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a generic class with
 *    an empty set of type arguments <> (Diamond notation).
 *  - This ability of Java compiler to conclude the type is called 'Type Inference'.
 * 
 * Raw Types:
 *  - A raw type is the name of a generic class or interface without any type arguments.
 *  - Note that A non-generic class or interface type is not a raw type.
 *  - For backward compatibility, assigning a parameterized type to its raw type is allowed but vice versa you will get a
 *    warning. You also get a warning if you use a raw type to invoke generic methods defined in the corresponding generic
 *    type.
 *  - Raw types bypass generic type checks, deferring the catch of unsafe code to runtime. Therefore, you should avoid 
 *    using raw types.
 *  
 * Generic Methods:
 *  - Generic methods are methods that introduce their own type parameters.
 *  - This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is 
 *    declared.
 *  - Static and non-static generic methods, as well as generic class constructors are allowed.
 *  - The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's 
 *    return type.  eg.  public static &lt;K, V> boolean compare(Pairs&lt;K, V> p1, Pairs&lt;K, V> p2){}
 *  
 * Bounded Type Parameters:
 *  - When you want to restrict the types that can be used as type arguments in a parameterized type.
 *  - In addition to limiting the types you can use to instantiate a generic type, bounded type parameters allow you to 
 *    invoke methods defined in the bounds. For example: t.intValue()
 *  - A type parameter can have multiple bounds and is a subtype of all the types listed in the bound. If one of the bounds
 *    is a class, it must be specified first otherwise it will lead to compile-time error.
 *  - Therefore Bounded type parameters are key to the implementation of generic algorithms.
 *  - Declaring a bounded type parameter:
         public class BoundedClass&lt;T extends Number> {}
         public interface BoundedInterface&lt;T extends Serializable>{}
         public class MultiBoundedClasse&lt;T extends Number & Serializable>{}
 *  
 * Generics, Inheritance and Subtypes: 
 *  - You can subtype a generic class or interface by extending or implementing it. 
 *  - The relationship between the type parameters of one class or interface and the type parameters of another are 
 *    determined by the extends and implements clauses.
 *  - For example, ArrayList&lt;E> implements List&lt;E>, and List&lt;E> extends Collection&lt;E>. So ArrayList&lt;String> 
 *    is a subtype of List&lt;String>, which is a subtype of Collection&lt;String>. So as long as you do not vary the type 
 *    argument, the subtyping relationship is preserved between the types.
 *  
 * Type Inference:
 *  - Type inference is a Java compiler's ability to look at each method invocation and corresponding declaration to 
 *    determine the type argument (or arguments).
 *  - This feature allows you to invoke a generic method as an ordinary method, without specifying a "type witness" 
 *    between angle brackets. For example: 
 *     1) Util.&lt;Integer, String>compare(p1, p2) can be written as Util.compare(p1, p2); - Generic method. 
 *     2) GenericBox&lt;String> box = new GenericBox&lt;String>() can be written as 
 *        GenericBox&lt;String> box = new GenericBox&lt;>(); - Generic class constructor.
 *  - It is important to note that the inference algorithm uses only invocation arguments, target types, and possibly an
 *    obvious expected return type to infer types. It does not use results from later in the program.
 *  
 * Wildcard Or UnknownType:
 *  - In Generics, the question mark (?), called the wildcard, represents an unknown type that can be used as the type of
 *    a parameter, field, or local variable; sometimes as a return type.
 *  - Upper Bounded Wildcards &lt;? extends T>: An upper bounded wildcard restricts the unknown type to be a specific 
 *    type T or a sub-type of T. For eg. List&lt;? extends Number> represents Number or any of its sub classes like Integer,
 *    Double, Float etc.
 *  - Lower Bounded Wildcards &lt;? super T>: A lower bounded wildcard restricts the unknown type to be a specific type T
 *    or a super-type of T. For eg: List&lt;? super Integer> represents Integer or any of its super classes like Number, 
 *    Object etc.
 *  - Unbounded wildcard &lt;?>: An Unbounded wildcard can represent any type, similar to Object in Java. It provides highest
 *    level of flexibility on passing method argument. For eg. List&lt;?> (list of unknown type) represents any List 
 *    i.e, List&lt;String> or List&lt;Integer>.  
 *  - Wildcard Capture and Helper Methods: In some cases, the compiler infers the type of a wildcard. For example, a 
 *    list may be defined as List&lt;?> but, when evaluating an expression, the compiler infers a particular type from the
 *    code. This scenario is known as wildcard capture. For the most part, you don't need to worry about wildcard capture,
 *    except when you see an error message that contains the phrase "capture of".
 *    For example, in the below code the compiler is not able to confirm the type of object that is being inserted into the
 *    list, and an compile time error is produced, "The method set(int, capture#8-of ?) in the type List&lt;capture#8-of ?>
 *    is not applicable for the arguments (int, capture#9-of ?)".
       void wildcardCaptureUsingHelperMethod(List&lt;?> list) {
        for (int i = 0; i &lt; list.size(); i++) {
         list.set(i, list.get(i));
        }
       }
	    
 *    You can fix it by writing a private helper method which captures the wildcard.
       void wildcardCaptureUsingHelperMethod(List&lt;?> list) {
        helperMethod(list);
       }
       private &lt;T> void helperMethod(List&lt;T> l) {
        for (int i = 0; i &lt; l.size(); i++) {
         l.set(i, l.get(i));
        }
       }
 *
 *  - Do's and Dont's:
 *   -> The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation,
 *      or a super-type. 
 *   -> You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both. 
 *   -> It's important to note that List&lt;Object> and List &lt;?> are not the same. You can insert an Object, or any 
 *      sub-type of Object, into a List&lt;Object>, But you can only insert null into a List&lt;?>.
 *   -> Using a wildcard as a return type should be avoided because it forces programmers using the code to deal with 
 *      wildcards.  
 *      
 * Type Erasure and Bridge Methods:
 *  - the Java compiler applies type erasure to:
 *     -> Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded.
 *        The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
 *     -> Insert type casts if necessary to preserve type safety.
 *     -> Generate bridge methods to preserve polymorphism in extended generic types.
 *
 */