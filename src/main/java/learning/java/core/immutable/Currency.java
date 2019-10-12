package learning.java.core.immutable;

public class Currency {
    private final String value;

    public Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Currency of(String value) {
        return new Currency(value);
    }
}
