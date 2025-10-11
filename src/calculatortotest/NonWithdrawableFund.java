package calculatortotest;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class NonWithdrawableFund {

    private static final BigDecimal A_FACTOR = new BigDecimal(0.6);
    private static final BigDecimal MONTHS_IN_YEAR = new BigDecimal(12);
    private static final BigDecimal YEARS_OF_COVERAGE = new BigDecimal(25);
    private static final BigDecimal INSURANCE_FACTOR = new BigDecimal(0.0018227109259);
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private final InsuranceRateResolver rateResolver;

    public NonWithdrawableFund() {
        this.rateResolver = new InsuranceRateResolver();
    }

    public BigDecimal calculateNonWithdrawableFund(BigDecimal grossSalary) {
        BigDecimal i = rateResolver.resolveRate(grossSalary);
        BigDecimal a = grossSalary.multiply(A_FACTOR);
        BigDecimal c = a.multiply(i);
        BigDecimal b = c.multiply(MONTHS_IN_YEAR).multiply(YEARS_OF_COVERAGE);
        BigDecimal e = b.multiply(INSURANCE_FACTOR);

        BigDecimal finalResult = a.add(c).subtract(e);

        return finalResult.setScale(0, RoundingMode.HALF_UP);
    }
}
