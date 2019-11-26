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
        List <Quote> quotes = new ArrayList<>();
        List <Bike> results = searchBike(c);
       
        for (Bike b: results) {
            quotes.add(new Quote(b, b.getProvider().getDepositPolicy()));
        }
       
        return quotes;
    } 
    
    @SuppressWarnings("unchecked")
    private List<Bike> searchBike (Condition c){
        List <Bike> results = new ArrayList<> ();
        for (Bike b: (List<Bike>)BikeList.getBikes().keys()) {
            if (c.getMaxPrice().compareTo(b.getPrice()) > 0 &&
                b.getPrice().compareTo(c.getMinPrice()) > 0 &&
                c.getProvider().getName() == b.getProvider().getName() &&
                c.getType().getType() == b.getType().getType() &&
                c.getLocation().isNearTo(b.getProvider().getAddress()) &&
                b.isAvail(c.getDate()) )
            {
                results.add(b);
            }
        }
        
        if (results.size() > c.getNumber()) {
            return results.subList(0, c.getNumber());
        }
        
        return results;
    } 

    public static Condition toCondition(String[] s) {
        // s[0] = BikeType
        BikeType type = new BikeType(s[0], null);
        
        // s[1] = minPrice, s[2] = maxPrice
        BigDecimal minPrice = new BigDecimal(s[1]);
        BigDecimal maxPrice = new BigDecimal(s[2]);
        
        // s[3] = Post code, s[4] = address
        Location location = new Location(s[3],s[4]);
        
        // s[5] = startDate, s[6] = endDate
        // have to follow "2019/09/09" this format
        LocalDate start = LocalDate.parse(s[5], DateTimeFormatter.ofPattern("yyyymmdd"));
        LocalDate end   = LocalDate.parse(s[6], DateTimeFormatter.ofPattern("yyyymmdd"));
        DateRange date = new DateRange(start,end);
        
        // s[7] = name of Provider
        Hashtable<BikeProvider, Integer> listofProvider = ProviderList.getProvider();
        BikeProvider provider = listofProvider.entrySet()
        	                    .stream()
        	                    .filter(p -> p.getKey().getName() == s[7])
        	                    .findFirst()
        	                    .get()
        	                    .getKey(); // return first element which has the name s[7] in the list of Bike Provider
        
        // s[8] = number
        int number = Integer.parseInt(s[8]);
        
        return new Condition(type,minPrice,maxPrice,location, date, provider, number);
    }
    // DateRange is inputed.
    public Booking bookQuote(Collection<Quote> quotes, boolean d, DateRange date) {
        Booking booking = new Booking(quotes, this, date, d);
        // constructor notify Customer and Provider
        // if customer chooses to have bike delivered, d will be set to true
        String invoice = booking.printOrder();
        DeliveryServiceFactory.setupMockDeliveryService();
        DeliveryService delivery = DeliveryServiceFactory.getDeliveryService();
        for (Quote q : quotes) {
            Bike b = q.getBike();
            BikeProvider p = b.getProvider();
            b.book(date);
            if (d) {
                delivery.scheduleDelivery(b, 
                        p.getAddress(), 
                        this.getAddress(),
                        date.getEnd());
            }
        }
        System.out.printf("%s\n", invoice);
        return booking;
    }
    
    public String getStatus(Bike bike) {
        return bike.toString();
    }

}

