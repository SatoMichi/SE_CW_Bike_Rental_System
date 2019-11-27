package uk.ac.ed.bikerental;

import java.math.BigDecimal;

public class BikeType {
    private String type;
    private final BigDecimal repValue;

    public BikeType(String type, BigDecimal value) {
        this.type = type;
        this.repValue = value;
    }

    public BigDecimal getReplacementValue() {
        return repValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
