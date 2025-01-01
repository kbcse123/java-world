/**
 * . Local classes are classes that are defined in a block, which is a group of
 * zero or more statements between balanced braces. You typically find local
 * classes defined in the body of a method.
 * 
 * . Starting in Java SE 8, a local class can access local variables and
 * parameters of the enclosing block that are final or effectively final. A
 * variable or parameter whose value is never changed after it is initialized is
 * effectively final.
 * 
 * . Local classes are similar to inner classes because they cannot define or
 * declare any static members. It can have static members provided that they are
 * constant variables.
 * 
 * . You can define a local class inside any block. For example, you can define
 * a local class in a method body, a for loop, or an if clause. The following
 * example, LocalClassExample, validates two phone numbers. It defines the local
 * class PhoneNumber in the method validatePhoneNumber. The example validates a
 * phone number by first removing all characters from the phone number except
 * the digits 0 through 9. After, it checks whether the phone number contains
 * exactly ten digits.
 * 
 * . Local classes in static methods, such as the class PhoneNumber, which is
 * defined in the static method validatePhoneNumber, can only refer to static
 * members of the enclosing class.
 * 
 * . You cannot declare an interface inside a block; interfaces are inherently
 * static.
 * 
 * . You cannot declare static initializers or member interfaces in a local
 * class.
 * 
 * public void sayGoodbyeInEnglish() { class EnglishGoodbye { public static void
 * sayGoodbye() { System.out.println("Bye bye"); } }
 * EnglishGoodbye.sayGoodbye(); }
 * 
 * 
 * 
 */

class LocalClassExample {

	static String regularExpression = "[^0-9]";

	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

		final int numberLength = 10;

		// int numberLength = 10;  //Valid in JDK 8 and later: effective final

		class PhoneNumber {

			String formattedPhoneNumber = null;

			PhoneNumber(String phoneNumber) {
				// numberLength = 7;
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if (currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}

			public String getNumber() {
				return formattedPhoneNumber;
			}

			// Valid in JDK 8 and later:

			// public void printOriginalNumbers() {
			// System.out.println("Original numbers are " + phoneNumber1 +
			// " and " + phoneNumber2);
			// }
		}

		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

		// Valid in JDK 8 and later:
		// myNumber1.printOriginalNumbers();

		if (myNumber1.getNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + myNumber1.getNumber());
		if (myNumber2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + myNumber2.getNumber());

	}

}

public class A8_LocalClasses {
	public static void main(String... args) {
		LocalClassExample.validatePhoneNumber("123-456-7890", "456-7890");
	}

}
