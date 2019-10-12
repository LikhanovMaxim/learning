package learning.java.core.immutable;

/**
 * we must rely on the Currency API to protect itself from changes
 */
public class ImmutableMoney {
    private final double amount;
    private final Currency currency;

    public ImmutableMoney(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
