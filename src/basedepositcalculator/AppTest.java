package basedepositcalculator;

import util.SalaryEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AppTest {
    public static void main(String[] args) {
        List<SalaryEntry> entries = List.of(
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(4_000_000)),
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(5_000_000)),
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(10_000_000))
        );

        List<BaseDepositForPlanOut> outputs = BaseDepositForPlanService.calculateBaseDeposit(entries);

        outputs.forEach(System.out::println);
    }
}
