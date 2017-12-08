import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * Tests for Var and BuildClass classes
 * @author andrew cullinane
 */
public class Ex2Test {

	//Create variables
	Var variable1 = new Var("String", "name");
	Var variable2 = new Var("String", "address");
	Var variable3 = new Var("int", "money");
	//Create array list of Vars
	ArrayList<Var> fields = new ArrayList<Var>();
	//Creat BuildClass class
	BuildClass class1 = new BuildClass("BankAccount", fields);
	
	//test Var class methods
	@Test
	public void test1() {

		//getTypeOfVar method
		String typeExpected = "String";
		String typeActual = variable1.getTypeOfVar();
		assertEquals(typeExpected, typeActual);
		
		//getNameOfVar method
		String nameExpected = "name";
		String nameActual = variable1.getNameOfVar();
		assertEquals(nameExpected, nameActual);
	}

	//test makeFields method
	@Test
	public void test2() {
		//add variables to fields array list
		fields.add(variable1);
		fields.add(variable2);
		fields.add(variable3);
		
		String fieldsExpected = "\tprivate String name;\n" + 
								"\tprivate String address;\n" + 
								"\tprivate int money;\n";
		String fieldsActual = class1.makeFields();
		assertEquals(fieldsExpected, fieldsActual);
				
	}
	//test for makeConstructor method
	@Test
	public void test3() {
		//add variables to fields array list
		fields.add(variable1);
		fields.add(variable2);
		fields.add(variable3);
		
		String constructorExpected = "\n" + 
									"\tpublic BankAccount(String name, String address, int money) {\n" + 
									"\t\tthis.name = name;\n" + 
									"\t\tthis.address = address;\n" + 
									"\t\tthis.money = money;\n" + 
									"\t}\n" + 
									"\n" + 
									"";
		String constructorActual = class1.makeConstructor();
		assertEquals(constructorExpected, constructorActual);
	}
	
	//test makeGetters method
	@Test
	public void test4() {
		//add variables to fields array list
		fields.add(variable1);
		fields.add(variable2);
		fields.add(variable3);
		
		String gettersExpected = "\tpublic String getName() {\n" + 
								"\t\treturn name;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic String getAddress() {\n" + 
								"\t\treturn address;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic int getMoney() {\n" + 
								"\t\treturn money;\n" + 
								"\t}\n" + 
								"\n" + 
								"";
		String gettersActual = class1.makeGetters();
		assertEquals(gettersExpected, gettersActual);
	}
	
	//test makeSetters method
	@Test
	public void test5() {
		//add variables to fields array list
		fields.add(variable1);
		fields.add(variable2);
		fields.add(variable3);
		
		String settersExpected = "\tpublic void setName(String name) {\n" + 
								"\t\tthis.name = name;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic void setAddress(String address) {\n" + 
								"\t\tthis.address = address;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic void setMoney(int money) {\n" + 
								"\t\tthis.money = money;\n" + 
								"\t}\n" + 
								"\n" + 
								"";
		String settersActual = class1.makeSetters();
		assertEquals(settersExpected, settersActual);
	}
	
	//test buildClass method
	@Test
	public void test6() {
		//add variables to fields array list
		fields.add(variable1);
		fields.add(variable2);
		fields.add(variable3);
		
		String classExpected = 	"public class BankAccount {\n" + 
								"\n" + 
								"\tprivate String name;\n" + 
								"\tprivate String address;\n" + 
								"\tprivate int money;\n" + 
								"\n" + 
								"\tpublic BankAccount(String name, String address, int money) {\n" + 
								"\t\tthis.name = name;\n" + 
								"\t\tthis.address = address;\n" + 
								"\t\tthis.money = money;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic String getName() {\n" + 
								"\t\treturn name;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic String getAddress() {\n" + 
								"\t\treturn address;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic int getMoney() {\n" + 
								"\t\treturn money;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic void setName(String name) {\n" + 
								"\t\tthis.name = name;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic void setAddress(String address) {\n" + 
								"\t\tthis.address = address;\n" + 
								"\t}\n" + 
								"\n" + 
								"\tpublic void setMoney(int money) {\n" + 
								"\t\tthis.money = money;\n" + 
								"\t}\n" + 
								"\n" + 
								"}";
		String classActual = class1.buildClass();
		assertEquals(classExpected, classActual);
	}
	
}
