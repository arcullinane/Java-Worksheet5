import java.util.ArrayList;

public class BuildClassMain {

	public static void main(String[] args) {
		//Create Var
		Var testVar1 = new Var("String", "name");
		Var testVar2 = new Var("String", "address");
		Var testVar3 = new Var("int", "money");
		//Create array list of Var
		ArrayList<Var> fieldsTest = new ArrayList<Var>();
		fieldsTest.add(testVar1);
		fieldsTest.add(testVar2);
		fieldsTest.add(testVar3);
		
		//Create BuildClass class
		BuildClass class1 = new BuildClass("BankAccount", fieldsTest);
		
		//Strings 
		//String fields = class1.makeFields();
		//String constructor = class1.makeConstructor();
		//String getters = class1.makeGetters();
		//String setters = class1.makeSetters();
		String fullClass = class1.buildClass();
		
		System.out.println(fullClass);
	}

}
