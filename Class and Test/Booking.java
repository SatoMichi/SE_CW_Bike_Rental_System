import java.util.Collection;

public class Booking {
	
	private final int orderNumber;
	private Collection<Quote> quotes;
	private Customer customer;
	private Invoice invoice;
	private DateRange date;
	private boolean delivery;
	
	public Booking(Collection<Quote> q, Customer c, DateRange d, boolean delivery) {
		orderNumber = OrderNumber.generate();
		this.customer = c;
		this.quotes = q;
		this.date = d;
		this.delivery =delivery;
		this.invoice = new Invoice(this.orderNumber, this.quotes, this.customer, this.date);
		notifyCustomer();
		notifyProvider();
		ListofBooking.bookings.add(this);
	}
	
	public int getOrderNumber() { return this.orderNumber;}
	public Collection<Quote> getbookedQuotes() { return this.quotes;}
	public DateRange getDate() { return this.date;}
	public boolean getDelivery() {return delivery;}
	
	protected String printOrder() {
		display(this.invoice.toString());
		return this.invoice.toString();
	}
	
	private void display(String s) {
	     // not implementing this method because this is the process out side the system (I/O)
	    }
	    
	private void notifyCustomer() {
	     // not implementing this method because this is the process out side the system.
	}
	    
	public void notifyProvider() {
		// not implementing this method because this is the process out side the system.
	}

    
}
