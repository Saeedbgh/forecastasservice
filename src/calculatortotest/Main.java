package calculatortotest;

import java.math.BigDecimal;

/**
 * Debug runner for NonWithdrawableFund.
 * Prints every intermediate variable (rate, a, c, b, e, finalResult).
 * All inputs and outputs are in Rials.
 */
public class Main {
    public static void main(String[] args) {
        // Example input salary (Rial)
        BigDecimal grossSalary = new BigDecimal(600000001L); // 62M Rial = 6.2M Toman

        NonWithdrawableFund fund = new NonWithdrawableFund();
        InsuranceRateResolver resolver = new InsuranceRateResolver();

        // Step 1: Resolve insurance rate
        BigDecimal i = resolver.resolveRate(grossSalary);
        System.out.println("Resolved Insurance Rate (i): " + i);

        // Step 2: Calculate detailed parts manually
        BigDecimal A_FACTOR = new BigDecimal(0.6);
        BigDecimal MONTHS_IN_YEAR = new BigDecimal(12);
        BigDecimal YEARS_OF_COVERAGE = new BigDecimal(25);
        BigDecimal INSURANCE_FACTOR = new BigDecimal(0.0018227109259);

        BigDecimal a = grossSalary.multiply(A_FACTOR);
        System.out.println("A = grossSalary × 0.6 = " + a.toPlainString());

        BigDecimal c = a.multiply(i);
        System.out.println("C = A × i = " + c.toPlainString());

        BigDecimal b = c.multiply(MONTHS_IN_YEAR).multiply(YEARS_OF_COVERAGE);
        System.out.println("B = C × 12 × 25 = " + b.toPlainString());

        BigDecimal e = b.multiply(INSURANCE_FACTOR);
        System.out.println("E = B × INSURANCE_FACTOR = " + e.toPlainString());

        BigDecimal finalResult = a.add(c).subtract(e);
        System.out.println("Final Result (A + C - E) = " + finalResult.toPlainString());

        // Step 3: Rounded final fund (same method output)
        BigDecimal roundedFund = fund.calculateNonWithdrawableFund(grossSalary);
        System.out.println("Rounded Non‑Withdrawable Fund = " + roundedFund);
    }
}
