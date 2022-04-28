package learning.java.core.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * https://www.youtube.com/watch?v=Ee5t_EGjv0A&t=1385s
 */
public class Video {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        oldWay(values);
        Predicate<Integer> isGreaterThan3 = Video::isGreaterThan3;
        final Stream<Integer> stream = values.stream()
                .filter(isGreaterThan3)
                .filter(Video::isEven)
                .map(Video::doubleIt);

        System.out.println("\nFind first (Lazy):");
        System.out.println(stream.findFirst());
    }

    private static void oldWay(List<Integer> values) {
        System.out.println("Old way:");
        Integer result = 0;
        for (Integer integer : values) {
            if (isGreaterThan3(integer) && isEven(integer)) {
                result = doubleIt(integer);
                break;
            }
        }
        System.out.println("Result " + result);
    }

    private static Integer doubleIt(Integer integer) {
        System.out.println("doubleIt " + integer);
        return integer * 2;
    }

    private static boolean isEven(Integer integer) {
        System.out.println("isEven " + integer);
        return integer % 2 == 0;
    }

    private static boolean isGreaterThan3(Integer integer) {
        System.out.println("isGreaterThan3 " + integer);
        return integer > 3;
    }
}
