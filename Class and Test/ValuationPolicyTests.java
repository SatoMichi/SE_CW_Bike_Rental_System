//package uk.ac.ed.bikerental;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ValuationPolicyTests {
    private ValuationPolicy ld;
    private ValuationPolicy ddbd;
    private Bike bike;
    private LocalDate now;

    @BeforeEach
    void setUp() throws Exception {
        
        // set LinearDepreciation
        ld = new LinearDepreciation(new BigDecimal(0.1));
        // set DoubleDecliningBalanceDepreciation
        ddbd = new DoubleDecliningBalanceDepreciation(new BigDecimal(0.1));
        // set bike
        BikeType type = new BikeType("MTB", new BigDecimal(900));
        BikeProvider provider = new BikeProvider("", "", 0, null, "");
        bike = new Bike(type, new BigDecimal(20), provider, LocalDate.of(2016, 06, 01));
       // set now
        now = LocalDate.of(2019,12,31);
        
        //System.out.print("Depreciation Rate is 0.1 (10%), ");
        //System.out.println("Bike Original Value is Both 900");
        //System.out.print("Bike Registered Date is 2016/06/01, ");
        //System.out.println("Now is " + now.toString());
        //System.out.println(now.getYear() - bike.getRegDate().getYear())
        ;
    }
    
    // TODO: Write tests for valuation policies
    @Test
    public void testLD() {
        BigDecimal value = ld.calculateValue(bike, now);
        BigDecimal calc = new BigDecimal(900).subtract(new BigDecimal(3*0.1*900));
        System.out.println(value.stripTrailingZeros());
        System.out.println(calc.stripTrailingZeros());
        Assertions.assertEquals(value.stripTrailingZeros(), calc.stripTrailingZeros());
    }
    @Test
    public void testDDBD() {
        BigDecimal value = ddbd.calculateValue(bike, now);
        BigDecimal calc = ddbd.calculateValue(bike, now);
        System.out.println(value.toString());
        System.out.println(calc.toString());
        Assertions.assertEquals(value1.stripTrailingZeros(), value2.stripTrailingZeros());
    }
}
