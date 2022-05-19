package learning.patterns.creational.example1;

public class Client {


    /**
     * want to create a coffee(first, second, third). - fabric
     * want to build one coffee with parameters sugar(count of cub), milk(none, low, high). Builder
     * want to create coffee(first, second, third) with parameters sugar(count of cub), milk(none, low, high).
     * bridge?
     */
    public static void main(String[] args) {
        //todo implement and check:
        // By mandatory builder:
        // pass the type - mandatory.
        // pass params - sugar & milk
        // when use build() - use fabric


        CoffeeFabric coffeeFabric = new CoffeeFabric();
        //
        Coffee first = coffeeFabric.makeClassicFabric(TypeCoffee.FIRST);


//new
        String milk = "low";
        int sugar = 2;
//        Coffee coffee = coffeeFabric.make(TypeCoffee.FIRST, Coffee.builder().milk("low"));
//        System.out.println(coffee);
//        coffee.make();
//        Coffee second = coffeeFabric.make(TypeCoffee.SECOND, Coffee.builder().milk("low"));
//        second.make();


    }
}
