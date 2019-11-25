import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Invoice {
    
    private List <Bike> bikes;
    private BigDecimal price;
    private LocalDate date;
    private Customer customer;
    private int ordernumber;
    
    public Invoice(List<Bike> bikes, BigDecimal price, LocalDate date, Customer customer, int ordernumber) {
        this.bikes = bikes;
        this.price = price;
        this.date = date;
        this.customer = customer;
        this.ordernumber = ordernumber;
    }
    
    public String toString() {
        String bikesInfo = "";
        for (Bike b: bikes) {
            bikesInfo += b.toString();
        }
        return ("OrderNumber: " + ordernumber + 
                "\nDate: " + date +
                "\nCustomer Name: " + customer.toString() +
                "\nBikes booked is " + bikesInfo +
                "\nPrice is " + price.toString() + "\n");
    }
}
