package insurancepremiumcalculator;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        List<InsurancePremiumOut> outputs = InsurancePremiumService.calculateNetSalaries(
                List.of(350000000, 450000000, 650000000, 1100000000)
        );

        outputs.forEach(System.out::println);
    }
}
