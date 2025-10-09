package basedepositcalculator;

import java.math.BigDecimal;

public record BaseDepositForPlanOut(String salaryId, BigDecimal baseDepositPlan) {

    @Override
    public String toString() {
        return "BaseDepositForPlanOut{" +
                ", baseDepositPlan=" + baseDepositPlan +
                '}';
    }
}
