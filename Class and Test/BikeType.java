//package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

public class BikeType {
    private String type;
    private BigDecimal repValue;
    
    public BikeType(String type, BigDecimal rep) {
        this.setType(type);
        this.repValue = rep;
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
    
    public String toString() {
        return type;
    }
}