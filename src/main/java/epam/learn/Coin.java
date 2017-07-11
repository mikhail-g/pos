package epam.learn;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public enum Coin implements Currency{

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
