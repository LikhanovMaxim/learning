package learning.algorithm.discount;

import java.math.BigDecimal;

public class Purchase {
    int productId;
    BigDecimal price;
    BigDecimal discountPrice;

    public Purchase(int productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
    }
}
