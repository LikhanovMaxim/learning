package learning.java.core.java8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FunctionInterfacesTest {

    private static FunctionInterfaces functionInterfaces;

    @BeforeAll
    static void setUp() {
        functionInterfaces = new FunctionInterfaces();
    }

    @Test
    void predicate() {
        Predicate<String> predicate = functionInterfaces.takePredicate();

        assertTrue(predicate.test("SymbolsAreMoreThanZero"));
        assertFalse(predicate.negate().test("SymbolsAreMoreThanZero, but we use negate"));

        //Other examples
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
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
        //TODO why do it need?
    }

    @Test
    void consumer() {
        Consumer<Person> birthDay = (p) -> p.age += 1;
        Person max = new Person("Max", 34);
        birthDay.accept(max);
        assertEquals(35, max.age);
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