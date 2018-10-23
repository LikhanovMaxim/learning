package learning.all.collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DiffCollections {
	public static void main(String[] args) {
		//		example1();
		System.out.println("Map:");
		differenceMaps();
		System.out.println("Set:");
		differenceSets();
	}

	private static void differenceSets() {
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

	private static void differenceMaps() {
		//don't sort element. It's random
		HashMap<String, String> hashMap = new HashMap<>();
		createMap(hashMap);

		// sort by compareTo
		TreeMap<String, String> treeMap = new TreeMap<>(Comparator.reverseOrder());// it is equal: (o1, o2) -> o2.compareTo(o1)
		createMap(treeMap);

		//store in the order the same as putting elements
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		createMap(linkedHashMap);

		System.out.println("HashMap:" + hashMap);
		System.out.println("TreeMap:" + treeMap);
		System.out.println("Linked :" + linkedHashMap);
	}

	private static void createMap(Map<String, String> hashMap) {
		hashMap.put("d", "lol");
		hashMap.put("b", "lol");
		hashMap.put("a", "lol");
		hashMap.put("z", "lol");
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
		set = new HashSet<String>();
		//		set.add((getShippingGroupManager()).getElectronicShippingType());
		set.add("change");
	}
}
