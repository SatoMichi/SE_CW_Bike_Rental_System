package uk.ac.ed.bikerental;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestLocation {
    Location ad1;

    @BeforeEach
    void setUp() throws Exception {
        ad1 = new Location("EH91NJ", "Scinnes 20-9");
    }

    @Test
    void compareTest1() {
        Location ad2 = new Location("WC2H7LT", "Some where");
        assert(ad1.isNearTo(ad2)== false);
        //System.out.println(ad1.isNearTo(ad2));

    }
    @Test
    void compareTest2() {
        Location ad3 = new Location("EH91AB", "Any where");
        assert(ad1.isNearTo(ad3) == true);
        //System.out.println(ad1.isNearTo(ad3));
    }
}
