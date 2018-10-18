package learning.sertification.chapter6Exception;

public class App {

	public static void main(String[] args) {
//		first();
		third();
//		second();
	}

	private static void third() {
		fourth();
	}

	private static void fourth() {
		throw new NullPointerException();
	}

	private static void second() {
		if(true){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("I am alive!");
		}
		System.out.println("I am alive 2!");
	}

	private static void first() {
		try {
//			see();
			fall();
			System.out.println("after fall");
		} catch (Exception e){
			System.out.println("learning/exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("after try");
	}

	private static void fall() throws Exception {
		throw new Exception();
	}
}
