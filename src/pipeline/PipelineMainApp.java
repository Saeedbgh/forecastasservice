package pipeline;

import java.math.BigDecimal;
import java.util.List;

public class PipelineMainApp {
    public static void main(String[] args) {
        List<BigDecimal> grossSalaries = List.of(
                BigDecimal.valueOf(350_000_000),  // below 400M → rate 2%
                BigDecimal.valueOf(400_000_000),  // boundary 400M → rate 4% (inclusive)
                BigDecimal.valueOf(450_000_000),  // between 400M and 500M
                BigDecimal.valueOf(500_000_000),  // boundary 500M
                BigDecimal.valueOf(550_000_000),  // between 500M and 600M
                BigDecimal.valueOf(600_000_000),  // boundary 600M
                BigDecimal.valueOf(650_000_000),  // between 600M and 700M
                BigDecimal.valueOf(700_000_000),  // boundary 700M
                BigDecimal.valueOf(750_000_000),  // between 700M and 800M
                BigDecimal.valueOf(800_000_000),  // boundary 800M
                BigDecimal.valueOf(850_000_000),  // between 800M and 900M
                BigDecimal.valueOf(900_000_000),  // boundary 900M
                BigDecimal.valueOf(950_000_000),  // between 900M and 1B
                BigDecimal.valueOf(1_000_000_000),// boundary 1B
                BigDecimal.valueOf(1_050_000_000),// above 1B → rate 15%
                BigDecimal.valueOf(2_000_000_000),// high value for large-scale test
                BigDecimal.valueOf(5_000_000_000L) // maximum test for extreme scenarios
        );

        CalculationPipeline.runPipeline(grossSalaries);
    }
}
