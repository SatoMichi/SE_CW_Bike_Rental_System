import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Customer extends Account {
    
    private int paymentCard;
    
    public Customer(String name, Location address, int phone, String email, int card) {
        super(name, address, phone, email);
        setPaymentCard(card);
    }

    protected int getPaymentCard() { return paymentCard; }

    protected void setPaymentCard(int paymentCard) { this.paymentCard = paymentCard;}
    
/*    public Collection<Quote> getQuote(Condition c){
       List <Quote> quotes = new ArrayList<>();
       List <Bike> results = Quote.searchBike(c);
       
       for (Bike b: results) {
           quotes.add(new Quote(b,b.getPrice()));
       }
       
       return quotes;
    } */

    public Condition toCondition(String[] s) {
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
        BikeProvider provider = listofProvider
        							.entrySet()
        							.stream()
        							.filter(p -> p.getKey().getName() == s[7])
        							.findFirst()
        							.get()
        							.getKey(); // return first element which has the name s[7] in the list of Bike Provider
        
        // s[8] = number
        int number = Integer.parseInt(s[8]);
        
        return new Condition(type,minPrice,maxPrice,location, date, provider, number);
    }
    
    public boolean bookQuote(Collection<Quote> quotes) {
        // not yet implemented
        return false;
    }
    
    public String getStatus(Bike bike) {
        return bike.toString();
    }

}
