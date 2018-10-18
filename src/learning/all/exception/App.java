package learning.all.exception;

import static java.lang.Integer.parseInt;

public class App {
	public static void main(String[] args) {
		try {
			int a = parseInt("s");
		}
		catch (NumberFormatException e){
			System.out.println("Vah");
		}
	}
}
