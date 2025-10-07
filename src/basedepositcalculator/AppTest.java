package basedepositcalculator;

import java.math.BigDecimal;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        List<NetSalaryService.Range> ranges = List.of(
                new NetSalaryService.Range(null, new BigDecimal("40"), new BigDecimal("0.02")),
                new NetSalaryService.Range(new BigDecimal("40"), new BigDecimal("50"), new BigDecimal("0.04")),
                new NetSalaryService.Range(new BigDecimal("50"), new BigDecimal("60"), new BigDecimal("0.06")),
                new NetSalaryService.Range(new BigDecimal("60"), new BigDecimal("70"), new BigDecimal("0.08")),
                new NetSalaryService.Range(new BigDecimal("70"), new BigDecimal("80"), new BigDecimal("0.10")),
                new NetSalaryService.Range(new BigDecimal("80"), new BigDecimal("90"), new BigDecimal("0.12")),
                new NetSalaryService.Range(new BigDecimal("90"), new BigDecimal("100"), new BigDecimal("0.14")),
                new NetSalaryService.Range(new BigDecimal("100"), null, new BigDecimal("0.15"))
        );

        List<Integer> grossSalaries = List.of(35, 45, 65, 110);

        List<BigDecimal> insuranceAmounts =
                NetSalaryService.calculateInsurance(grossSalaries, () -> ranges);

        insuranceAmounts.forEach(System.out::println);
    }
}
