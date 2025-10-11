package calculatortotest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolves the insurance rate 'i' based on a given gross salary.
 * This class uses a predefined list of salary tiers to find the correct rate.
 */
public class InsuranceRateResolver {

    /**
     * Inner class to represent a single salary tier.
     * Each tier has an upper boundary and an associated rate.
     */
    private static class SalaryTier {
        final BigDecimal upperBoundary;
        final BigDecimal rate;

        public SalaryTier(BigDecimal upperBoundary, BigDecimal rate) {
            this.upperBoundary = upperBoundary;
            this.rate = rate;
        }
    }

    private final List<SalaryTier> rateTiers;
    private final BigDecimal highestBoundary; // The upper boundary of the highest defined tier (100)
    private final BigDecimal rateForExceedingMax; // The rate for salaries > highestBoundary

    /**
     * Constructor for InsuranceRateResolver.
     * It initializes the list of salary tiers in ascending order.
     */
    public InsuranceRateResolver() {
        rateTiers = new ArrayList<>();


        rateTiers.add(new SalaryTier(BigDecimal.valueOf(400000000), BigDecimal.valueOf(0.02)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(500000000), BigDecimal.valueOf(0.04)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(600000000), BigDecimal.valueOf(0.06)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(700000000), BigDecimal.valueOf(0.08)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(800000000), BigDecimal.valueOf(0.10)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(900000000), BigDecimal.valueOf(0.12)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(1000000000), BigDecimal.valueOf(0.14)));

        // Store the boundary of the last tier added.
        this.highestBoundary = rateTiers.get(rateTiers.size() - 1).upperBoundary;

        // Define the rate for salaries that exceed the highest tier's boundary.
        this.rateForExceedingMax = new BigDecimal("0.15"); // For salaries > 100
    }

    /**
     * Finds and returns the correct insurance rate for a given gross salary.
     *
     * @param grossSalary The gross salary.
     * @return The corresponding insurance rate as a BigDecimal.
     */
    public BigDecimal resolveRate(BigDecimal grossSalary) {
        // First, check if the salary exceeds the highest defined boundary.
        if (grossSalary.compareTo(this.highestBoundary) > 0) {
            return this.rateForExceedingMax;
        }

        // Iterate through the tiers to find the first one that the salary fits into.
        for (SalaryTier tier : rateTiers) {
            // Is salary less than or equal to this tier's upper boundary?
            if (grossSalary.compareTo(tier.upperBoundary) <= 0) {
                return tier.rate; // If yes, return this tier's rate and exit.
            }
        }

        // Fallback case (should not be reached in normal operation).
        // This could happen only if the salary is negative, for example.
        // Returning the lowest rate might be a safe default.
        return new BigDecimal("0.02");
    }
}
