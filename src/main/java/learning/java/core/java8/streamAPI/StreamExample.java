package learning.java.core.java8.streamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        test();
        newExamples();
//        createStreams();

//        exmaple1();

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        list.stream().forEachOrdered((p) -> p.append("_new")); // list - содержит [a1_new, a2_new, a3_new]

        List<StringBuilder> newList = list.stream().peek((p) -> p.append("_new")).collect(Collectors.toList());
        System.out.println(list.toArray()[0]);
        // и list и newList содержат [a1_new, a2_new, a3_new]
        ads();
//        intermediate();
    }

    public static void test() {
        boolean b = Stream.of("d2", "a2", "b1", "c")
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                            System.out.println(s);
                            return s.startsWith("A");
                        }
                );
        System.out.println(b);
    }


    private static void newExamples() {
        //1
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        //2
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1
        //3
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1
//        4
        IntStream.range(1, 4)
                .forEach(System.out::println);
//        5
        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);  // 5.0

    }

    private static void ads() {
        String[] strings = {"a1", "a2", "a3"};
        Stream<String> streamFromValues = Stream.of(strings);
        streamFromValues.forEach((e) -> e = "ads");
        System.out.println(strings[0]);
//        TODO because string?
    }

    private static void exmaple1() {
        //1-st example
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        ArrayList<String> strings = streamFromValues.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(strings);
    }

    private static void intermediate() {
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        Stream<String> newStream = streamFromValues.map(String::toUpperCase);
        System.out.println(newStream.toArray()[0]);
    }


    private static void createStreams() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();

        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);


        //4. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntStream streamFromString = "123".chars();

        Stream.builder().add("a1").add("a2").add("a3").build();
    }
}
