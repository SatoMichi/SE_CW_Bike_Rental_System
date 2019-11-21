//package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

public class BikeType {
    
    public enum biketype{
        Road_Bike,
        Mountain_Bike,
        Hybrid_Bike,
        E_Bike
    }
    
    private biketype type;
    private BigDecimal repValue;
    
    public BikeType(biketype type, BigDecimal rep) {
        this.setType(type);
        this.repValue = rep;
    }

    public BigDecimal getReplacementValue() {
        return repValue;
    }

    public biketype getType() {
        return type;
    }

    public void setType(biketype type) {
        this.type = type;
    }
    
    public String toString() {
        return type.toString();
    }
}