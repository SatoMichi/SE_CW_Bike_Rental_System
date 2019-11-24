//package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bike {
    
    private BikeType type;
    private List<DateRange> booked = new ArrayList<>();
    private BigDecimal price;
    private BikeProvider provider;
    private LocalDate regDate;
    
    public Bike(BikeType type, BigDecimal price, BikeProvider provider, LocalDate regDate) {
        this.type = type;
        this.price = price;
        this.provider = provider;
        this.regDate = regDate;
    }
    
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public BigDecimal getPrice() { return this.price; }
    
    public BikeProvider getProvider() { return this.provider; }
    
    public BikeType getType() { return type; }
    
    public LocalDate getRegDate() { return this.regDate; }
    
    //overload
    // if this implements ValuationPolicy, then use calculateValue(Bike bike, LocalDate date)
    public BigDecimal calculateValue() {
        return type.getReplacementValue();
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
    
    public String toString() {
        return "Bike Type: " + type.getType()      + "\n" +
                "Provider: " + provider.toString() + "\n" +
                "Price: "    + price.toString()    + "\n";
    }
}
