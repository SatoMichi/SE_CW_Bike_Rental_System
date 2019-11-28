package uk.ac.ed.bikerental;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Condition {
    private BikeType type;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;    //price range
    private Location location;
    private DateRange date;
    private BikeProvider provider;
    private int number;

    public Condition(BikeType type,BigDecimal minPrice,BigDecimal maxPrice,Location location,
                    DateRange date, BikeProvider provider,int number)
    {
        this.setType(type);
        this.setPrice(minPrice, maxPrice);
        this.setLocation(location);
        this.setDate(date);
        this.setProvider(provider);
        this.setNumber(number);
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DateRange getDate() {
        return date;
    }

    public void setDate(DateRange date) {
        this.date = date;
    }

    public BikeProvider getProvider() {
        return provider;
    }

    public void setProvider(BikeProvider provider) {
        this.provider = provider;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private static boolean isValid(String[] s) {
        if (s.length == 9) return true;
        return false;
    }

    public static Condition toCondition(String[] s) {
    	//System.out.println(s.length);
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

        /*System.out.println(type.getType());
        System.out.println(minPrice);
        System.out.println(maxPrice);
        System.out.println(location);
        System.out.println(date);
        System.out.println(provider);
        System.out.println(number);*/

        return new Condition(type,minPrice,maxPrice,location, date, provider, number);
    }
}
