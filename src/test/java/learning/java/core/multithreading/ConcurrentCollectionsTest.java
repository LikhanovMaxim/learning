package learning.java.core.multithreading;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentCollectionsTest {

    @Test
    void name() throws InterruptedException {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Runnable listOperations = () -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

        Thread thread1 = new Thread(listOperations);
        Thread thread2 = new Thread(listOperations);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertEquals(12, syncCollection.size());
    }

    @Test
    void name2() {
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

        List<String> syncCollection = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
        List<String> uppercasedCollection = new ArrayList<>();

        Runnable listOperations = () -> {
            synchronized (syncCollection) {
                syncCollection.forEach((e) -> {
                    uppercasedCollection.add(e.toUpperCase());
                });
            }
        };
    }
}