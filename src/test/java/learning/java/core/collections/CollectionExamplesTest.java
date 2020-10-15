package learning.java.core.collections;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectionExamplesTest {


    public static final String FIRST = "first";
    public static final String SECOND = "second";

    private boolean isaBoolean(Set<String> ordersWithException, String o) {
        return !ordersWithException.contains(o);
    }

    @Test
    void liasd(){
        Set<String> ordersWithException = new HashSet<>();

//		ordersWithException.add("123");
//		ordersWithException.add("124");


        assertTrue(isaBoolean(ordersWithException, "1"));
    }

    @Test
    void liasd2(){
        Set<String> ordersWithException = new HashSet<>();

		ordersWithException.add("123");
		ordersWithException.add("124");

        assertTrue(isaBoolean(ordersWithException, "1"));
    }

    @Test
    void liasd4(){
        Set<String> ordersWithException = new HashSet<>();

        ordersWithException.add("123");
        ordersWithException.add("124");

        assertFalse(isaBoolean(ordersWithException, "124"));
    }


    /**
     * don't have get methods - only foreach or contains
     */
    @Test
    void collectionsExample() {
        Collection<String> collection = createCollection();

        System.out.println("Elements:");
        collection.forEach(System.out::println);

        assertEquals(2, collection.size());
        assertFalse(collection.isEmpty());

        System.out.println("Contains:");
        assertTrue(collection.contains(FIRST));
        assertFalse(collection.contains("smth"));

        collection.remove(FIRST);
        assertEquals(1, collection.size());

    }

    private Collection<String> createCollection() {
        Collection<String> collection = new ArrayList<>();

        collection.add(FIRST);
        collection.add(SECOND);
        return collection;
    }

    @Test
    void iteratorExamples() {
        //TODO:
        Collection<String> collection = createCollection();
        Iterator<String> iterator = collection.iterator();
        System.out.println("List elements : ");
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + " ");
            if (next.contains(FIRST)) {
                iterator.remove();
            }
        }

        System.out.println("\nAfter:");
        collection.forEach(System.out::println);
        assertEquals(1, collection.size());
    }

    /**
     * todo forEachRemaining
     */
    @Test
    void iteratorForEachRemaining() {
        Collection<String> collection = createCollection();
        Iterator<String> iterator = collection.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    @Disabled
    @Test
    void iterableFirst() {
        Integer[] ints = {1, 2, 3};
//        Iterable<Integer> myList = new
    }

    @Test
    void iterable() {
        Integer[] ints = {1, 2, 3};
        IterableReverse<Integer> myList = new IterableReverse<>(ints);
        for (Integer i : myList) {
            System.out.println(i);
        }

    }

    @Test
    void listIterator() {
        try {

            // Creating object of ArrayList<Integer>
            ArrayList<String> arrlist = new ArrayList<>();
            // adding element to arrlist
            arrlist.add("A");
            arrlist.add("B");
            arrlist.add("C");
            arrlist.add("D");

            // print arrlist
            System.out.println("ArrayList: "
                    + arrlist);

            // Creating object of ListIterator<String>
            // using listIterator() method
            ListIterator<String> iterator = arrlist.listIterator();

            // Printing the iterated value
            System.out.println("\nUsing ListIterator:\n");
            while (iterator.hasNext()) {
                System.out.println("Value is : "
                        + iterator.next());
            }
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}