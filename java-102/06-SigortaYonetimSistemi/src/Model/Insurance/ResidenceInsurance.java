package Model.Insurance;

import java.time.LocalDate;

public class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(String insuranceName, double insuranceCost, LocalDate insuranceDate) {
        super(insuranceName, insuranceCost, insuranceDate);
    }

    @Override
    public void calculate() {
    }
}