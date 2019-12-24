package learning.java.core.java8.lambdaExpersion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void function2() {
        Function<String, String> up = String::toUpperCase;
        assertEquals(up.apply("asd"), "ASD");
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