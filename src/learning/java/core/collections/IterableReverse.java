package learning.java.core.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IterableReverse<T> implements Iterable<T> {

    private List<T> list;

    public IterableReverse(T[] t) {
        list = Arrays.asList(t);
        Collections.reverse(list);
    }


    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
