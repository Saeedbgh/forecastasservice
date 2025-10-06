package forcatcalculator;

import java.math.BigDecimal;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        List<ForecastOut> result = ForecastService.calculateForecastInDuration(
                new BigDecimal("1000"),
                new BigDecimal("30"),
                12
        );

        result.forEach(System.out::println);

        BigDecimal totalDeposit = result.get(result.size() - 1).getCumulativeDeposit();
        BigDecimal totalProfit = result.stream()
                .map(ForecastOut::getMonthlyProfit)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal Deposit: " + totalDeposit);
        System.out.println("Total Profit: " + totalProfit.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
