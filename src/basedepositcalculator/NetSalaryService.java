package basedepositcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NetSalaryService {

    public static class Range {
        private final BigDecimal min; // exclusive
        private final BigDecimal max; // inclusive
        private final BigDecimal rate;

        public Range(BigDecimal min, BigDecimal max, BigDecimal rate) {
            this.min = min;
            this.max = max;
            this.rate = rate;
        }

        public boolean match(BigDecimal value) {
            boolean greaterThanMin = (min == null) || value.compareTo(min) > 0;
            boolean lessEqMax = (max == null) || value.compareTo(max) <= 0;
            return greaterThanMin && lessEqMax;
        }

        public BigDecimal getRate() {
            return rate;
        }
    }

    public static List<BigDecimal> calculateInsurance(
            List<? extends Number> grossSalaries,
            Supplier<List<Range>> rangeProvider) {

        List<Range> ranges = rangeProvider.get();
        List<BigDecimal> results = new ArrayList<>();

        for (Number salary : grossSalaries) {
            BigDecimal s = new BigDecimal(salary.toString());

            BigDecimal rate = ranges.stream()
                    .filter(r -> r.match(s))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No range matched: " + s))
                    .getRate();

            results.add(s.multiply(rate));
        }

        return results;
    }
}
