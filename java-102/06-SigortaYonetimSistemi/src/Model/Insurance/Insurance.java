package Model.Insurance;

import java.time.LocalDate;

public abstract class Insurance {
    private final String insuranceName;
    private final double insuranceCost;
    private LocalDate insuranceDate;

    public Insurance(String insuranceName, double insuranceCost, LocalDate insuranceDate) {
        this.insuranceName = insuranceName;
        this.insuranceCost = insuranceCost;
        this.insuranceDate = insuranceDate;
    }

    public abstract void calculate();

    public String getInsuranceName() {
        return insuranceName;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public LocalDate getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(LocalDate insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

}