package A5_Numbers_And_Strings;
/**
 *
 */

/**
 * @author Shaik Khader

. When working with numbers, most of the time you use the primitive types in your code. For example:

int i = 500;
float gpa = 3.65f;
byte mask = 0xff;
. There are, however, reasons to use objects in place of primitives, and the Java platform provides wrapper classes for each of the primitive data types. These classes "wrap"
the primitive in an object. Often, the wrapping is done by the compiler,if you use a primitive where an object is expected, the compiler boxes the primitive in its wrapper
class for you. Similarly, if you use a number object when a primitive is expected, the compiler unboxes the object for you.

. All of the numeric wrapper classes are subclasses of the abstract class Number.

Note: There are four other subclasses of Number that are not discussed here. BigDecimal and BigInteger are used for high-precision calculations. AtomicInteger and AtomicLong are
used for multi-threaded applications.

. The "Implemented_methods.png" lists the instance methods that all the subclasses of the Number class implement.

. Each Number class contains other methods that are useful for converting numbers to and from strings and for converting between number systems.

. The "conversion_methods.png" lists these methods in the Integer class. Methods for the other Number subclasses are similar.



 */


public class A1_The_Numbers_Classes {
    public static void main(String... args) {

    }

}
