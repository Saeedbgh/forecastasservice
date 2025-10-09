package basedepositcalculator;

import util.SalaryEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseDepositForPlanService {

    public static List<BaseDepositForPlanOut> calculateBaseDeposit(List<SalaryEntry> salaryEntries) {
        BigDecimal rate = ConstantRates.BASE_DEPOSIT.getValue();
        List<BaseDepositForPlanOut> results = new ArrayList<>();

        for (SalaryEntry entry : salaryEntries) {
            BigDecimal baseDeposit = entry.grossSalary().multiply(rate);
            results.add(new BaseDepositForPlanOut(entry.salaryId(), baseDeposit));
        }

        return results;
    }

}
