package Model.Insurance;

import java.time.LocalDate;

public class TravelInsurance extends Insurance {
    public TravelInsurance(String insuranceName, double insuranceCost, LocalDate insuranceDate) {
        super(insuranceName, insuranceCost, insuranceDate);
    }

    @Override
    public void calculate() {
    }
}