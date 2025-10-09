package withdrawabledeposit;

import basedepositcalculator.BaseDepositForPlanOut;
import insurancepremiumcalculator.InsurancePremiumOut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WithdrawableDepositService {

    public static List<WithdrawableDepositOut> calculateWithdrawableDeposit(
            List<BaseDepositForPlanOut> baseDeposits,
            List<InsurancePremiumOut> premiums
    ) {
        List<WithdrawableDepositOut> results = new ArrayList<>();

        if (baseDeposits == null || premiums == null) {
            return results;
        }


        Map<String, BigDecimal> premiumMap = new HashMap<>();
        for (InsurancePremiumOut premium : premiums) {
            if (premium != null && premium.salaryId() != null && premium.insurancePremium() != null) {
                premiumMap.put(premium.salaryId(), premium.insurancePremium());
            }
        }

        for (BaseDepositForPlanOut baseDeposit : baseDeposits) {
            if (baseDeposit == null || baseDeposit.salaryId() == null || baseDeposit.baseDepositPlan() == null) {
                continue;
            }

            BigDecimal insurancePremium = premiumMap.get(baseDeposit.salaryId());
            if (insurancePremium == null) {
                continue;
            }

            BigDecimal withdrawable = baseDeposit.baseDepositPlan().subtract(insurancePremium);
            results.add(new WithdrawableDepositOut(baseDeposit.salaryId(), withdrawable));
        }

        return results;
    }
}