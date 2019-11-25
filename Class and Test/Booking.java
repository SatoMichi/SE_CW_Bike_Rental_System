import java.util.Collection;

public class Booking {
	
	private final int orderNumber;
	private Collection<Quote> quotes;
	private Customer customer;
	private Invoice invoice;
	
	public Booking(Collection<Quote> q, Customer c) {
		orderNumber = OrderNumber.generate();
		this.customer = c;
		this.quotes = q;
		this.invoice = new Invoice(this.quotes, this.customer);
	}
	
	public int getOrderNumber() { return this.orderNumber;}
	
	protected String printOrder() {
		display(this.invoice.toString());
		emailToCustomer();
		return this.invoice.toString();
	}
	
	private void display(String s) {
	     // not implementing this method because this is the process out side the system (I/O)
	    }
	    
	private void emailToCustomer() {
	     // not implementing this method because this is the process out side the system.
	}
	    
	public void notifyProvider() {
	    for (Quote q: quotes) {
	        emailToProvider(q.getBike().getProvider());
	    }
	}
	    	    
	private void emailToProvider(BikeProvider p) {
	    // not implementing this method because this is the process out side the system.
	}
}
