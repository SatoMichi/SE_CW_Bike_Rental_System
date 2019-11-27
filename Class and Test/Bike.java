package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bike implements Deliverable {

    private BikeType type;
    private List<DateRange> booked = new ArrayList<>();
    private BigDecimal price;
    private BikeProvider provider;
    private final LocalDate regDate;
    private boolean availability = true;

    public Bike(BikeType type, BigDecimal price, BikeProvider provider, LocalDate regDate) {
        this.type = type;
        this.price = price;
        this.provider = provider;
        this.regDate = regDate;
    }
    public boolean getAvailability() { return this.availability;}

    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getPrice() { return this.price; }

    public BikeProvider getProvider() { return this.provider; }

    public BikeType getType() { return type; }

    public LocalDate getRegDate() { return this.regDate; }

    //overload
    // if this implements ValuationPolicy, then use calculateValue(Bike bike, LocalDate date)
    public BigDecimal calculateValue() {
        return this.type.getReplacementValue().multiply(this.provider.getRate());
    }

    public void book(DateRange range) {
        booked.add(range);
    }

    public boolean isAvail(DateRange date) {
        if (booked.size() == 0) {return true;}
        for (int i = 0; i < booked.size(); i++) {
            if (!booked.get(i).overlaps(date)) return true && this.availability;
        }
        return false;
    }

    public String toString() {
        return "Bike Type: " + type.getType()      + "\n" +
                "Provider: " + provider.getName() + "\n" +
                "Price: "    + price.toString()    + "\n";
    }
    @Override
    public void onPickup() {
        availability = true;
    }
    @Override
    public void onDropoff() {
        availability = false;
    }
    @Override
    public int hashCode() {
        return type.getType().hashCode() + price.hashCode() + provider.getName().hashCode() + regDate.hashCode();
    }
}
