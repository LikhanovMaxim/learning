package learning.java.core.multithreading.basic.immutable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        smth();
//        smth2();
    }


    private static void smth2() {
        List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add("four");
    }


    public static void smth() {
        List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ImmutableList.copyOf(list);
        unmodifiableList.add("four");
    }
}
