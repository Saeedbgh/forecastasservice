package forecastv01;

import java.math.BigDecimal;
import java.util.Map;

public class ForecastService {
    private int monthsNumber;
    private BigDecimal rate;
    private Map<BigDecimal, BigDecimal> forecast;

    public ForecastService(int monthsNumber, BigDecimal rate, Map<BigDecimal, BigDecimal> forecast) {
        this.monthsNumber = monthsNumber;
        this.rate = rate;
        this.forecast = forecast;
    }

    public int getMonthsNumber() {
        return monthsNumber;
    }

    public void setMonthsNumber(int monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Map<BigDecimal, BigDecimal> getForecast() {
        return forecast;
    }


    public void setForecast(Map<BigDecimal, BigDecimal> forecast) {
        this.forecast = forecast;
    }
}
