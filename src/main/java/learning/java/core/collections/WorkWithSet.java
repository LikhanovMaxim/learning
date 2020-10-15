package learning.java.core.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkWithSet {
    public static void main(String[] args) {
//        System.out.println("example1:");
//        example1();
        System.out.println("Set:");
        differenceImplementationsSets();
        System.out.println("foreachSet");
        foreachSet();
    }

    private static void foreachSet() {
        HashSet<String> hashSet = new HashSet<>();
        createSet(hashSet);
        AtomicInteger count = new AtomicInteger();
        hashSet.forEach(e -> {
            if (e.contains("a"))
                count.getAndIncrement();
        });
        hashSet.forEach(System.out::println);
        System.out.println(count);

        System.out.println("Old way for each");
        Iterator<String> iterable = hashSet.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
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

        System.out.println("HashSet:" + hashSet); //don't sort always. it is sometimes happens by https://en.wikipedia.org/wiki/Bucket_sort
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

    /**
     * try to change a condition
     */
    private static void example1() {
        Set<String> availableShippingTypes = new HashSet<>();
        availableShippingTypes.add("asd");
        availableShippingTypes.add("area");
        System.out.println(availableShippingTypes);
        change(availableShippingTypes);
        System.out.println(availableShippingTypes);
    }

    private static void change(Set<String> set) {
        set = new HashSet<>();//!!! Don't do it
        set.add("change");
    }
}
