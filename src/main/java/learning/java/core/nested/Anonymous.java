package learning.java.core.nested;

public class Anonymous {

    Entity entity = () -> System.out.println("Hi");

    public static void main(String[] args) {

        Entity entity = new Entity() {
            @Override
            public void print() {
                System.out.println("Hi");
            }
        };
        entity.print();

        EntityFunctional entityFunctional = () -> System.out.println("hi from lambda");
        entityFunctional.print();

    }
}

interface Entity {
    void print();
}


@FunctionalInterface
interface EntityFunctional {
    void print();
}
