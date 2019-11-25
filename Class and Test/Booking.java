import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//package uk.ac.ed.bikerental;

public class Booking {
    private List <Quote> quotes = new ArrayList<>();
    private int orderNumber;
    
    public List<Quote> getQuotes() {return quotes;}

    public void setQuotes(List<Quote> quotes) {this.quotes = quotes;}
    
    public int getOrderNumber() {return orderNumber;}

    public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}
    
    // email with Invoice will be send to Customer
    public Invoice printSummary(Customer c) {
        List<Bike> bikes = new ArrayList<>();
        for (Quote q: quotes) {
            bikes.add(q.getBike());
        }
        
        BigDecimal prices = BigDecimal.ZERO;
        for (Quote q: quotes) {
            prices.add(q.getBike().getPrice());
        }
        
        LocalDate date = LocalDate.now();
        Invoice invoice = new Invoice(bikes, prices, date, c, orderNumber);
        display(invoice.toString());
        emailToCustomer(c,invoice.toString());
        return invoice;
    }
    
    private void display(String s) {
     // not implementing this method because this is the process out side the system (I/O).
        System.out.println(s);
    }
    
    private void emailToCustomer(Customer c, String s) {
     // not implementing this method because this is the process out side the system.
        System.out.println("Email is sent.");
    }
    
    public void notifyProvider() {
        for (Quote q: quotes) {
            String booked = q.getBike().toString() + "is booked\n";
            emailToProvider(q.getBike().getProvider(), booked);
        }
    }
    
    
    private void emailToProvider(BikeProvider p, String s) {
        // not implementing this method because this is the process out side the system.
        System.out.println("Email is sent.");
    }
    
}
