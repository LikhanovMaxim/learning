package learning.codility;

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
        Integer res = ExampleT1.findIdealBanknotes(receipt, wallet);
        assertEquals(3, res);
    }
}
