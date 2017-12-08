import java.util.ArrayList;

/**
 * Class to store all customers in one array list along with all their orders.
 * @author andrew cullinane
 */
public class CustomerBase {

	//field variable
	private ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();

	/**
	 * Constructor adds CustomerWithGoods to the array list
	 * @param customer as CustomerWithGoods
	 */
	public CustomerBase(CustomerWithGoods customer) {
		allCustomers.add(customer);
	}

	/**
	 * method to add customer to array list
	 * @param customer as CustomerWithGoods
	 */
	public void addCustomer(CustomerWithGoods customer) {
		allCustomers.add(customer);
	}

	/**
	 * toString method to output customers
	 * @return String of all customers
	 */
	public String toString(){
		String output = "";
		for (CustomerWithGoods customer : allCustomers) {
			output+= customer;
		}
		return output;
	}
	
	/**
	 * method to filter loyal customers by the number of orders. 
	 * If a customer's number of orders is greater than the mean, 
	 * they will be added to loyal arrayList.
	 * @return an arrayList of loyal customers.
	 */
	public ArrayList<CustomerWithGoods> filterLoyal() {

		//calculate the mean number of orders
		int customerCount = 0;
		int itemCount = 0;

		for (CustomerWithGoods customer : allCustomers) {
			for (@SuppressWarnings("unused") Good item : customer.goods) {
				itemCount++;
			}
			customerCount++;
		}

		double meanItems = (double) itemCount / (double) customerCount;
		
		//make an array of loyal customers
		ArrayList<CustomerWithGoods> loyal = new ArrayList<CustomerWithGoods>();
		int currentCount = 0;

		for (CustomerWithGoods customer : allCustomers) {
			for (@SuppressWarnings("unused") Good item : customer.goods) {
				currentCount++;
			}
			if (currentCount >= meanItems) {
				loyal.add(customer);
			}
			currentCount = 0;
		}

		return loyal;
	}

	/**
	 * method to filter valued customers by the amount of the orders. 
	 * If a customer's total spend is greater than the mean, 
	 * they will be added to valued array List.
	 * @return an arrayList of valued customers.
	 */
	public ArrayList<CustomerWithGoods> filterValued() {

		//calculate the mean total spend
		int sumPrice = 0;
		int counter = 0;

		for (CustomerWithGoods customer : allCustomers) {
			sumPrice += customer.valueOfGoods();
			counter++;
		}

		double meanValue = (double) sumPrice / (double) counter;
		
		//makes an array list of valued customers
		ArrayList<CustomerWithGoods> valued = new ArrayList<CustomerWithGoods>();

		for (CustomerWithGoods customer : allCustomers) {
			if (customer.valueOfGoods() >= meanValue) {
				valued.add(customer);
			}
		}

		return valued;

	}

}
