package learning.certification.chapter3;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
//		test();
//		converting();
//		convertingInt();

		//DATE:
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
		performAnimalEnrichment(start, end);

		period();
	}

	private static void converting() {
		List<String> list = new ArrayList<>();
		list.add("asd");
		list.add("robin");
		Object[] objectArray = list.toArray();
		System.out.println(objectArray.length);
		String[] stringArray = list.toArray(new String[0]);
		System.out.println(stringArray.length); // 2
//		String[] strings = list.toArray();
	}

	private static void convertingInt() {
		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(23);
		Object[] objectArray = list.toArray();
		System.out.println(objectArray.length);
		Integer[] intArray = list.toArray(new Integer[0]);
//		int[] intArray2 = list.toArray(new int[0]);
		System.out.println(intArray.length); // 2

	}
	private static void test() {
		String [] bugs = { "cricket", "beetle", "ladybug" };
		String [] alias = bugs;
		System.out.println(bugs.equals(alias)); // true
		System.out.println(bugs.toString());
	}


	private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) { // check if still before end
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plusMonths(1); // add a month
		}}
	private static void period(){
		System.out.println("period");
		Period wrong = Period.ofYears(1);
		wrong = Period.ofWeeks(7);
		System.out.println(wrong.getDays());
	}
}
