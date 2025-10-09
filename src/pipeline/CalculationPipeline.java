package pipeline;

import util.SalaryEntry;
import basedepositcalculator.BaseDepositForPlanOut;
import basedepositcalculator.BaseDepositForPlanService;
import insurancepremiumcalculator.InsurancePremiumOut;
import insurancepremiumcalculator.InsurancePremiumService;
import withdrawabledeposit.WithdrawableDepositOut;
import withdrawabledeposit.WithdrawableDepositService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CalculationPipeline {

    public static List<WithdrawableDepositOut> runPipeline(List<BigDecimal> grossSalaries) {

        List<SalaryEntry> salaryEntries = grossSalaries.stream()
                .map(salary -> new SalaryEntry(UUID.randomUUID().toString(), salary))
                .toList();

        System.out.println("=== Salary Entries ===");
        salaryEntries.forEach(System.out::println);

        List<BaseDepositForPlanOut> baseDeposits = BaseDepositForPlanService.calculateBaseDeposit(salaryEntries);
        System.out.println("\n=== Base Deposit for Plan ===");
        baseDeposits.forEach(System.out::println);

        List<InsurancePremiumOut> premiums = InsurancePremiumService.calculatePremium(salaryEntries);
        System.out.println("\n=== Insurance Premiums ===");
        premiums.forEach(p -> {
            System.out.println(p + " | rate=" + p.insuranceRate());        });

        List<WithdrawableDepositOut> withdrawables =
                WithdrawableDepositService.calculateWithdrawableDeposit(baseDeposits, premiums);

        System.out.println("\n=== Withdrawable Deposits ===");
        withdrawables.forEach(System.out::println);

        return withdrawables;
    }
}