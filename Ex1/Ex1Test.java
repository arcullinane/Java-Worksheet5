import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests for exercise 1
 * @author andrew cullinane
 */

public class Ex1Test {
	//create Good items
	Good good1 = new Good("Paper", 30);
	Good good2 = new Good("Pens", 50);
	Good good3 = new Good("Pencils", 20);
	Good good4 = new Good("Rulers", 60);
	Good good5 = new Good("Erasers", 100);
	Good good6 = new Good("Markers", 40);
	
	//Create array lists of Goods
	ArrayList<Good> list1 = new ArrayList<Good>();
	ArrayList<Good> list2 = new ArrayList<Good>();
	ArrayList<Good> list3 = new ArrayList<Good>();
	ArrayList<Good> list4 = new ArrayList<Good>();
	
	//Create customers with goods
	CustomerWithGoods person1 = new CustomerWithGoods("Tom", "20 Oak Road", "01234 567890", list1);
	CustomerWithGoods person2 = new CustomerWithGoods("Simon", "50 Bristol Road", "07123 456789", list2);
	CustomerWithGoods person3 = new CustomerWithGoods("Mark", "10 Hagley Road", "0121 123 4567", list3);
	CustomerWithGoods person4 = new CustomerWithGoods("Joe", "40 High Street", "07098 765432", list4);
	
	//Create a customer base
	CustomerBase base1 = new CustomerBase(person1);
	
	//tests for Customer class
	@Test
	public void test1() {
		//getName method
		String nameExpected = "Tom";
		String nameActual = person1.getCustomerName();
		assertEquals(nameExpected, nameActual);
		
		//getCustomerName method
		String addressExpected = "20 Oak Road";
		String addressActual = person1.getAddress();
		assertEquals(addressExpected, addressActual);
		
		//getTelephoneNumber method
		String telephoneNumberExpected = "01234 567890";
		String telephoneNumberActual = person1.getTelephoneNumber();
		assertEquals(telephoneNumberExpected, telephoneNumberActual);
	}

	//tests for Good class
	@Test
	public void test2() {
		//getPrice method
		int priceExpected = 30;
		int priceActual = good1.getPrice();
		assertEquals(priceExpected, priceActual);
		
		//toString method
		String toStringExpected = "Name: Pens, Price: \u00A350.";
		String toStringActual = good2.toString();
		assertEquals(toStringExpected, toStringActual);
	}
	
	//tests for CustomerWithGoods class
	@Test
	public void test3() {
		
		list1.add(good1);
		list1.add(good2);
		
		//getGoods method
		ArrayList<Good> expected = new ArrayList<Good>();
		expected.add(good1);
		expected.add(good2);
		ArrayList<Good> actual1 = person1.getGoods();
		assertEquals(expected, actual1);
		
		//buyGoods method
		expected.add(good3);
		person1.buy(good3);
		ArrayList<Good> actual2 = person1.getGoods();
		assertEquals(expected, actual2);
		
		//valueOfGoods method
		int totalExpected = 100;
		int totalActual = person1.valueOfGoods();
		assertEquals(totalExpected, totalActual);
		
		//toString method
		String stringExpected = "Customer: Tom, Address: 20 Oak Road, Telephone Number: 01234 567890,\n" + 
								"Goods purchased: [Name: Paper, Price: £30., Name: Pens, Price: £50., Name: Pencils, Price: £20.],\n" + 
								"The customer has spent £100.";
		String stringActual = person1.toString();
		assertEquals(stringExpected, stringActual);
	}

	//test for CustomerBase (addCustomer method)
	@Test
	public void test4() {
		String stringExpected = "Customer: Tom, Address: 20 Oak Road, Telephone Number: 01234 567890,\n" + 
								"Goods purchased: [],\n" + 
								"The customer has spent £0.Customer: Simon, Address: 50 Bristol Road, Telephone Number: 07123 456789,\n" + 
								"Goods purchased: [],\n" + 
								"The customer has spent £0.";
		base1.addCustomer(person2);
		String stringActual = base1.toString();
		assertEquals(stringExpected, stringActual);
	}
	
	//test for CustomerBase (filterLoyal method)
	@Test
	public void test5() {
		base1.addCustomer(person2);
		base1.addCustomer(person3);
		base1.addCustomer(person4);
		person1.buy(good1);
		person1.buy(good2);
		person1.buy(good3);
		person2.buy(good2);
		person2.buy(good3);
		person3.buy(good1);
		person3.buy(good2);
		person3.buy(good3);
		person3.buy(good4);
		person4.buy(good2);
		person4.buy(good4);
		person4.buy(good5);
		String expected = "[Customer: Tom, Address: 20 Oak Road, Telephone Number: 01234 567890,\n" + 
							"Goods purchased: [Name: Paper, Price: £30., Name: Pens, Price: £50., Name: Pencils, Price: £20.],\n" + 
							"The customer has spent £100., Customer: Mark, Address: 10 Hagley Road, Telephone Number: 0121 123 4567,\n" + 
							"Goods purchased: [Name: Paper, Price: £30., Name: Pens, Price: £50., Name: Pencils, Price: £20., Name: Rulers, Price: £60.],\n" + 
							"The customer has spent £160., Customer: Joe, Address: 40 High Street, Telephone Number: 07098 765432,\n" + 
							"Goods purchased: [Name: Pens, Price: £50., Name: Rulers, Price: £60., Name: Erasers, Price: £100.],\n" + 
							"The customer has spent £210.]";
		String actual = base1.filterLoyal().toString();
		assertEquals(expected, actual);
	}
	
	//test for CustomerBase (filterValued method)
	@Test
	public void test6() {
		base1.addCustomer(person2);
		base1.addCustomer(person3);
		base1.addCustomer(person4);
		person1.buy(good1);
		person1.buy(good2);
		person1.buy(good3);
		person2.buy(good2);
		person2.buy(good3);
		person3.buy(good1);
		person3.buy(good2);
		person3.buy(good3);
		person3.buy(good4);
		person4.buy(good2);
		person4.buy(good4);
		person4.buy(good5);
		String expected = "[Customer: Mark, Address: 10 Hagley Road, Telephone Number: 0121 123 4567,\n" + 
							"Goods purchased: [Name: Paper, Price: £30., Name: Pens, Price: £50., Name: Pencils, Price: £20., Name: Rulers, Price: £60.],\n" + 
							"The customer has spent £160., Customer: Joe, Address: 40 High Street, Telephone Number: 07098 765432,\n" + 
							"Goods purchased: [Name: Pens, Price: £50., Name: Rulers, Price: £60., Name: Erasers, Price: £100.],\n" + 
							"The customer has spent £210.]";
		String actual = base1.filterValued().toString();
		assertEquals(expected, actual);
	}
	
}
