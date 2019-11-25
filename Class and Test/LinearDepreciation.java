import java.math.BigDecimal;
import java.time.LocalDate;

public class LinearDepreciation implements ValuationPolicy {
    
    private BigDecimal rate;
    
    public LinearDepreciation(BigDecimal rate) {
        setRate(rate);
    }
    
    
    public BigDecimal getRate() { return rate; }

    public void setRate(BigDecimal rate) { this.rate = rate; }

    @Override
    public BigDecimal calculateValue(Bike bike, LocalDate date) {
        BigDecimal originalV = bike.getType().getReplacementValue();
        BigDecimal year = new BigDecimal(date.getYear() - bike.getRegDate().getYear());
        BigDecimal Value = originalV.subtract(year.multiply(rate).multiply(originalV));
        return Value;
    }

}
