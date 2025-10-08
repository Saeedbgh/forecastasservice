package basedepositcalculator;

import java.math.BigDecimal;

public class NetSalaryOut {

    BigDecimal netSalary;


    public NetSalaryOut(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "NetSalaryOut{" +
                "netSalary=" + netSalary +
                '}';
    }
}
