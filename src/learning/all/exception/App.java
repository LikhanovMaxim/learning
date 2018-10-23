package learning.all.exception;

import static java.lang.Integer.parseInt;

public class App {
	/** @see learning.sertification.chapter6Exception.App
	 *
	 */
	public static void main(String[] args) {
		try {
			int a = parseInt("s");
		} catch (NumberFormatException e) {
			System.out.println("Vah");
		} finally {
			System.out.println("I do it!");
		}
	}

}
