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

    public Bike getBike() { return bike; }

    public void setBike(Bike bike) { this.bike = bike; }

    public BigDecimal getDeposite() { return deposite; }

    public void setDeposite(BigDecimal deposite) { this.deposite = deposite; }
      
}
