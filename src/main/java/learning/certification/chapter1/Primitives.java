package learning.certification.chapter1;
import java.lang.reflect.Array;


public class Primitives {
//	double notByDecimal = 1000._00; //TODO DOES NOT COMPILE

	public static void main(String[] args) {
		int amount = 0b101;
		int amount2 = 0b11;
		System.out.println("101 binary = " + amount);
		System.out.println(amount2);
		Array t;
	}
}

class $KilMe {
	/*
	Class names begin with an uppercase letter followed by CamelCase. Don’t start any
	identifiers with $. The compiler uses this symbol for some files.
	 */
	public void findAnswer(boolean check) {
		int answer;
		int onlyOneBranch;
		if (check) {
			onlyOneBranch = 1;
			answer = 1;
		} else {
			answer = 2;
		}
		System.out.println(answer);
//		System.out.println(onlyOneBranch); // TODO DOES NOT COMPILE
	}
}
