package com.javaworld.A5_Design_Patterns.A1_Creational_Design_Patterns;
/**
 *
 */

/**
 * @author Shaik Khader
 * Factory design pattern is used when we have a super class with multiple sub-classes and based on
 * input, we need to return one of the sub-class. This pattern is also known as Factory Method Design
 * Pattern. Super class in factory design pattern can be an interface, abstract class or a Concreate
 * java class. Look the example below.
 *
 * Advantages:
 * .Factory design pattern encourages to code for interface rather than implementation.
 * .Factory pattern makes our code more robust, less coupled and easy to extend.
 * .Factory pattern provides abstraction between implementation and client classes through inheritance.
 *
 * Examples in JDK:
 * .java.util.Calendar, ResourceBundle and NumberFormat getInstance() methods uses Factory pattern.
 */

// Super class
abstract class Computer {

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return " RAM = " + getRAM() + ", HDD = " + getHDD() + ", CPU = " + getCPU();
    }
}

// Sub class 1
class PC extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

// Sub class 2
class Server extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}
// Similarly there can be more classes like Laptop, Notebook, Tablet etc.

// Factory class
class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {

        switch (type) {
            case "PC":
                return new PC(ram, hdd, cpu);
            case "Server":
                return new Server(ram, hdd, cpu);

        }

        return null;
    }
}

public class _2_Factory_Pattern {
    public static void main(String... args) {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config - " + pc);
        System.out.println("Factory Server Config - " + server);
    }
}
