package uk.ac.ed.bikerental;

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
    /**
     * PostCode which should follow format; AA9A9AA, A99AA, AA99AA, A9A9AA, A999AA, AA999AA
     */
    private String postcode;
    /**
     * Address of the Location there is no specific required format, it should follow how address in the UK should be
     */
    private String address;

    public Location(String postcode, String address) {
        assert postcode.length() >= 6;
        this.postcode = postcode;
        this.address = address;
    }

    /**
     *  Method to check whether two location are near.
     *  @param        other the other location
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
    /**
     *  Helper function of isNear() method.
     *  @param        postcode which is String
     *  @return       return first two digit as int
     */
    private int extractNums(String postcode) {
        String num = "";
        int j = 0;
        for (int i = 0; i < postcode.length(); i++) {
            if (Character.isDigit(postcode.charAt(i))) {
                j++;
                num += postcode.charAt(i);
            }
            if (j == 2) break;
        }
        return Integer.parseInt(num);
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return this.getAddress() + " " + this.getPostcode();
    }

    public String getPostcode() {
        return postcode;
    }
}
