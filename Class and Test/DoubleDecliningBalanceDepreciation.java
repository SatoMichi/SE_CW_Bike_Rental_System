import java.math.BigDecimal;
import java.time.LocalDate;

public class DoubleDecliningBalanceDepreciation implements ValuationPolicy {

    private BigDecimal rate;
    
    public DoubleDecliningBalanceDepreciation(BigDecimal rate) {
        setRate(rate);
    }
    
    public BigDecimal getRate() { return rate; }

    public void setRate(BigDecimal rate) { this.rate = rate; } 
    
    @Override
    public BigDecimal calculateValue(Bike bike, LocalDate date) {
        BigDecimal originalV = bike.getType().getReplacementValue();
        int year = date.getYear() - bike.getRegDate().getYear();
        // Value = OriginalV * (1-2*rate)^year
        BigDecimal Value = originalV.multiply( BigDecimal.ONE.subtract( rate.add(rate) ).pow(year) );
        return Value;
    }

}
