package learning.patterns.creational.example1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.checkerframework.checker.units.qual.C;
@Builder
class FirstCoffee extends Coffee {
    String milk;
    int sugar;
//    FirstCoffee(String milk, int sugar) {
//        super(milk, sugar);
//    }
}


class SecondCoffee extends Coffee {
//    SecondCoffee(String milk, int sugar) {
//        super(milk, sugar);
//    }

    @Override
    public void make() {
        System.out.println("make second");
    }
}
class ThirdCoffee extends Coffee {
//    ThirdCoffee(String milk, int sugar) {
//        super(milk, sugar);
//    }

    @Override
    public void make() {
        System.out.println("make ThirdCoffee");
    }
}
