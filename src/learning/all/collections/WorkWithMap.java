package learning.all.collections;

import java.util.*;

public class WorkWithMap {
    public static void main(String[] args) {
        System.out.println("Map:");
        differenceImplementationsMaps();

        System.out.println("Entry:");
        entry();
    }

    private static void entry() {
        Map<Integer, String> hash_map = new HashMap<>();

        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);

        // Using entrySet() to get the set view
        System.out.println("The set is: " + hash_map.entrySet());

        // Using entrySet() to get the set view
        System.out.println("The key set is: " + hash_map.keySet());

//       !!! Noncompliant Code Example
        for (Integer key : hash_map.keySet()) {  // Noncompliant; for each key the value is retrieved
            Object value = hash_map.get(key);
            // ...
        }
//        when both the key and the value are needed, it's more efficient to iterate the entrySet,
//        which will give access to both the key and value, instead.
//        Compliant Solution:
        for (Map.Entry<Integer, String> entry : hash_map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            // ...
        }
    }

    private static void differenceImplementationsMaps() {
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
}
