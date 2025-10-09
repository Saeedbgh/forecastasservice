package insurancepremiumcalculator;

import java.math.BigDecimal;

public record InsurancePremiumOut(
        String salaryId,
        BigDecimal insurancePremium,
        BigDecimal insuranceRate
) {}
