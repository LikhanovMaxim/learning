package learning.java.core.collections;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectionExamplesTest {


    public static final String FIRST = "first";
    public static final String SECOND = "second";

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
}