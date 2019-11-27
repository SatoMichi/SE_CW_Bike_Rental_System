package uk.ac.ed.bikerental;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
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
        Condition c = toCondition(s);
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
    
    private static boolean isValid(String[] s) {
        if (s.length == 8) return true;
        return false;
    }

    public static Condition toCondition(String[] s) {
        if (!isValid(s)) return null;
        // s[0] = BikeType
        BikeType type = new BikeType(s[0], BigDecimal.ZERO);
        
        // s[1] = minPrice, s[2] = maxPrice
        BigDecimal minPrice = new BigDecimal(s[1]);
        BigDecimal maxPrice = new BigDecimal(s[2]);
        
        // s[3] = Post code, s[4] = address
        Location location = new Location(s[3],s[4]);
        
        // s[5] = startDate, s[6] = endDate
        // have to follow "2019/09/09" this format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate start = LocalDate.parse(s[5], formatter);
        LocalDate end   = LocalDate.parse(s[6], formatter);
        DateRange date = new DateRange(start,end);
        
        // s[7] = name of Provider
        List<BikeProvider> listofProvider = ProviderList.providers;
            
        BikeProvider provider = null;
        for (BikeProvider p: listofProvider) {
            if (p.getName() == s[7]) {provider =  p;}
        }
         
        
        // s[8] = number
        int number = Integer.parseInt(s[8]);
        /*
        System.out.println(type.getType());
        System.out.println(minPrice);
        System.out.println(maxPrice);
        System.out.println(location);
        System.out.println(date);
        System.out.println(provider);
        System.out.println(number);
        */
        return new Condition(type,minPrice,maxPrice,location, date, provider, number);
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