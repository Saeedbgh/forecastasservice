package insurancepremiumcalculator;

import java.math.BigDecimal;

public class InsurancePremiumOut {

    BigDecimal insuranceRate;
    BigDecimal grossSalary;
    BigDecimal insurancePremium;

    public InsurancePremiumOut(BigDecimal insuranceRate, BigDecimal grossSalary, BigDecimal insurancePremium) {
        this.insuranceRate = insuranceRate;
        this.grossSalary = grossSalary;
        this.insurancePremium = insurancePremium;
    }

    public InsurancePremiumOut(BigDecimal insurancePremium) {
        this.insurancePremium = insurancePremium;
    }


    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public BigDecimal getInsurancePremium() {
        return insurancePremium;
    }

    public void setInsurancePremium(BigDecimal insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    @Override
    public String toString() {
        return "InsurancePremiumOut{" +
                ", insurancePremium=" + insurancePremium +
                '}';
    }
}
