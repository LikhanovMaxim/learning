package learning.all.overload;

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
	}

	public void bla() {
		System.out.println("from App");
	}

	public void pat() {
		System.out.println("pat from App");
	}
}

class B extends App {
	@Override
	public void bla() {
		System.out.println("from B");
	}

	//TODO: This is overloading
	public void pat(int a) {
		System.out.println("pat from B");
	}

}