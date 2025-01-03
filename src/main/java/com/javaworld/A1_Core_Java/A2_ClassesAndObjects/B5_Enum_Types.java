package com.javaworld.A1_Core_Java.A2_ClassesAndObjects;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         . An enum type is a special data type that enables a set of
 *         predefined constants for a variable. Common examples include compass
 *         directions (values of NORTH, SOUTH, EAST, and WEST) and the days of
 *         the week. Because they are constants, the names of an enum type's
 *         fields are in uppercase letters.
 * 
 *         . you define an enum type by using the enum keyword.
 * 
 *         . You should use enum types any time you need to represent a fixed
 *         set of constants and data sets where you know all possible values at
 *         compile time,for example, the Solar system, the choices on a menu and
 *         so on.
 * 
 *         . Java programming language enum types are much more powerful than
 *         their counterparts in other languages. The enum declaration defines a
 *         class. The enum class body can include methods and other fields. The
 *         compiler automatically adds some special methods when it creates an
 *         enum. For example, they have a static values() method that returns an
 *         array containing all of the values of the enum in the order they are
 *         declared. This method is commonly used in combination with the
 *         for-each construct to iterate over the values of an enum type.
 * 
 *         Note: All enums implicitly extend java.lang.Enum. Because a class can
 *         only extend one parent, the Java language does not support multiple
 *         inheritance of state, and therefore an enum cannot extend anything
 *         else.
 * 
 *         . In the below example, Planet is an enum type that represents the
 *         planets in the solar system. They are defined with constant mass and
 *         radius properties.
 * 
 *         . Each enum constant is declared with values for the mass and radius
 *         parameters. These values are passed to the constructor when the
 *         constant is created. Java requires that the constants be defined
 *         first, prior to any fields or methods. Also, when there are fields
 *         and methods, the list of enum constants must end with a semicolon.
 * 
 *         Note: The constructor for an enum type must be package-private or
 *         private access. It automatically creates the constants that are
 *         defined at the beginning of the enum body. You cannot invoke an enum
 *         constructor yourself. If no constructor is provided then JVM defines
 *         a default private constructor for it.
 * 
 *         . In addition to its properties and constructor, Planet has methods
 *         that allow you to retrieve the surface gravity and weight of an
 *         object on each planet. Below is a sample program that takes your
 *         weight on earth (in any unit) and calculates and prints your weight
 *         on all of the planets (in the same unit):
 * 
 * 
 * 
 */

enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

class Days {
	Day day;

	public Days(Day day) {
		this.day = day;
	}

	public void describe() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;
		case FRIDAY:
			System.out.println("Fridays are better.");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}

}

enum Planet {
	MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23,
			3.3972e6), JUPITER(1.9e+27,
					7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

	private final double mass; // in kilograms
	private final double radius; // in meters

	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}

	// universal gravitational constant (m3 kg-1 s-2)
	public static final double G = 6.67300E-11;

	double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}

}

public class B5_Enum_Types {

	public static void main(String... args) {
		System.out.println("**** Days Example ****");
		Days firstDay = new Days(Day.MONDAY);
		firstDay.describe();
		System.out.println("**** Random Day Example ****");
		Days randomDay = new Days(Day.values()[(int) (Math.random() * Day.values().length)]);
		randomDay.describe();

		System.out.println("\n**** Planets Example ****");
		double earthWeight = 75;
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));

	}

}
