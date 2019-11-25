
public class OrderNumber {

	private static int number = 0;
	
	protected static int generate() {
		number++;
		return number;
	}
}
