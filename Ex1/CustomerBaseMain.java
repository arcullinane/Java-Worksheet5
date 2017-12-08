import java.util.ArrayList;

public class CustomerBaseMain {

	public static void main(String[] args) {
		//create goods to be purchased
		Good good1 = new Good("Paper", 30);
		Good good2 = new Good("Pens", 50);
		Good good3 = new Good("Pencils", 20);
		Good good4 = new Good("Rulers", 60);
		//make array lists of goods
		ArrayList<Good> list1 = new ArrayList<Good>();
		list1.add(good1);
		list1.add(good2);
		list1.add(good3);
		ArrayList<Good> list2 = new ArrayList<Good>();
		list2.add(good2);
		list2.add(good3);
		ArrayList<Good> list3 = new ArrayList<Good>();
		list3.add(good1);
		list3.add(good2);
		list3.add(good3);
		list3.add(good4);
		//Create customers with goods
		CustomerWithGoods person1 = new CustomerWithGoods("Tom", "20 Oak Road", "01234 567890", list1);
		CustomerWithGoods person2 = new CustomerWithGoods("Simon", "50 Bristol Road", "07123 456789", list2);
		CustomerWithGoods person3 = new CustomerWithGoods("Mark", "10 Hagley Road", "0121 123 4567", list3);
		//Create a customer base
		CustomerBase base1 = new CustomerBase(person1);
		base1.addCustomer(person2);
		base1.addCustomer(person3);
		//Output to console
		System.out.println(base1);
	}

}
