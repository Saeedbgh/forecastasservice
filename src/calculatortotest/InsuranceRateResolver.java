package calculatortotest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Insurance rate resolver.
 * Table is based on million Toman values — converted as:
 *   40 million Toman = 400 million Rial.
 */
public class InsuranceRateResolver {

    private static class SalaryTier {
        final BigDecimal upperBoundary;
        final BigDecimal rate;

        SalaryTier(BigDecimal upperBoundary, BigDecimal rate) {
            this.upperBoundary = upperBoundary;
            this.rate = rate;
        }
    }

    private final List<SalaryTier> rateTiers;
    private final BigDecimal highestBoundary;
    private final BigDecimal rateForExceedingMax;

    public InsuranceRateResolver() {
        rateTiers = new ArrayList<>();
        // Each million Toman = 10^6 Rials (×1,000,000)
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(400_000_000L), BigDecimal.valueOf(0.02)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(500_000_000L), BigDecimal.valueOf(0.04)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(600_000_000L), BigDecimal.valueOf(0.06)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(700_000_000L), BigDecimal.valueOf(0.08)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(800_000_000L), BigDecimal.valueOf(0.10)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(900_000_000L), BigDecimal.valueOf(0.12)));
        rateTiers.add(new SalaryTier(BigDecimal.valueOf(1_000_000_000L), BigDecimal.valueOf(0.14)));
        this.highestBoundary = rateTiers.get(rateTiers.size() - 1).upperBoundary;
        this.rateForExceedingMax = new BigDecimal("0.15");
    }

    public BigDecimal resolveRate(BigDecimal grossSalary) {
        if (grossSalary.compareTo(this.highestBoundary) > 0) {
            return rateForExceedingMax;
        }
        for (SalaryTier tier : rateTiers) {
            if (grossSalary.compareTo(tier.upperBoundary) <= 0) {
                return tier.rate;
            }
        }
        return new BigDecimal("0.02");
    }
}
