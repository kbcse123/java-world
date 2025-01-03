package com.javaworld.A1_Core_Java.A6_Generics;
/**
 * . Generics were added to the Java language to enforce "type safety at compile time" by enabling types (classes and 
 *   interfaces) to be parameters when defining classes, interfaces and methods. 
 * . Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to
 *   re-use the same code with different inputs.
 * . The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.
 * 
 * . Code that uses generics has many benefits over non-generic code:
 *    1)Stronger type checks at compile time - A Java compiler applies strong type checking to generic code and issues
 *      errors if the code violates type safety. Fixing compile-time errors is easier than fixing runtime errors, which
 *      can be difficult to find.
 * 
 *    2)Elimination of casts - The following code snippet without generics requires casting:
         List list = new ArrayList(); 
         list.add("hello"); 
         String s = (String) list.get(0);

 *      When re-written to use generics, the code does not require casting: 
         List &lt;String&gt; list = new ArrayList &lt;String&gt;(); 
         list.add("hello"); 
         String s = list.get(0); // no cast
 * 
 *    3)Implementation of generic algorithms - By using generics, programmers can implement generic algorithms that work
 *      on collections of different types, can be customized, and are type safe and easier to read.
 */