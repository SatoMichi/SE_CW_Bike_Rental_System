import java.util.Hashtable;

public class ProviderList {
	private static Hashtable <BikeProvider, Integer> providers = new Hashtable<>();
	
	protected static Hashtable<BikeProvider,Integer> getProvider() {
		return providers;
	}
    
    public void increaseCount (BikeProvider p) {
        int n  = providers.get(p) + 1;
        providers.put(p, n);
    }
    public void decreaseCount (BikeProvider p) {
        int n  = providers.get(p) - 1;
        providers.put(p, n);
    }
}
