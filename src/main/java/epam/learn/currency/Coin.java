package epam.learn.currency;

import java.math.BigDecimal;

public enum Coin implements Comparable<Coin> {

    ONE(new BigDecimal("0.01")),
    FIVE(new BigDecimal("0.05")),
    TEN(new BigDecimal("0.10")),
    QUARTER(new BigDecimal("0.25")),
    FIFTY(new BigDecimal("0.50"));

    private BigDecimal value;

    Coin(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

}
