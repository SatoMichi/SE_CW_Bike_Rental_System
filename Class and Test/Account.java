package uk.ac.ed.bikerental;
public class Account {

    private String name;
    private Location address;
    private int phone;
    private String email;

    public Account(String n, Location a, int p, String e) {
        this.name = n;
        this.address = a;
        this.phone = p;
        this.email = e;
    }

    public String getName() { return this.name;}
    public void setName(String n) { this.name = n;}
    public Location getAddress() { return this.address;}
    public void setAddress(Location a) { this.address = a;}
    public int getPhone() { return this.phone;}
    public void setPhone(int p) { this.phone = p;}
    public String getEmail() { return this.email;}
    public void setEmail(String e) { this.email = e;}
}
