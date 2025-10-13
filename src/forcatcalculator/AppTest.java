package forcatcalculator;

import java.math.BigDecimal;
import java.util.List;

import static forcatcalculator.ForecastService.calculateForecastInDuration;

public class AppTest {
    public static void main(String[] args) {
        List<ForecastOut> result = calculateForecastInDuration(
                BigDecimal.valueOf(30271912),
                BigDecimal.valueOf(14),
                12
        );

        System.out.printf("%-4s %-15s %-18s %-15s%n",
                "Month", "  MonthlyDeposit", "  CumulativeAfterDeposit", " MonthlyProfit");
        for (ForecastOut out : result) {
            System.out.printf(" %-4d   %-15s  %-18s      %-15s%n",
                    out.getMonthNumber(),
                    out.getMonthlyDeposit(),
                    out.getCumulativeDeposit(),
                    out.getMonthlyProfit());
        }
    }
}
