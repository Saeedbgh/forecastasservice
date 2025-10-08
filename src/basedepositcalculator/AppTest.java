package basedepositcalculator;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        List<BaseDepositForPlanOut> outputs = BaseDepositForPlanService.calculateBaseDeposit(
                List.of(4_000_000, 5_000_000, 10_000_000)
        );

        outputs.forEach(System.out::println);
    }
}
