package forcatcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ForecastService {

    public static List<ForecastOut> calculateForecastInDuration(
            BigDecimal depositAmount,
            BigDecimal annualRate,
            int monthDuration
    ) {
        List<ForecastOut> forecast = new ArrayList<>();

        BigDecimal cumulativeDeposit = BigDecimal.ZERO;
        BigDecimal currentMonthlyDeposit = depositAmount;

        BigDecimal monthlyRateDecimal = annualRate
                .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(monthDuration), 10, RoundingMode.HALF_UP);

        BigDecimal sumOfPreviousCumulativeDeposits = BigDecimal.ZERO;

        for (int month = 1; month <= monthDuration; month++) {
            BigDecimal monthlyProfit = month > 1
                    ? sumOfPreviousCumulativeDeposits.multiply(monthlyRateDecimal)
                    .setScale(2, RoundingMode.HALF_UP)
                    : BigDecimal.ZERO;

            cumulativeDeposit = cumulativeDeposit.add(currentMonthlyDeposit);

            forecast.add(new ForecastOut(
                    month,
                    currentMonthlyDeposit.setScale(2, RoundingMode.HALF_UP),
                    cumulativeDeposit.setScale(2, RoundingMode.HALF_UP),
                    monthlyProfit
            ));

            sumOfPreviousCumulativeDeposits = sumOfPreviousCumulativeDeposits.add(cumulativeDeposit);

            currentMonthlyDeposit = currentMonthlyDeposit.multiply(BigDecimal.valueOf(2));
        }

        return forecast;
    }
}
