import java.util.Hashtable;

public class BikeList {
    private static Hashtable <Bike, Integer> bikes = new Hashtable<Bike, Integer>();
    
    public static Hashtable<Bike, Integer> getBikes() { return bikes;}
    
    public void increaseCount (Bike bike) {
        int n  = bikes.get(bike) + 1;
        bikes.put(bike, n);
    }
    public void decreaseCount (Bike bike) {
        int n  = bikes.get(bike) - 1;
        bikes.put(bike, n);
    }
}