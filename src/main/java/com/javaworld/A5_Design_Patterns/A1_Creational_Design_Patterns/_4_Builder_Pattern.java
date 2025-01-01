package com.javaworld.A5_Design_Patterns.A1_Creational_Design_Patterns;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 * 
 *         Builder pattern was introduced to solve some of the problems with
 *         Factory and Abstract Factory design patterns.There are three major
 *         issues with Factory and Abstract Factory design patterns when the
 *         Object contains a lot of attributes.
 * 
 *         .Too Many arguments to pass from client program to the Factory class
 *         that can be error prone and its hard to maintain the order of the
 *         argument.
 * 
 *         .Some of the parameters might be optional but in Factory pattern,we
 *         are forced to send all the parameters and optional parameters need to
 *         send as NULL.
 * 
 *         .If the object is heavy and its creation is complex, then all that
 *         complexity will be part of Factory classes that is confusing.
 * 
 *         We can solve the issues with large number of parameters by providing
 *         constructor with required parameters and then different setter
 *         methods to set the optional parameters but the problem with this
 *         approach is that the Object state will be inconsistent until unless
 *         all the attributes are set explicitly.
 * 
 *         Builder pattern solves the issue with large number of optional
 *         parameters and inconsistent state by providing a way to build the
 *         object step-by-step and provide a method that will actually return
 *         the final Object.
 * 
 *         Implementation: We should follow the naming convention and if the
 *         class name is Computer then builder class should be named as
 *         ComputerBuilder.
 * 
 *         .Builder class should have a public constructor with all the required
 *         attributes as parameters. .Builder class should have methods to set
 *         the optional parameters and it should return the same Builder object
 *         after setting the optional attribute. .The final step is to provide a
 *         build() method in the builder class that will return the Object
 *         needed by client program.For this we need to have a public
 *         constructor in the class with Builder class as an argument.
 * 
 *         Look the example below.
 * 
 *         Notice that Computer class has only getter methods and no default
 *         constructor. So the only way to get a Computer object is through the
 *         ComputerBuilder class.
 * 
 *         Examples in JDK:
 * 
 *         java.lang.StringBuilder#append() (unsynchronized)
 *         java.lang.StringBuffer#append() (synchronized)
 * 
 * 
 */

class ComputerClass {

	// required parameters
	private String HDD;
	private String RAM;
	private String CPU;

	// optional parameters
	private boolean graphicsCardOn;
	private boolean bluetoothOn;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public String getCPU() {
		return CPU;
	}

	public boolean isGraphicsCardOn() {
		return graphicsCardOn;
	}

	public boolean isBluetoothOn() {
		return bluetoothOn;
	}

	public ComputerClass(ComputerBuilder builder) {
		HDD = builder.getHDD();
		RAM = builder.getRAM();
		CPU = builder.getCPU();
		graphicsCardOn = builder.isGraphicsCardOn();
		bluetoothOn = builder.isBluetoothOn();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("HDD = ").append(HDD).append(", RAM = ").append(RAM).append(", CPU = ").append(CPU)
				.append(", GraphicsCardOn = ").append(graphicsCardOn).append(", bluetoothOn = ").append(bluetoothOn);

		return sb.toString();
	}

	
	// Builder Class
	static class ComputerBuilder {

		// required parameters
		private String HDD;
		private String RAM;
		private String CPU;

		// optional parameters
		private boolean graphicsCardOn;
		private boolean bluetoothOn;

		public ComputerBuilder(String hdd, String ram, String cpu) {
			HDD = hdd;
			RAM = ram;
			CPU = cpu;
		}

		public String getHDD() {
			return HDD;
		}

		public void setHDD(String hDD) {
			HDD = hDD;
		}

		public String getRAM() {
			return RAM;
		}

		public void setRAM(String rAM) {
			RAM = rAM;
		}

		public String getCPU() {
			return CPU;
		}

		public void setCPU(String cPU) {
			CPU = cPU;
		}

		public boolean isGraphicsCardOn() {
			return graphicsCardOn;
		}

		public boolean isBluetoothOn() {
			return bluetoothOn;
		}

		public ComputerBuilder graphicsCardOn(boolean isGraphicsCardEnabled) {
			graphicsCardOn = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder bluetoothOn(boolean isBluetoothEnabled) {
			bluetoothOn = isBluetoothEnabled;
			return this;
		}

		public ComputerClass build() {
			return new ComputerClass(this);
		}

	}// ComputerBuilder
}



public class _4_Builder_Pattern {
	public static void main(String... args) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues
		ComputerClass comp = new ComputerClass.ComputerBuilder("500 GB", "2 GB", "2.4 GHz").bluetoothOn(true)
				.graphicsCardOn(false).build();

		System.out.println(comp);
	}

}
