import java.util.Hashtable;

public class BikeList {
    Hashtable <Bike, Integer> bikes;
    
    public void increaseCount (Bike bike) {
        int n  = bikes.get(bike) + 1;
        bikes.put(bike, n);
    }
    public void decreaseCount (Bike bike) {
        int n  = bikes.get(bike) - 1;
        bikes.put(bike, n);
    }
}
