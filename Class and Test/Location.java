//package uk.ac.ed.bikerental;

public class Location {
    // in UK there are 6 pattern of Post code.
    // AA9A9AA, A99AA, AA99AA, A9A9AA, A999AA, AA999AA
    private String postcode;
    private String address;
    
    public Location(String postcode, String address) {
        assert postcode.length() >= 6;
        this.postcode = postcode;
        this.address = address;
    }
    
    public boolean isNearTo(Location other) {
        
        int numself = extractNums(postcode);
        int numother = extractNums(other.getPostcode());
        
        if (numself == numother) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private int extractNums(String postcode) {
        String [] nums;
        nums = postcode.split("[A-Z]+");
        String num = "";
        for (String n : nums) {
            num += n;
        }
        return Integer.parseInt(num);
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPostcode() {
        return postcode;
    }
}
