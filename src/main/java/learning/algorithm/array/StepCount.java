package learning.algorithm.array;

import lombok.val;
import lombok.var;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;


public class StepCount {
    public static void main(String[] args) {

        Person person = new Person("Max");

        List<Step> steps = List.of(new Step(person, 1000, LocalDate.now()),
                new Step(person, 2000, LocalDate.now().plusDays(1)),
                new Step(person, 3000, LocalDate.now().plusDays(2)));

        Map<Person, Pair<Integer, LocalDate>> sumSteps = new HashMap<>();
        for (int i = 0; i < steps.size(); i++) {
            Step step = steps.get(i);

            Pair<Integer, LocalDate> orDefault = sumSteps.getOrDefault(step.person, Pair.of(0, LocalDate.now()));
            if (DAYS.between(orDefault.getRight(), step.date) > 1) {
                sumSteps.put(step.person, Pair.of( 0, step.date ));
            }else {
                sumSteps.put(step.person, Pair.of(orDefault.getLeft() + step.stepCount, step.date));
            }

        }

        sumSteps.forEach((key, value) -> System.out.println(key.name + " " + value));
    }
}



class Step {
    Person person;
    int stepCount;
    LocalDate date;

    public Step(Person person, int stepCount, LocalDate date) {
        this.person = person;
        this.stepCount = stepCount;
        this.date = date;
    }

}
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}