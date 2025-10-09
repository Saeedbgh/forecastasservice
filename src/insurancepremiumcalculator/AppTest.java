package insurancepremiumcalculator;

import util.SalaryEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AppTest {
    public static void main(String[] args) {
        List<SalaryEntry> entries = List.of(
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(350_000_000)),
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(450_000_000)),
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(650_000_000)),
                new SalaryEntry(UUID.randomUUID().toString(), BigDecimal.valueOf(1_100_000_000))
        );

        List<InsurancePremiumOut> outputs = InsurancePremiumService.calculatePremium(entries);

        outputs.forEach(System.out::println);    }
}
