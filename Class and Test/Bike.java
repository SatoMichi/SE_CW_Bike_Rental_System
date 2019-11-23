//package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Bike {
    
    private BikeType type;
    private List<DateRange> booked;
    private BigDecimal price;
    private BikeProvider provider;
    
    public Bike(BikeType type, boolean availability, BigDecimal price, BikeProvider provider) {
        this.type = type;
        this.price = price;
        this.provider = provider;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void book(DateRange range) {
        booked.add(range);
    }
    
    public boolean isAvail(DateRange date) {
        for (int i = 0; i < booked.size(); i++) {
            if (!booked.get(i).overlaps(date)) return true;
        }
        return false;
    }
    
    public BikeProvider getProvider() { return this.provider;}
    
    public BikeType getType() {
        return type;
    }
    
    public String toString() {
        return "Bike Type: " + type.getType()      + "\n" +
                "Provider: " + provider.toString() + "\n" +
                "Price: "    + price.toString()    + "\n";
    }
}
