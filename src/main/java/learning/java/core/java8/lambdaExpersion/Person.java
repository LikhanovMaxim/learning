package learning.java.core.java8.lambdaExpersion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Person {
    String name;
    Integer age;

    public Person() {
    }
}
