package learning.java.core.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Person {
    String name;
    Integer age;

    public Person() {
    }
}
