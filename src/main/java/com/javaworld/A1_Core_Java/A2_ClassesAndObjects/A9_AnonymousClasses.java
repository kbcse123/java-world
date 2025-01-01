package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;
/**
 *
 */

/**
 * @author Shaik Khader
 *
 *         Anonymous classes enable you to make your code more concise. They
 *         enable you to declare and instantiate a class at the same time. They
 *         are like local classes except that they do not have a name. Use them
 *         if you need to use a local class only once.
 *
 *         Declaring Anonymous Classes:
 *
 *         . While local classes are class declarations, anonymous classes are
 *         expressions, which means that you define the class in another
 *         expression. The following example, HelloWorldAnonymousClasses, uses
 *         anonymous classes in the initialization statements of the local
 *         variables frenchGreeting and spanishGreeting, but uses a local class
 *         for the initialization of the variable englishGreeting:
 *
 *         Syntax of Anonymous Classes:
 *
 *         . As mentioned previously, an anonymous class is an expression. The
 *         syntax of an anonymous class expression is like the invocation of a
 *         constructor, except that there is a class definition contained in a
 *         block of code. . The anonymous class expression consists of the
 *         following:
 *
 *         - The new operator.
 *
 *         - The name of an interface to implement or a class to extend. In this
 *         example, the anonymous class is implementing the interface
 *         HelloWorld.
 *
 *         - Parentheses that contain the arguments to a constructor, just like
 *         a normal class instance creation expression. Note: When you implement
 *         an interface, there is no constructor, so you use an empty pair of
 *         parentheses, as in this example.
 *
 *         - A body, which is a class declaration body. More specifically, in
 *         the body, method declarations are allowed but statements are not.
 *
 *         . Because an anonymous class definition is an expression, it must be
 *         part of a statement. In this example, the anonymous class expression
 *         is part of the statement that instantiates the frenchGreeting object.
 *         (This explains why there is a semicolon after the closing brace.)
 *
 *
 */

public class A9_AnonymousClasses {
    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }

}

class HelloWorldAnonymousClasses {

    interface HelloWorld {
        public void greet(String someone);

    }

    class EnglishGreeting implements HelloWorld {
        @Override
        public void greet(String someone) {
            System.out.println("Hello " + someone);
        }
    }

    public void sayHello() {

        HelloWorld frenchGreeting = new HelloWorld() {
            public void greet(String someone) {
                System.out.println("Salut " + someone);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            public void greet(String someone) {
                System.out.println("Hola, " + someone);
            }
        };
        HelloWorld englishGreeting = new EnglishGreeting();

        englishGreeting.greet("Mick");
        frenchGreeting.greet("Fred");
        spanishGreeting.greet("Mundo");
    }

}