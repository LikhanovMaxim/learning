package learning.algorithm.discount;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

//todo interface Discount. Promocode.
@AllArgsConstructor
public class DiscountService {
    private UserService userService;

    //todo change cur cart or create a new?
    /**
     *
     * @param userId
     * @param cart
     * @return
     */
    public Cart apply(int userId, Cart cart) {
        //todo validation cart. Empty or null cart & cart.PurchaseList. throw Exception if it needs
        //todo check that user exist
//        todo add logging for debug/trace
        int discount = userService.discount(userId);
        //start userId, discount.
        for (Purchase purchase : cart.getPurchases()) {
            //discount.apply()
            applyDiscount(purchase, discount);
        }
        return cart;
    }

    /**
     * formula:
     *
     * @param purchase
     * @param discount
     */
    protected void applyDiscount(Purchase purchase, int discount) {
        //todo look best practice works with BigDecimal
        purchase.discountPrice = purchase.price.multiply(new BigDecimal((100.0 - discount) / 100.0))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
