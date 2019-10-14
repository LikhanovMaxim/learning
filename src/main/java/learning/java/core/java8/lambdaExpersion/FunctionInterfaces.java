package learning.java.core.java8.lambdaExpersion;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaces {

    Predicate<String> isStringLengthMoreThanZero() {
        return s -> s.length() > 0;
    }


    Function<String, String> takeFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        return toInteger.andThen(num -> {
            num = num + 100;
            return String.valueOf(num);
        });
    }

    public Supplier<Person> takeSupplier() {
        Supplier<Person> personSupplier = Person::new;
        return personSupplier;
    }
}
