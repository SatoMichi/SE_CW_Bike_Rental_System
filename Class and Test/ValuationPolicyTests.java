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
        ld = new LinearDepreciation();
        // set DoubleDecliningBalanceDepreciation
        ddbd = new DoubleDecliningBalanceDepreciation();
        // set bike
        BikeType type = new BikeType("MTB", new BigDecimal(900));
        BikeProvider provider = new BikeProvider("", "", 0, null, "",0.1);
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
        //System.out.println(value.setScale(5,BigDecimal.ROUND_HALF_UP));
        //System.out.println(calc.setScale(5,BigDecimal.ROUND_HALF_UP));
        Assertions.assertEquals(value.setScale(5,BigDecimal.ROUND_HALF_UP), calc.setScale(5,BigDecimal.ROUND_HALF_UP));
    }
    @Test
    public void testDDBD() {
        BigDecimal value = ddbd.calculateValue(bike, now);
        BigDecimal origin = new BigDecimal(900);
        BigDecimal calc = origin.multiply(BigDecimal.ONE.subtract(new BigDecimal(2*0.1)).pow(3));
        //System.out.println(value.stripTrailingZeros());
        //System.out.println(calc.stripTrailingZeros());
        Assertions.assertEquals(value.stripTrailingZeros(), calc.stripTrailingZeros());
    }
}
