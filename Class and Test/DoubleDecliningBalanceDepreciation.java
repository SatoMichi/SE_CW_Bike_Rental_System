import java.math.BigDecimal;
import java.time.LocalDate;

public class DoubleDecliningBalanceDepreciation implements ValuationPolicy {
    @Override
    public BigDecimal calculateValue(Bike bike, LocalDate date) {
        BigDecimal originalV = bike.getType().getReplacementValue();
        BigDecimal rate = new BigDecimal(bike.getProvider().getRate());
        int year = date.getYear() - bike.getRegDate().getYear();
        // Value = OriginalV * (1-2*rate)^year
        BigDecimal Value = originalV.multiply( BigDecimal.ONE.subtract( rate.add(rate) ).pow(year) );
        return Value;
    }

}
