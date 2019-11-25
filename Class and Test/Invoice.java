import java.math.BigDecimal;
import java.util.Collection;

public class Invoice {
	
	private final int orderNo;
	private Collection<Quote> quotes;
	private Customer customer;
	private DateRange date;
	private Location address;
	
	public Invoice(Collection<Quote> q, Customer c) {
		this.orderNo = OrderNumber.generate();
		this.quotes = q;
		this.customer = c;
	}
	
	private String getBikesInfo() {
		String ans = "";
		int count = 1;
		for (Quote q : quotes) {
			ans += String.format("%d: ", count);
			ans += q.getBike().toString();
			ans += "\n";
			count++;
		}
		return ans;
	}
	
	private BigDecimal getTotalPrice() {
		BigDecimal price = new BigDecimal(0);
		for (Quote q : quotes) {
			price.add(q.getBike().getPrice());
		}
		return price;
	}
	
	public String toString() {
		String ans = "";
		ans += String.format("Order Number: %d \nBike(s) booked: %sDate booked: %s \nAddress: %s \nCustomer: %s \nTotal price: %s \n", 
				orderNo,
				this.getBikesInfo(),
				date.toString(),
				address.toString(),
				customer.getName(),
				getTotalPrice().toString());
		
		return ans;
	}
}
