package insurancepremiumcalculator;


import util.SalaryEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsurancePremiumService {

    private record Range(BigDecimal min, BigDecimal max, BigDecimal rate) {
        public boolean match(BigDecimal value) {
            boolean gtMin = (min == null) || value.compareTo(min) > 0;
            boolean leMax = (max == null) || value.compareTo(max) <= 0;
            return gtMin && leMax;
        }
    }

    private static final List<Range> ranges = List.of(
            new Range(null, new BigDecimal("400000000"), new BigDecimal("0.02")),
            new Range(new BigDecimal("400000000"), new BigDecimal("500000000"), new BigDecimal("0.04")),
            new Range(new BigDecimal("500000000"), new BigDecimal("600000000"), new BigDecimal("0.06")),
            new Range(new BigDecimal("600000000"), new BigDecimal("700000000"), new BigDecimal("0.08")),
            new Range(new BigDecimal("700000000"), new BigDecimal("800000000"), new BigDecimal("0.10")),
            new Range(new BigDecimal("800000000"), new BigDecimal("900000000"), new BigDecimal("0.12")),
            new Range(new BigDecimal("900000000"), new BigDecimal("1000000000"), new BigDecimal("0.14")),
            new Range(new BigDecimal("1000000000"), null, new BigDecimal("0.15"))
    );

    public static List<InsurancePremiumOut> calculatePremium(List<SalaryEntry> salaryEntries) {
        List<InsurancePremiumOut> results = new ArrayList<>();

        for (SalaryEntry entry : salaryEntries) {
            BigDecimal gross = entry.grossSalary();

            Range matchedRange = ranges.stream()
                    .filter(r -> r.match(gross))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No range matched: " + gross));

            BigDecimal insurancePremium = gross.multiply(matchedRange.rate());

            results.add(new InsurancePremiumOut(
                    entry.salaryId(),
                    insurancePremium,
                    matchedRange.rate()
            ));
        }

        return results;
    }
}
