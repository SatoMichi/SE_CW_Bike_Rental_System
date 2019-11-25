//package uk.ac.ed.bikerental;
import java.math.BigDecimal;

public class Condition {
    private BikeType type;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;    //price range
    private Location location;
    private DateRange date;
    private BikeProvider provider;
    private int number;
    
    public Condition(BikeType type,BigDecimal minPrice,BigDecimal maxPrice,Location location,
                    DateRange date, BikeProvider provider,int number)
    {
        this.setType(type);
        this.setPrice(minPrice, maxPrice);
        this.setLocation(location);
        this.setDate(date);
        this.setProvider(provider);
        this.setNumber(number);
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DateRange getDate() {
        return date;
    }

    public void setDate(DateRange date) {
        this.date = date;
    }

    public BikeProvider getProvider() {
        return provider;
    }

    public void setProvider(BikeProvider provider) {
        this.provider = provider;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
