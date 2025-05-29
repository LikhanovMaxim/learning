package learning.algorithm.discount;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DiscountServiceTest {
    UserService userService = Mockito.mock(UserService.class);
    DiscountService discountService = new DiscountService(userService);

    //todo write test with копейки


    //todo wirte test with cart;
    @Test
    public void shouldBeTheSameWhenDiscountIsZero2() {
        int userId = 1;
        when(userService.discount(userId)).thenReturn(0);
        Purchase purchase = new Purchase(123, new BigDecimal(100));
        Cart cart = new Cart(List.of(purchase));
        Cart calculate = discountService.apply(userId, cart);
        //todo create expctedCart
        assertEquals(new BigDecimal(100.00).setScale(2), calculate.purchases.get(0).discountPrice);
    }

    @Test
    public void shouldBeTheSameWhenDiscountIsZero() {
        String s = "1234";
        int x = Integer.parseInt(String.valueOf(s.charAt(0)));
        System.out.println(x);
        Purchase purchase = new Purchase(123, new BigDecimal(100));
        discountService.applyDiscount(purchase, 0);
        assertEquals(new BigDecimal(100.00).setScale(2), purchase.discountPrice);
    }

    @Test
    public void shouldBeTheSameWhenDiscountIs10() {
        Purchase purchase = new Purchase(123, new BigDecimal(100));
        discountService.applyDiscount(purchase, 10);
        assertEquals(new BigDecimal(90.00).setScale(2), purchase.discountPrice);
    }

    /**
     *
     */
    @Test
    public void shouldBeTheSameWhenDiscountIs3() {
        Purchase purchase = new Purchase(123, new BigDecimal(17));
        discountService.applyDiscount(purchase, 3);
        assertEquals(new BigDecimal(16.49).setScale(2, RoundingMode.HALF_UP), purchase.discountPrice);
    }
}