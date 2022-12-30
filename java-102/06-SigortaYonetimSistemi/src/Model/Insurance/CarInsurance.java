package Model.Insurance;

import java.time.LocalDate;

public class CarInsurance extends Insurance {
    public CarInsurance(String insuranceName, double insuranceCost, LocalDate insuranceDate) {
        super(insuranceName, insuranceCost, insuranceDate);
    }

    @Override
    public void calculate() {
    }
}
