package com.javaworld.A1_Core_Java.A5_Numbers_And_Strings;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 
 */

/**
 * @author Shaik Khader
 
 	. Earlier you saw the use of the print and println methods for printing strings to standard output (System.out). Since all numbers can be converted to strings, you can use 
 	  these methods to print out an arbitrary mixture of strings and numbers. The Java programming language has other methods, however, that allow you to exercise much more 
 	  control over your print output when numbers are included.
 
 The printf and format Methods:
 	
 	. The java.io package includes a PrintStream class that has two formatting methods that you can use to replace print and println. These methods, format and printf, are 
 	  equivalent to one another. The familiar System.out that you have been using happens to be a PrintStream object, so you can invoke PrintStream methods on System.out. 
 	  Thus, you can use format or printf anywhere in your code where you have previously been using print or println. For example,  System.out.format(.....);
 	  
 	. The syntax for these two java.io.PrintStream methods is the same:  public PrintStream format(String format, Object... args)
	  where format is a string that specifies the formatting to be used and args is a list of the variables to be printed using that formatting. A simple example would be

			System.out.format("The value of the float variable is %f, while the value of the integer variable is %d, and the string is %s", floatVar, intVar, stringVar);   
			 	  
 	  The first parameter, format, is a format string specifying how the objects in the second parameter, args, are to be formatted. The format string contains plain text 
 	  as well as format specifiers, which are special characters that format the arguments of Object... args.
 	  
 	. Format specifiers begin with a percent sign (%) and end with a converter. The converter is a character indicating the type of argument to be formatted. In between the 
 	  percent sign (%) and the converter you can have optional flags and specifiers. There are many converters, flags, and specifiers, which are documented in 
 	  java.util.Formatter.  
 	  
 	. The printf and format methods are overloaded. Each has a version with the following syntax:  public PrintStream format(Locale l, String format, Object... args).
	  To print numbers in the French system (where a comma is used in place of the decimal place in the English representation of floating point numbers), for example,
	  System.out.format(Locale.FRANCE,"The value of the float variable is %f, while the value of the integer variable is %d, and the string is %s%n",floatVar,intVar,stringVar);
		 	  
 An Example:

	. The "Converters_and_Flags.png" lists some of the converters and flags that are used in the TestFormat program.  
    
Note:  The discussion in this section covers just the basics of the format and printf methods. Further detail can be found in the Basic I/O section of the Essential trail, in 
	   the "Formatting" page. 	  
 	  
 The DecimalFormat Class:
 
  	. You can use the java.text.DecimalFormat class to control the display of leading and trailing zeros, prefixes and suffixes, grouping (thousands) separators, and the 
  	  decimal separator. DecimalFormat offers a great deal of flexibility in the formatting of numbers, but it can make your code more complex.

	. The example that follows creates a DecimalFormat object, myFormatter, by passing a pattern string to the DecimalFormat constructor. The format() method, which 
	  DecimalFormat inherits from NumberFormat, is then invoked by myFormatter,it accepts a double value as an argument and returns the formatted number in a string:  
 	  
 	. The "decimal_format.png" explains each line of output for DecimalFormatDemo program.
 	  
 
 */

class TestFormat {
    
    public static void displayFormats() {
      System.out.println("**** Test Formats ****");
      long n = 461012;
      System.out.format("%d%n", n);      //  -->  "461012"
      System.out.format("%08d%n", n);    //  -->  "00461012"
      System.out.format("%+8d%n", n);    //  -->  " +461012"
      System.out.format("%,8d%n", n);    // -->  " 461,012"
      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
      
      double pi = Math.PI;

      System.out.format("%f%n", pi);       // -->  "3.141593"
      System.out.format("%.3f%n", pi);     // -->  "3.142"
      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
      System.out.format(Locale.FRANCE,
                        "%-10.4f%n%n", pi); // -->  "3,1416"

      Calendar c = Calendar.getInstance();
      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "November 5, 2017"

      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 pm"

      System.out.format("%tD%n", c);    // -->  "11/05/17"
    }
}

class DecimalFormatDemo {

	   static public void customFormat(String pattern, double value ) {
	      DecimalFormat myFormatter = new DecimalFormat(pattern);
	      String output = myFormatter.format(value);
	      System.out.println(value + "  " + pattern + "  " + output);
	   }

	   static public void displayCustomFormats() {
		  System.out.format("%n**** Custom Decimal Formats ****%n");
	      customFormat("###,###.###", 123456.789);
	      customFormat("###.##", 123456.789);
	      customFormat("000000.000", 123.78);
	      customFormat("$###,###.###", 12345.67);  
	   }
	}


public class A2_Formatting_Numeric_Print_Output {
	public static void main(String... args) {
		TestFormat.displayFormats();
		DecimalFormatDemo.displayCustomFormats();
	}

}
