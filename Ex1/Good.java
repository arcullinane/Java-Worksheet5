/**
 * Class to store details about goods that can be purchased
 * @author andrew cullinane
 */
public class Good {
	
	//field variables
	private String name;
	private int price;

	/**
	 * Constructor for Good class
	 * @param name as String
	 * @param price as an int
	 */
	public Good(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * getter method for price
	 * @return price of good as int
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * toString method to show text output
	 * @return String output
	 */
	public String toString() {
		return "Name: " + name + ", Price: \u00A3" + price + ".";
	}
	
}
