package basedepositcalculator;

import java.math.BigDecimal;

public class InsuranceRange {
    private BigDecimal min;
    private BigDecimal max;
    private boolean minInclusive;
    private boolean maxInclusive;
    private BigDecimal rate;

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public boolean isMinInclusive() {
        return minInclusive;
    }

    public void setMinInclusive(boolean minInclusive) {
        this.minInclusive = minInclusive;
    }

    public boolean isMaxInclusive() {
        return maxInclusive;
    }

    public void setMaxInclusive(boolean maxInclusive) {
        this.maxInclusive = maxInclusive;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
