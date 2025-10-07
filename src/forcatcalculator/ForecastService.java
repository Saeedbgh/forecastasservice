package forcatcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ForecastService {

    public static List<ForecastOut> calculateForecastInDuration(
            BigDecimal baseDepositAmount,
            BigDecimal annualRate,
            int monthDuration
    ) {

        List<ForecastOut> forecast = new ArrayList<>();
        BigDecimal cumulativeDeposit = BigDecimal.ZERO;

        BigDecimal monthlyRate = annualRate
                .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

        for (int month = 1; month <= monthDuration; month++) {

            BigDecimal currentDeposit = baseDepositAmount.multiply(BigDecimal.valueOf(month));

            BigDecimal monthlyProfit = (month > 1)
                    ? cumulativeDeposit.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP)
                    : BigDecimal.ZERO;

            cumulativeDeposit = cumulativeDeposit.add(currentDeposit);

            forecast.add(new ForecastOut(
                    month,
                    currentDeposit.setScale(2, RoundingMode.HALF_UP),
                    cumulativeDeposit.setScale(2, RoundingMode.HALF_UP),
                    monthlyProfit
            ));
        }

        return forecast;
    }
}