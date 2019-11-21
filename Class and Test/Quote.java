import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Quote {
    private Bike bike;
    private BigDecimal deposite;
    
    public Quote(Bike bike, BigDecimal deposite) {
        this.setBike(bike);
        this.setDeposite(deposite);
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public BigDecimal getDeposite() {
        return deposite;
    }

    public void setDeposite(BigDecimal deposite) {
        this.deposite = deposite;
    }
    
    @SuppressWarnings("unchecked")
    public List<Bike> searchBike (Condition c, BikeList bikes){
        List <Bike> results = new ArrayList<> ();
        for (Bike b: (List <Bike>)bikes.bikes.keys()) {
            if (c.getMaxPrice().compareTo(b.getPrice()) > 0 &&
                b.getPrice().compareTo(c.getMinPrice()) > 0 &&
                c.getProvider() == b.getProvider() &&
                c.getType() == b.getType() &&
                c.getLocation().isNearTo(b.getProvider().getAddress()) &&
                b.isAvail(c.getDate())  )
            {
                results.add(b);
            }
        }
        return results;
    }
    
}
