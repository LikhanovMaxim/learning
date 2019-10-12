package learning.java.core.optional;

import java.util.Optional;

public class App {

    public static void main(String[] args) {
        simpleExample();
        hardExampleWithClass();
    }

    private static void hardExampleWithClass() {
        /** Создание Optional объектов */
//Пустой Optional объект
        Optional<Person> optionalPerson = Optional.empty();

//Optional объект с ненулевым значением
//        Optional<Person> optionalNonNull = Optional.of(somePerson);
        Optional<Person> a = Optional.of(new Person());

//Optional объект с возможностью нулевого значения
//        Optional<Person> optionalNullable = Optional.ofNullable(somePerson);

        /**
         Person person = getDefaultPerson();
         if (person != null) {
         PersonAddress personAddress = person.getAddress();
         if (personAddress != null) {
         PersonAddressStreet street = personAddress.getStreet();
         if(street != null) {
         streetName = street.getStreetName();
         } else {
         streetName = "EMPTY";
         }
         }
         }
         */

        Optional<Person> person = Optional.of(new Person());

        person.ifPresent(System.out::println);

//        Person personNew = person != null ? person : new Person();
        Person personNew = person.orElse(new Person());

        try {
            Person personNewThrow = person.orElseThrow(Exception::new);
        } catch (Exception e) {
            System.out.println(e);
        }
        //TODO
//        String streetName = person.flatMap(Person::getAddress)
//                .flatMap(PersonAddress::getStreet)
//                .map(PersonAddressStreet::getString)
//                .orElse("EMPTY");
    }

    private static Person getDefaultPerson() {
        return new Person();
    }

    private static void simpleExample() {
        check(useEmpty());
        check(useOf());
        check(useOfNullable());
        check(useOfNullableWithNull());
    }

    private static void check(Optional<Double> countBR) {
        if (countBR.isPresent()) {
            System.out.println(countBR + " " + countBR.get() + " ");
        } else {
            System.out.println("It is not present");
        }
    }

    private static Optional<Double> useOf() {
        return Optional.of(20.0);
    }

    private static Optional<Double> useEmpty() {
        return Optional.empty();
    }

    private static Optional<Double> useOfNullable() {
        return Optional.ofNullable(23.0);
    }

    private static Optional<Double> useOfNullableWithNull() {
        return Optional.ofNullable(null);
    }
}
