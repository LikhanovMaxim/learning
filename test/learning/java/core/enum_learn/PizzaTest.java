package learning.java.core.enum_learn;

import learning.java.core.enum_learn.advanced.Pizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

class PizzaTest {

    @Test
    void name() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        assertTrue(testPz.isDeliverable());
    }

    @Test
    void checkTimeToDeliver() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        assertSame(2, pz.printTimeToDeliver());
    }

    @Test
    void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assertSame(Pizza.PizzaStatus.DELIVERED, pz.getStatus());
    }

    @Test
    void checkGetAllUndeliveredPizzas() {
        List<Pizza> pizzaList = new ArrayList<>(Arrays.asList(
                new Pizza(Pizza.PizzaStatus.ORDERED),
                new Pizza(Pizza.PizzaStatus.READY),
                new Pizza(Pizza.PizzaStatus.DELIVERED)
        ));

        List<Pizza> undeliveredPizzas = Pizza.getAllUndeliveredPizzas(pizzaList);

        assertSame(2, undeliveredPizzas.size());
    }

    @Test
    void checkTo() {
        List<Pizza> pizzaList = new ArrayList<>(Arrays.asList(
                new Pizza(Pizza.PizzaStatus.ORDERED),
                new Pizza(Pizza.PizzaStatus.READY),
                new Pizza(Pizza.PizzaStatus.ORDERED),
                new Pizza(Pizza.PizzaStatus.READY),
                new Pizza(Pizza.PizzaStatus.DELIVERED),
                new Pizza(Pizza.PizzaStatus.DELIVERED),
                new Pizza(Pizza.PizzaStatus.DELIVERED),
                new Pizza(Pizza.PizzaStatus.ORDERED),
                new Pizza(Pizza.PizzaStatus.DELIVERED)
        ));

        EnumMap<Pizza.PizzaStatus, List<Pizza>> pizzaStatusListEnumMap = Pizza.groupPizzaByStatus(pizzaList);

        assertSame(3, pizzaStatusListEnumMap.get(Pizza.PizzaStatus.ORDERED).size());
        assertSame(2, pizzaStatusListEnumMap.get(Pizza.PizzaStatus.READY).size());
        assertSame(4, pizzaStatusListEnumMap.get(Pizza.PizzaStatus.DELIVERED).size());

    }
}