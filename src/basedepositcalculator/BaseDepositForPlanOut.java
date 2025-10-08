package basedepositcalculator;

import java.math.BigDecimal;

public class BaseDepositForPlanOut {
    BigDecimal baseDepositPlan;

    public BaseDepositForPlanOut(BigDecimal baseDepositPlan) {
        this.baseDepositPlan = baseDepositPlan;
    }

    public BigDecimal getBaseDepositPlan() {
        return baseDepositPlan;
    }

    public void setBaseDepositPlan(BigDecimal baseDepositPlan) {
        this.baseDepositPlan = baseDepositPlan;
    }

    @Override
    public String toString() {
        return "BaseDepositForPlanOut{" +
                "baseDepositPlan=" + baseDepositPlan +
                '}';
    }
}
