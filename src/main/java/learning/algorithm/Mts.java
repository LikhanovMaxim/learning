package learning.algorithm;

import java.util.Comparator;
import java.util.List;

public class Mts {
    private static int i = 0;

    public static void main(String[] args) {
        List<String> list = List.of("b", "a", "c");
        list.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static void incrementMy() {
        i++;
    }
}
