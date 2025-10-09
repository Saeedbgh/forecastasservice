package withdrawabledeposit;

import java.math.BigDecimal;

public record WithdrawableDepositOut(String salaryId, BigDecimal withdrawableDeposit) {

    @Override
    public String toString() {
        return "WithdrawableDepositOut{" +
                "salaryId='" + salaryId + '\'' +
                ", withdrawableDeposit=" + withdrawableDeposit +
                '}';
    }
}