import java.util.List;

public class BikeProvider {
	private String openingHours;
	private List<BikeProvider> partners;
	private String name;
	private Location address;
	private int phone;
	private String email;
	
	public BikeProvider(String name, String email, int phone, Location address, String openingHours) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.openingHours = openingHours;
	}
	
	public void addPartner(BikeProvider p) { partners.add(p);}
	public String getName() { return this.name;}
	public String getEmail() { return this.email;}
	public int getPhone() { return this.phone;}
	public Location getAddress() { return this.address;}
	public String getHours() { return this.openingHours;}
	
	public boolean isPartner(BikeProvider p) {
		for (BikeProvider partner : partners) {
			if (p == partner) return true;
		}
		return false;
	}
	
	public void register(Bike b, int count, BikeList list) {
		list.bikes.put(b, count);
	}
	
	public void unregister(Bike b, BikeList list) {
		list.bikes.remove(b);
	}
}
