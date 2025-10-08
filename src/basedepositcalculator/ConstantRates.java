package basedepositcalculator;

import java.math.BigDecimal;

public enum ConstantRates {
    BASE_DEPOSIT(BigDecimal.valueOf(0.6));

    private final BigDecimal value;

    ConstantRates(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
