package learning.java.core.java8.lambdaExpersion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
A Java lambda expression is thus a function which can be created without belonging to any class.
A Java lambda expression can be passed around as if it was an object and executed on demand.
 */
class FunctionInterfacesTest {

    private static FunctionInterfaces functionInterfaces;

    @BeforeAll
    static void setUp() {
        functionInterfaces = new FunctionInterfaces();
    }

    @Test
    void predicate() {
        Predicate<String> predicate = functionInterfaces.isStringLengthMoreThanZero();

        assertTrue(predicate.test("SymbolsAreMoreThanZero"));
        assertFalse(predicate.negate().test("SymbolsAreMoreThanZero, but we use negate"));

        //Other examples
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        Predicate<Integer> isEven = (integer -> integer % 2 == 0);
    }

    @Test
    void function2() {
        Function<String, String> up = String::toUpperCase;
        assertEquals("ASD", up.apply("asd"));
    }

    @Test
    void function() {
        Function<String, String> add100AndReturnString = functionInterfaces.takeFunction();
        assertEquals("223", add100AndReturnString.apply("123"));
    }

    @Test
    void supplier() {
        Supplier<Person> personSupplier = functionInterfaces.takeSupplier();

        assertEquals(new Person(), personSupplier.get());
        //TODO why does it need?
    }

    @Test
    void consumer() {
        Consumer<Person> birthDay = p -> p.age += 1;
        Person max = new Person("Max", 34);
        birthDay.accept(max);
        assertEquals(35, max.age);
    }

    @Test
    void syntax() {
//        old way:
        Function<Integer, Integer> s2 = a -> Utility.calc(a);
//        method references:
        Function<Integer, Integer> s = Utility::calc;
        Integer res = s.apply(23);
        assertEquals(230, res);
    }

    @Test
    void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        assertEquals(21, result);

        String res = Stream.of("a", "b", "c", "d", "e")
                .reduce("start: ", (accumulator, newElement) -> accumulator + newElement);
        assertEquals("start: abcde", res);
    }

    //Получить сумму чисел или вернуть 0
    @Test
    void sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(6, sum);

        int sumOdd = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .filter(e -> e % 2 == 1)
                .sum();
        assertEquals(4, sumOdd);
    }

    //Вернуть максимум или -1
    @Test
    void max() {
        List<Integer> numbers = Arrays.asList(1, 3, 2);
        int max = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .max().orElse(-1);
        assertEquals(3, max);
    }


    //    @Test // ConcurrentModificationException
    void modifyStream1() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        list.stream().forEach(x -> {
            if (x.equals("C")) {
                list.remove(x);
            }
        });
    }

//    @Test //NPE
    void modifyStream2() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        list.stream().forEach(x -> {
            if (x.equals("A")) {
                list.remove(x);
            }
        });

//        ConcurrentModificationException
//        for (String e : list) {
//            if (e.equals("A")) {
//                list.remove(e);
//            }
//        }

        //use it:
        list.removeIf(x -> x.equals("A"));
        System.out.println(list);
    }

    /**TODO
     * Comparator
     * Optional
     * Collection.stream() или Collection.parallelStream().
     * - Filter
     * - Sorted
     * - Map
     * - Match
     * - Count
     * - Reduce
     */
}
