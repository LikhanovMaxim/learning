package learning.algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleT1Test {

    @Test
    public void first() {
        int receipt = 10;
        List<Integer> wallet = new ArrayList<>();
        wallet.add(50);
        wallet.add(10);
        wallet.add(5);
        wallet.add(2);
        wallet.add(7);
        wallet.add(3);
        wallet.add(1);
        assertEquals(3, ExampleT1.findIdealBanknotes(receipt, wallet));
    }

    @Test
    public void test2() {
        int receipt = 10;
        List<Integer> wallet = new ArrayList<>();
        wallet.add(10);
        assertEquals(-1, ExampleT1.findIdealBanknotes(receipt, wallet));
    }
}
