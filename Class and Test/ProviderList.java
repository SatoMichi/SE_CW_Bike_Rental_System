import java.util.List;
import java.util.ArrayList;

public class ProviderList {
    protected static List<BikeProvider> providers = new ArrayList<BikeProvider>();
    
    public void increaseCount (BikeProvider p) {
        int n  = providers.get(p) + 1;
        providers.put(p, n);
    }
    public void decreaseCount (BikeProvider p) {
        int n  = providers.get(p) - 1;
        providers.put(p, n);
    }
}
