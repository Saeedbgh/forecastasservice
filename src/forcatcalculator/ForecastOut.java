package forcatcalculator;

import java.math.BigDecimal;

public class ForecastOut {
    private int monthNumber;
    private BigDecimal monthlyDeposit;
    private BigDecimal cumulativeDeposit;
    private BigDecimal monthlyProfit;

    public ForecastOut(int monthNumber,
                       BigDecimal monthlyDeposit,
                       BigDecimal cumulativeDeposit,
                       BigDecimal monthlyProfit) {
        this.monthNumber = monthNumber;
        this.monthlyDeposit = monthlyDeposit;
        this.cumulativeDeposit = cumulativeDeposit;
        this.monthlyProfit = monthlyProfit;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public BigDecimal getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public BigDecimal getCumulativeDeposit() {
        return cumulativeDeposit;
    }

    public BigDecimal getMonthlyProfit() {
        return monthlyProfit;
    }

    @Override
    public String toString() {
        return String.format(
                "Month %d: Deposit=%s, Cumulative=%s, Profit=%s",
                monthNumber,
                monthlyDeposit,
                cumulativeDeposit,
                monthlyProfit
        );
    }
}
