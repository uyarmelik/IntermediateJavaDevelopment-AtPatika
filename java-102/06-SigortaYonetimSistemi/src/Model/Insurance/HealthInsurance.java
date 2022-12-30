package Model.Insurance;

import java.time.LocalDate;

public class HealthInsurance extends Insurance {
    public HealthInsurance(String insuranceName, double insuranceCost, LocalDate insuranceDate) {
        super(insuranceName, insuranceCost, insuranceDate);
    }

    @Override
    public void calculate() {
    }
}