package basedepositcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseDepositForPlanService {

    public static List<BaseDepositForPlanOut> calculateBaseDeposit(List<? extends Number> grossSalaries) {
        BigDecimal rate = ConstantRates.BASE_DEPOSIT.getValue();

        List<BaseDepositForPlanOut> results = new ArrayList<>();

        for (Number gross : grossSalaries) {
            BigDecimal grossSalary = new BigDecimal(gross.toString());
            BigDecimal baseDeposit = grossSalary.multiply(rate);

            results.add(new BaseDepositForPlanOut(baseDeposit));
        }

        return results;
    }

}
