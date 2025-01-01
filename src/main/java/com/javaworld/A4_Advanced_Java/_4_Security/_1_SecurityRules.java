/**
 * 
 */
package com.javaworld.A4_Advanced_Java._4_Security;

/**
 * @author Shaik
 * 
 Rules for developing secured Java code:
 
 	Rule 1: Don't depend on initialization	- Most Java developers think there is no way to allocate an object without running a constructor. But this isn't true: there are 
 			several ways to allocate noninitialized objects( eg. static factory method).
 	
 	Rule 2: Limit access to your classes, methods, and variables - Every class, method, and variable that is not private provides a potential entry point for an attacker. 
 			By default, everything should be private. Make something nonprivate only with good reason, and document that reason.
 	
 	Rule 3: Make everything final - If a class or method isn't final, an attacker could try to extend it in a dangerous and unforeseen way. By default, everything should be
 	 		final. Make something nonfinal only if there is a good reason, and document that reason. You might think you can prevent an attacker from extending your class or
 	 		its methods by declaring the class nonpublic. But if a class isn't public, it must be accessible from within the same package, and as Rule 4 (below) says, you
 			shouldn't to rely on package scope access restrictions for security.
			This advice may seem harsh. After all, the rule is asking you to give up extensibility, which is one of the main benefits of using an object-oriented language 
			like Java. But when you're trying to provide security, extensibility is your enemy: it just provides an attacker with more ways to cause trouble.
 	
 	Rule 4: Don't depend on package scope.
 	
 	Rule 5: Don't use inner classes	- Some Java language books say inner classes can be accessed only by the outer classes that enclose them. But this isn't true. 
 			Java bytecode has no concept of inner classes, so inner classes are translated by the compiler into ordinary classes that happen to be accessible to any code in
 			the same package. And Rule 4 says not to depend on package scope for protection.
 	
 	Rule 6: Avoid signing your code or If you must sign your code, put it all in one archive file.
 			
 	Rule 7: Make your classes noncloneable	-	Java's object cloning mechanism can allow an attacker to manufacture new instances of classes you define, without executing 
 			any of your constructors. If your class isn't cloneable, the attacker can define a subclass of your class, and make the subclass implement java.lang.Cloneable. 
 			This lets an attacker create new instances of your class. The new instances are made by copying the memory images of existing objects		
 			
 			You can do this by defining the following method in each of your classes:

			public final void clone() throws java.lang.CloneNotSupportedException {
			        throw new java.lang.CloneNotSupportedException();
			}
			
			If you want your class to be cloneable, and you've considered the consequences of that choice, then you can still protect yourself. If you're defining a clone 
			method yourself, make it final. If you're relying on a nonfinal clone method in one of your superclasses, then define this method:
			
			public final void clone() throws java.lang.CloneNotSupportedException {
			        super.clone();
			}
			
			This prevents an attacker from redefining your clone method.
			
			
			
			
			
 *
 */
public class _1_SecurityRules {
}
	