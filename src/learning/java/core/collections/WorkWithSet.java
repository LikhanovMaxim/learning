package learning.java.core.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class WorkWithSet {
	public static void main(String[] args) {
//		System.out.println("example1:");
//		example1();
		System.out.println("Set:");
		differenceImplementationsSets();
	}

	private static void differenceImplementationsSets() {
		//don't sort element. It's random
		HashSet<String> hashSet = new HashSet<>();
		createSet(hashSet);

		// sort by compareTo
		TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());// it is equal: (o1, o2) -> o2.compareTo(o1)
		createSet(treeSet);

		//store in the order the same as putting elements
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		createSet(linkedHashSet);

		System.out.println("HashSet:" + hashSet);
		System.out.println("TreeSet:" + treeSet);
		System.out.println("Linked :" + linkedHashSet);
	}

	private static void createSet(Set<String> hashSet) {
		hashSet.add("d");
		hashSet.add("b");
		hashSet.add("b");
		hashSet.add("a");
		hashSet.add("z");
	}

	private static void example1() {
		Set<String> availableShippingTypes = new HashSet<String>();
		availableShippingTypes.add("asd");
		availableShippingTypes.add("area");
		System.out.println(availableShippingTypes);
		change(availableShippingTypes);
		System.out.println(availableShippingTypes);
	}

	private static void change(Set<String> set) {
		set = new HashSet<>();//!!! Don't do it
		//		set.add((getShippingGroupManager()).getElectronicShippingType());
		set.add("change");
	}
}
