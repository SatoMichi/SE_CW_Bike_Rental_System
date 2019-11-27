package uk.ac.ed.bikerental;
import java.util.Hashtable;

public class BikeList {
    protected static Hashtable <Bike, Integer> bikes = new Hashtable<Bike, Integer>();

    public void increaseCount (Bike bike) {
        int n  = bikes.get(bike) + 1;
        bikes.put(bike, n);
    }
    public void decreaseCount (Bike bike) {
        int n  = bikes.get(bike) - 1;
        bikes.put(bike, n);
    }
}
