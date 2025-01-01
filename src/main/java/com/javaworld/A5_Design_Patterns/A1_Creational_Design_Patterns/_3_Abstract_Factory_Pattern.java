package com.javaworld.A5_Design_Patterns.A1_Creational_Design_Patterns;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         Abstract Factory pattern is almost similar to Factory Pattern except
 *         the fact that its more like factory of factories.
 * 
 *         In Abstract Factory pattern, we get rid of if-else block and have a
 *         factory class for each sub-class. Then an Abstract Factory class that
 *         will return the sub-class based on the input factory class. At first
 *         it seems confusing but once you see the implementation, its really
 *         easy to grasp and understand the minor difference between Factory and
 *         Abstract Factory pattern. Look the example below.
 * 
 *         Benefits:
 * 
 *         Abstract Factory design pattern provides approach to "code for
 *         interface" rather than implementation. Abstract Factory pattern is
 *         "factory of factories" and can be easily extended to accommodate more
 *         products, for example we can add another sub-class Laptop and a
 *         factory LaptopFactory. Abstract Factory pattern is robust and avoid
 *         conditional logic of Factory pattern.
 * 
 *         Examples in JDK:
 * 
 *         javax.xml.parsers.DocumentBuilderFactory#newInstance()
 *         javax.xml.transform.TransformerFactory#newInstance()
 *         javax.xml.xpath.XPathFactory#newInstance()
 * 
 */

interface ComputerAbstractFactory {

	public Computer createComputer();

}

class ComputersFactory {

	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}

class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		return new PC(ram, hdd, cpu);
	}

}

class ServerFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public ServerFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		return new Server(ram, hdd, cpu);
	}

}

public class _3_Abstract_Factory_Pattern {
	public static void main(String... args) {
		Computer pc = ComputersFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputersFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config - " + pc);
		System.out.println("AbstractFactory Server Config - " + server);
	}

}
