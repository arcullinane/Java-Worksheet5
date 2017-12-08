import java.util.ArrayList;

/**
 * Class to store customer information along with the goods that they have ever purchased
 * This class is an extension of Customer.
 * @author andrew cullinane
 *
 */
public class CustomerWithGoods extends Customer {

	//field variable
	ArrayList<Good> goods = new ArrayList<Good>();

	/**
	 * Constructor for CustomerWithGoods class
	 * @param customerName as String
	 * @param address as String
	 * @param telephoneNumber as String
	 * @param goods given as an array list of Goods.
	 */
	public CustomerWithGoods(String customerName, String address, String telephoneNumber, ArrayList<Good> goods) {
		super(customerName, address, telephoneNumber);
		this.goods = goods;
	}

	/**
	 * getter method to show goods purchased
	 * @return an array list of Goods.
	 */
	public ArrayList<Good> getGoods() {
		return goods;
	}

	/**
	 * method to add goods to the customers account
	 * @param good as an array list of type Good
	 */
	public void buy(Good good) {
		goods.add(good);
	}

	/**
	 * method to calculate the total value of goods purchased.
	 * @return total value of purchases as an int
	 */
	public int valueOfGoods() {

		int sum = 0;
		//for each item in the goods array list add the value to sum
		for (int i = 0; i < goods.size(); i++) {
			sum += goods.get(i).getPrice();
		}
		return sum;
	}

	/** toString method to give text output
	 * @return String output
	 */
	public String toString() {
		return "Customer: " + getCustomerName() + ", Address: " + getAddress() + ", Telephone Number: " + getTelephoneNumber() + ",\n"
				+ "Goods purchased: " + goods + ",\nThe customer has spent \u00a3" + valueOfGoods() + ".";
	}
	
}
