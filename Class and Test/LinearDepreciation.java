import java.math.BigDecimal;
import java.time.LocalDate;

public class LinearDepreciation implements ValuationPolicy {

	@Override
	public BigDecimal calculateValue(Bike bike, LocalDate date) {
        BigDecimal originalV = bike.getType().getReplacementValue();
        BigDecimal rate = bike.getProvider().getRate();
        BigDecimal year = new BigDecimal(date.getYear() - bike.getRegDate().getYear());
        BigDecimal Value = originalV.subtract(year.multiply(rate).multiply(originalV));
        return Value;
    }

}
