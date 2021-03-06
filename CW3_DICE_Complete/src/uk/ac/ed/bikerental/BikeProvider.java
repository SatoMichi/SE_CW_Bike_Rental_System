package uk.ac.ed.bikerental;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BikeProvider extends Account {
    private String openingHours;
    private List<BikeProvider> partners = new ArrayList<>();
    private BigDecimal depositRate;
    private String depositPolicy = "";

    public BikeProvider(String name, String email, int phone, Location address, String openingHours, double d) {
        super(name, address, phone, email);
        this.depositRate = new BigDecimal(d);
        this.openingHours = openingHours;
    }

    public BigDecimal getRate() { return this.depositRate;}
    public void setRate(int d) { this.depositRate = new BigDecimal(d);}
    public void addPartner(BikeProvider p) { partners.add(p);}
    public String getHours() { return this.openingHours;}

    public String getDepositPolicy() { return this.depositPolicy;}
    public void setDepositPolicy(String x) { this.depositPolicy = x;}

    public boolean isPartner(BikeProvider p) {
        for (BikeProvider partner : partners) {
            if (p == partner) return true;
        }
        return false;
    }

    protected void returnBike(int orderNumber, LocalDate date) {
        List<Bike> bikes = new ArrayList<Bike>();
        for (Booking b : ListofBooking.bookings) {
            if (b.getOrderNumber() == orderNumber) {
                for (Quote q : b.getbookedQuotes()) {
                    bikes.add(q.getBike());
                }
                break;
            }
        }

        DeliveryServiceFactory.setupMockDeliveryService();
        DeliveryService d = DeliveryServiceFactory.getDeliveryService();

        for (Bike b : bikes) {
            if (this.isPartner(b.getProvider())) {
                d.scheduleDelivery(b, this.getAddress(), b.getProvider().getAddress(), date.plusDays(1));
            }
            else if (this == b.getProvider()) b.onPickup();
        }
    }

    protected void register(Bike b, int count) {
        BikeList.bikes.put(b, count);
    }

    protected void unregister(Bike b) {
        BikeList.bikes.remove(b);
    }
}
