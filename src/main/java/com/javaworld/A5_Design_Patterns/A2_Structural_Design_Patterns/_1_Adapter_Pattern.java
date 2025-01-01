package com.javaworld.A5_Design_Patterns.A2_Structural_Design_Patterns;
/**
 * 
 */

/**
 * @author Shaik Khader
 * 
 *         Adapter pattern works as a bridge between two incompatible(unrelated)
 *         objects. This pattern involves a single class which is responsible to
 *         join functionalities of independent or incompatible objects.
 * 
 *         One of the great real life example of Adapter design pattern is
 *         mobile charger. Mobile battery needs 3 volts to charge but the normal
 *         socket produces either 120V (US) or 240V (India). So the mobile
 *         charger works as an adapter between mobile charging socket and the
 *         wall socket.
 * 
 *         Two Way Adapter Pattern:
 * 
 *         While implementing Adapter pattern, there are two approaches � class
 *         adapter and object adapter � however both these approaches produce
 *         same result.
 * 
 *         1.Class Adapter � This form uses java inheritance and extends the
 *         source interface, in our case Socket class.
 * 
 *         2.Object Adapter � This form uses Java Composition and adapter
 *         contains the source object.
 * 
 *         Notice that both the adapter implementations are almost same and they
 *         implement the SocketAdapter interface. The adapter interface can also
 *         be an abstract class.
 * 
 *         Some of the adapter design pattern example I could easily find in JDK
 *         classes are;
 * 
 *         java.util.Arrays#asList() java.io.InputStreamReader(InputStream)
 *         (returns a Reader) java.io.OutputStreamWriter(OutputStream) (returns
 *         a Writer)
 * 
 * 
 * 
 */

class Volt {

	private int volts;

	public Volt(int v) {
		volts = v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}

}

class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}
}

interface SocketAdapter {

	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();

	default Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}

// Using inheritance for adapter pattern
class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = getVolt();
		return convertVolt(v, 40);
	}

}

// Using Composition for adapter pattern
class SocketObjectAdapterImpl implements SocketAdapter {

	private Socket sock = new Socket();

	@Override
	public Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 40);
	}

}

public class _1_Adapter_Pattern {
	public static void main(String... args) {
		testClassAdapter();
		testObjectAdapter();
	}

	private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter, 3);
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("\n v3 volts using Object Adapter=" + v3.getVolts());
		System.out.println(" v12 volts using Object Adapter=" + v12.getVolts());
		System.out.println(" v120 volts using Object Adapter=" + v120.getVolts());
	}

	private static void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(sockAdapter, 3);
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		System.out.println(" v3 volts using Class Adapter=" + v3.getVolts());
		System.out.println(" v12 volts using Class Adapter=" + v12.getVolts());
		System.out.println(" v120 volts using Class Adapter=" + v120.getVolts());
	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}

}
