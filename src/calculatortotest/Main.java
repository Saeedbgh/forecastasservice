package calculatortotest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final BigDecimal A_FACTOR = new BigDecimal("0.6");
        final BigDecimal MONTHS_IN_YEAR = new BigDecimal("12");
        final BigDecimal YEARS_OF_COVERAGE = new BigDecimal("25");
        final BigDecimal INSURANCE_FACTOR = new BigDecimal("0.0018227109259");
        final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

        InsuranceRateResolver resolver = new InsuranceRateResolver();
        Random random = new Random();

        int totalCases = 100;

        for (int iCase = 1; iCase <= totalCases; iCase++) {

            // Generate a random salary between 0 and 10,000,000,000,000
            long randomSalaryLong = Math.abs(random.nextLong()) % 10_000_000L;
            BigDecimal grossSalary = new BigDecimal(randomSalaryLong);

            BigDecimal rate = resolver.resolveRate(grossSalary);
            BigDecimal a = grossSalary.multiply(A_FACTOR);
            BigDecimal c = a.multiply(rate);
            BigDecimal b = c.multiply(MONTHS_IN_YEAR).multiply(YEARS_OF_COVERAGE);
            BigDecimal e = b.multiply(INSURANCE_FACTOR);
            BigDecimal finalResult = a.add(c).subtract(e).setScale(0, ROUNDING_MODE);

            System.out.println("Case #" + iCase);
            System.out.println("Gross Salary (Rials): " + grossSalary.setScale(0, ROUNDING_MODE));
            System.out.println("Resolved Rate (i): " + rate);
            System.out.println("A (60% of Salary): " + a.setScale(0, ROUNDING_MODE));
            System.out.println("C (Insurance Premium): " + c.setScale(0, ROUNDING_MODE));
            System.out.println("E (Insurance Cost): " + e.setScale(0, ROUNDING_MODE));
            System.out.println("Final Non-Withdrawable Fund (A + C - E): " + finalResult);
            System.out.println("---------------------------------------------");
        }

        System.out.println("✅ Total random samples tested: " + totalCases);
    }
}
