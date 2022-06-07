package learning.java.core.overload_override;

/**
 * @author Maksim_Likhanov
 */
public class App {
	public static void main(String[] args) {
		//		System.out.println();
		B b = new B();
		b.bla();
		b.pat(1);
		b.pat();

		System.out.println("static:");
		App.doIt();
		B.doIt();
	}

	public void bla() {
		System.out.println("from Firest");
	}

	public void pat() {
		System.out.println("pat from Firest");
	}
	static void doIt() {
		System.out.println("I have done it!");
	}

}

class B extends App {
	@Override
	public void bla() {
		System.out.println("from B");
	}

	//This is overloading
	public void pat(int a) {
		System.out.println("pat from B because we have overloaded it");
	}

	static void doIt() {
		System.out.println("Another I have done it!");
	}
	void doIt(int a) {
		System.out.println("Another I have done it!");
	}

}
