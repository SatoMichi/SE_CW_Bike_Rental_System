package uk.ac.ed.bikerental;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Customer extends Account {

    private int paymentCard;

    public Customer(String name, Location address, int phone, String email, int card) {
        super(name, address, phone, email);
        setPaymentCard(card);
    }

    protected int getPaymentCard() { return paymentCard; }

    protected void setPaymentCard(int paymentCard) { this.paymentCard = paymentCard;}

    public Collection<Quote> getQuote(String[] s){
        Condition c = Condition.toCondition(s);
        if (c == null) return null;
        List <Quote> quotes = new ArrayList<>();
        List <Bike> results = searchBike(c);

        for (Bike b: results) {
            quotes.add(new Quote(b, b.getProvider().getDepositPolicy()));
        }

        return quotes;
    }

    private List<Bike> searchBike (Condition c){
        List <Bike> results = new ArrayList<> ();
        for (Bike b: BikeList.bikes.keySet()) {

            if (c.getMaxPrice().compareTo(b.getPrice()) > 0 &&
                b.getPrice().compareTo(c.getMinPrice()) > 0 &&
                c.getProvider().getName() == b.getProvider().getName() &&
                c.getType().getType() == b.getType().getType() &&
                c.getLocation().isNearTo(b.getProvider().getAddress()) &&
                b.isAvail(c.getDate())
                )
            {
                //System.out.println(b.toString());
                results.add(b);
            }
        }

        if (results.size() > c.getNumber()) {
            return results.subList(0, c.getNumber());
        }

        return results;
    }

    // DateRange is inputed.
    public Booking bookQuote(Collection<Quote> quotes, boolean d, DateRange date) {
        Booking booking = new Booking(quotes, this, date, d);
        // constructor notify Customer and Provider

        String invoice = booking.printOrder();
        System.out.printf("%s\n", invoice);
        return booking;
    }

    public String getStatus(Bike bike) {
        return bike.toString();
    }

}
