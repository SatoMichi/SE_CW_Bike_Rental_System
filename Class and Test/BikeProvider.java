import java.util.List;

public class BikeProvider extends Account {
    private String openingHours;
    private List<BikeProvider> partners;
    
    public BikeProvider(String name, String email, int phone, Location address, String openingHours) {
        super(name, address, phone, email);
        this.openingHours = openingHours;
    }
    
    public void addPartner(BikeProvider p) { partners.add(p);}
    public String getHours() { return this.openingHours;}
    
    public boolean isPartner(BikeProvider p) {
        for (BikeProvider partner : partners) {
            if (p == partner) return true;
        }
        return false;
    }
    
    // If only orderNumber is provided, then we have to implement 
    // some method which takes orderNumber and return Bike.  
    public void returnBike(int orderNumber, Bike bike) {
        // not yet implemented 
    }
    
    public void returnBikePartner(int orderNumber, Bike bike) {
        if (partners.contains(bike.getProvider())) {
            returnBike(orderNumber, bike);
            // process for delivering bike to original provider.
        }
    }
    
    public void register(Bike b, int count) {
        BikeList.getBikes().put(b, count);
    }
    
    public void unregister(Bike b, BikeList list) {
        BikeList.getBikes().remove(b);
    }
}
