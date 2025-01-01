package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;

/**
 * OBJECT CLASS:
 * The Object class is the parent class of all the classes in java by default. In other words, it is the
 * root of the class hierarchy. The Object class provides some common behaviors to all the objects such as
 * object can be compared, cloned, notified etc.
 * <p>
 * STATIC:
 * . When objects are created from the same class blueprint, they each have their own distinct copies of instance
 * variables.
 * . Sometimes, you want to have variables that are common to all objects. This is accomplished with the static
 * modifier. Fields that have the static modifier in their declaration are called static fields or class variables.
 * They are associated with the class, rather than with any object.
 * . Static methods, which have the static modifier in their declarations, should be invoked with the class name,
 * without the need for creating an instance of the class , as in "ClassName.methodName(args)".
 * . A common use for static methods is to access static fields.
 * . Not all combinations of instance, class variables and methods are allowed:
 *  - Instance methods can access instance variables, instance methods, class variables and class methods directly.
 *  - static methods can access other static variables and static methods directly.
 *  - static methods cannot access instance variables or instance methods directly,they must use an object reference.
 * Also, static methods cannot use 'this' keyword as there is no instance for this to refer to.
 * . The static modifier, in combination with the final modifier, is also used to define constants. The final modifier
 *   indicates that the value of this field cannot change.
 * <p>
 * INITIALIZING FIELDS:
 * . You can often provide an initial value for a field in its declaration itself.
 * . This works well when the initialization value is available and the initialization can be put on one line. However,
 *   this form of initialization has limitations because of its simplicity.
 * . If initialization requires some logic (for example, error handling or a for loop to fill a complex array), simple
 *   assignment is inadequate.
 * Static Initialization Blocks:
 * . A static initialization block is a normal block of code enclosed in braces { }, and preceded by the static keyword.
 * . A class can have any number of static initialization blocks, and they can appear anywhere in the class body.
 * . The runtime system guarantees that static initialization blocks are called in the order that they appear in the
 * source code.
 * . There is an alternative to static blocks , you can write a private static method.
 * . The advantage of private static methods is that they can be reused later if you need to reinitialize the class
 * variable.
 * Initializing Instance variables:
 * . There are two alternatives to using a constructor to initialize instance variables: initializer blocks and final
 * methods.
 * - Initializer blocks for instance variables look just like static initializer blocks, but without the static keyword
 * The Java compiler copies initializer blocks into every constructor. Therefore, this approach can be used to share
 * a block of code between multiple constructors.
 * - A final method cannot be overridden in a subclass. This is especially useful if subclasses might want to reuse
 * the initialization method. The method is final because calling non-final methods during instance initialization
 * can cause problems.
 * <p>
 * NESTED CLASSES:
 * Java allows you to define a class within another class. Such a class is called a nested class and is a member of its
 * enclosing class.
 * . Nested classes are divided into two categories:
 *  - Static nested classes:  Like static methods, a static nested class cannot refer directly to instance variables
 *    or methods defined in its enclosing class. it can use them only through an object reference.
 *    To create an object for the static nested class, use the below syntax:
 *      OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
 *  - Non-static nested classes (inner classes):  Have access to other members of the enclosing class, even if they are
 *    declared private. There are two special kinds of inner classes: local classes and anonymous classes.
 *    To create an object for the inner class, use the below syntax:
 *      OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();
 *   . As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
 *   . It is a way of logically grouping classes that are only used in one place
 *   . It increases encapsulation also lead to more readable and maintainable code
 *   . Serialization of inner classes, including local and anonymous classes, is strongly discouraged as there might be
 *     compatibility issues if you deserialize it with a different JRE implementation.
 * <p>
 * LOCAL CLASSES:
 * . Classes that are defined in a block(method body, a for loop, or an if clause), which is a group of zero or more
 * statements between balanced braces.
 * . A local class can access local variables and parameters of the enclosing block that are final or effectively final.
 * . It can have static members that are constant variables.
 * . Local classes in static methods can only refer to static members of the enclosing class.
 * . You cannot declare static initializers or interface inside a block; interfaces are inherently static.
 * <p>
 * ANONYMOUS CLASSES:
 * . Enable you to make your code more concise. They enable you to declare and instantiate a class at
 * the same time. They are like local classes except that they do not have a name. Use them if you need to use a
 * local class only once.
 * . While local classes are class declarations, anonymous classes are expressions, which means that you define the
 * class in another expression.
 * <p>
 * LAMBDA EXPRESSIONS:
 * . One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as
 * an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear.
 * In these cases, you're usually trying to pass functionality as an argument to another method, such as what
 * action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat
 * functionality as method argument, or code as data.
 * . You can serialize a lambda expression if its target type and its captured arguments are serializable. However,
 * like inner classes, the serialization of lambda expressions is strongly discouraged.
 * <p>
 * METHOD REFERENCE:
 * . You use lambda expressions to create anonymous methods. Sometimes, however, a lambda expression does nothing but
 * call an existing method. In those cases, it's often clearer to refer to the existing method by name.
 * Method references enable you to do this; they are compact, easy-to-read lambda expressions for methods that already
 * have a name.
 * . So the method reference Person::compareByAge is semantically the same as the lambda expression
 * (a, b) -> Person.compareByAge(a, b).
 * . There are four kinds of method references:
 *      1. Reference to a static method -
 *          eg: Collections.sort(persons,Person::compareByAge);
 *      2. Reference to an instance method of a particular object	-
 *          eg: Person personObj = new Person();
 *              Collections.sort(persons,personObj::compareByName);
 *      3. Reference to an instance method of an arbitrary object of particular type -
 *          eg: String[] stringArray = {"Barbara","James","Mary","John","Patricia","Robert","Michael","Linda"};
 *          Arrays.sort(stringArray, String::compareToIgnoreCase);
 *      4. Reference to a constructor -
 *          eg: List<Person> methodRef = Person.transferElements(persons, ArrayList::new);
 * <p>
 * When to Use What (Nested Classes, Local Classes, Anonymous Classes, and Lambda Expressions):
 * 1. Local class - Use it if you need to create more than one instance of a class, access its constructor, or introduce
 * a new, named type (because, for example, you need to invoke additional methods later).
 * 2. Anonymous class - Use it if you need to declare fields or additional methods.
 * 3. Lambda expression - Use it if you are encapsulating a single unit of behavior that you want to pass to other code.
 *      Use it if you need a simple instance of a functional interface that you want to pass to other code and none of the
 *      preceding criteria apply. (for example, you do not need a constructor, a named type, fields, or additional methods).
 * 4. Nested class - Use it if your requirements are similar to those of a local class, you want to make the type more
 * widely available, and you don't require access to local variables or method parameters.
 * <p>
 * ENUM TYPES:
 * . An enum type is a special data type that enables a set of predefined constants for a variable. Common examples
 * include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week. Because they are
 * constants, the names of an enum type's fields are in uppercase letters.
 * . You should use enum types any time you need to represent a fixed set of constants and data sets where you know all
 * possible values at compile time,for example, the Solar system, the choices on a menu and so on.
 * . Java enum types are much more powerful than their counterparts in other languages. The enum declaration defines a
 * class, The enum class body can include methods and other fields. The compiler automatically adds some special
 * methods when it creates an enum. For example: values(), valueOf() methods.
 * . All enums implicitly extend java.lang.Enum. Because a class can only extend one parent, the Java language does
 * not support multiple inheritance of state, and therefore an enum cannot extend anything else.
 * . Java requires that the constants be defined first, prior to any fields or methods. Also, when there are fields
 * and methods, the list of enum constants must end with a semicolon.
 * . The constructor for an enum type must be package-private or private access. It automatically creates the constants
 * that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself. If no
 * constructor is provided then JVM defines a default private constructor for it.
 * <p>
 * IMMUTABLE OBJECTS:
 * . An object is considered immutable if its state cannot change after it is constructed. Immutable objects are
 * particularly useful in concurrent applications. Since they cannot change state, they cannot be corrupted by
 * thread interference or observed in an inconsistent state.
 * . A Strategy for Defining Immutable Objects:
 * 1) Ensure that the class can't be extended - This will prevent the subclasses to override the behavior (methods).
 * The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the
 * constructor private and construct instances in factory methods.
 * 2) Make all fields final and private.
 * 3) Don't provide any methods that modify the object's state (fields). Eg: setter methods
 * 4) Ensure exclusive access to any mutable objects.
 *    If the instance fields include references to mutable objects, don't allow those objects to be changed:
 *     - Don't provide methods that modify the mutable objects.
 *     - Don't share references to the mutable objects.Never store references to external, mutable objects
 *      passed to the constructor;if necessary, create copies, and store references to the copies. Similarly,
 *      create copies (using copy constructor) of your internal mutable objects when necessary to avoid
 *      returning the originals in your methods.
 * <p>
 * OBJECT CLONING:  protected Object clone()  throws CloneNotSupportedException
 * . Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object.
 * The general intent is that, for any object x, the expression:
 * x.clone() != x will be true,
 * x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
 * x.clone().equals(x) will be true,this is not an absolute requirement.
 * . By convention, the returned object should be obtained by calling super.clone.
 * . By convention, the object returned by this method should be independent of the object which is being cloned.
 * To achieve this independence, it may be necessary to modify one or more fields (replacing the references to these
 * objects with references to the copies) of the object returned by super.clone before returning it.
 * . If a class contains only primitive fields or references to immutable objects, then it is usually the case that
 * no fields in the object returned by super.clone need to be modified.
 * . To support cloning, class must implement Cloneable (Marker) interface and should override Object.clone
 * (which is protected) with a public method. Not implementing the Cloneable interface will results in the exception
 * CloneNotSupportedException being thrown.
 * <p>
 * COPY CONSTRUCTOR (DEEP CLONING) Vs CLONING (SHALLOW CLONING)
 * . Words of Joshua Bloch:   source - https://www.artima.com/intv/bloch13.html
 * " I think clone is deeply broken: There are a few design flaws, the biggest of which is that the Cloneable
 * interface does not have a clone method. And that means it simply doesn't work: making something Cloneable
 * doesn't say anything about what you can do with it. Instead, it says something about what it can do internally.
 * It says that if by calling super.clone repeatedly it ends up calling Object's clone method, this method will
 * return a field copy of the original.
 * <p>
 * Object's clone method is very tricky: It's based on field copies, and it's "extra-linguistic." It creates an
 * object without calling a constructor. There are no guarantees that it preserves the invariants established by
 * the constructors. There have been lots of bugs over the years, both in and outside Sun, stemming from the fact
 * that if you just call super.clone repeatedly up the chain until you have cloned an object, you have a shallow
 * copy of the object. The clone generally shares state with the object being cloned. If that state is mutable,
 * you don't have two independent objects. If you modify one, the other changes as well. And all of a sudden,
 * you get random behavior.
 *
 * There are very few things for which I use Cloneable anymore. I often provide a public clone method on
 * concrete classes because people expect it. I don't have abstract classes implement Cloneable, nor do I have
 * interfaces extend it, because I won't place the burden of implementing Cloneable on all the classes that extend
 * (or implement) the abstract class (or interface). It's a real burden, with few benefits. Doug Lea goes even further.
 * He told me that he doesn't use clone anymore except to copy arrays. You should use clone to copy arrays, because
 * that's generally the fastest way to do it. But Doug's types simply don't implement Cloneable anymore.
 * He's given up on it. And I think that's not unreasonable.
 * ArrayList<A> list2 = new ArrayList<A>();
 *      for(A a : list1) {
 *          list2.add(a.clone());
 *      }
 * . The problem of cloning can be overcome by creating copy constructor with field to field mapping inside it. In this
 * way you don't need to implement the Cloneable interface.
 *      public A clone() {
 *          return new A(this);
 *      }
 *
 */


public class Classes_Objects_Summary {

}
