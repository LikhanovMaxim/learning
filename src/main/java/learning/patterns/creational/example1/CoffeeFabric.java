package learning.patterns.creational.example1;

public class CoffeeFabric {

    public Coffee makeClassicFabric(TypeCoffee typeCoffee) {
        Coffee coffee = null;
        switch (typeCoffee) {
            case FIRST:
                coffee = FirstCoffee.builder().milk("").sugar(0).build();
                break;
            case SECOND:
//                coffee = new SecondCoffee();
                break;
            case THIRD:
//                coffee = new ThirdCoffee();
                break;
        }
        return coffee;
    }

    public void makeClassicFabric(TypeCoffee first, String milk, int sugar) {

    }

//    public Coffee make(TypeCoffee typeCoffee, Coffee.CoffeeBuilder builder) {
//        Coffee coffee = null;
//        switch (typeCoffee) {
//            case FIRST:
//                coffee = (FirstCoffee)builder.build();
//                break;
//            case SECOND:
//                coffee = (SecondCoffee) builder.build();
//                break;
//            case THIRD:
////                coffee = new ThirdCoffee();
//                break;
//        }
//        return coffee;
//    }
}
