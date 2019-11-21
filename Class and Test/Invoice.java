import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    
    private Bike bike;
    private BigDecimal price;
    private LocalDate date;
    private Customer customer;
    private int ordernumber;
    
    public Invoice(Bike bike, BigDecimal price, LocalDate date, Customer customer, int ordernumber) {
        super();
        this.bike = bike;
        this.price = price;
        this.date = date;
        this.customer = customer;
        this.ordernumber = ordernumber;
    }
    
    public String toString() {
        return ("OrderNumber: " + ordernumber + 
                "\nDate: " + date +
                "\nCustomer Name: " + customer.toString() +
                "\nBiked booked is " + bike.toString() +
                "\nPrice is " + price.toString() + "\n");
    }
}
