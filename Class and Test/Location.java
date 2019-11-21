//package uk.ac.ed.bikerental;

/**
 * <p>This class include the method to check whether two lacation is near or not 
 * (based on comparing first tow digit of post code)</p>
 * 
 * <p>This Location class is only for UK, therefore the postcode is assumed to be 
 * the UK style. In UK there are 6 patterns of Post code:
 * <p>AA9A9AA, A99AA, AA99AA, A9A9AA, A999AA, AA999AA</p>
 * 
 * In the Constructor, the postcode argument is assumed to be 
 * flowing above 6 pattern of postcode without space inside.
 * @param postcode String with Uppercase Alpahbet and number without space.
 */

public class Location {
    private String postcode;
    private String address;
    
    public Location(String postcode, String address) {
        assert postcode.length() >= 6;
        this.postcode = postcode;
        this.address = address;
    }
    
    /**
     * Method to check whether two location is near.
     *  @param  other the other location
     *  @return       return true if they are near else return false
     */
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
    public String toString() {
        return postcode.toString()+"\n"+address.toString();
    }
}
