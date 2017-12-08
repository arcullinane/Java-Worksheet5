import java.util.ArrayList;

/**
 * Program to construct a class given the className and the fields required.
 * @author andrew cullinane
 */

public class BuildClass {

	//field variables
	private String className;
	private ArrayList<Var> fields = new ArrayList<Var>();

	/**
	 * Constructor for BuildClass class
	 * @param className as String
	 * @param fields as an array list of fields
	 */
	public BuildClass(String className, ArrayList<Var> fields) {
		this.className = className;
		this.fields = fields;
	}

	/**
	 * makeFields method to create text output of the field variables
	 * @return String of field variables
	 */
	public String makeFields() {

		String fieldsString = "";
		for (Var field : fields) {
			fieldsString += "\tprivate " + field.getTypeOfVar() + " " + field.getNameOfVar() + ";\n";
		}

		return fieldsString;
	}

	/**
	 * method to make the constructor for the class
	 * @return String of the constructor text
	 */
	public String makeConstructor() {

		//start
		String constructorString1 = "\n\tpublic " + className + "(";
		String constructorString2 = "";

		//fields within the () minus 1
		for (int i = 0; i < fields.size() - 1; i++) {
			constructorString1 += fields.get(i).getTypeOfVar() + " " + fields.get(i).getNameOfVar() + ", ";
			constructorString2 += "\t\tthis." + fields.get(i).getNameOfVar() + " = " + fields.get(i).getNameOfVar()
					+ ";\n";
		}
		//add last field
		constructorString1 += fields.get(fields.size() - 1).getTypeOfVar() + " "
				+ fields.get(fields.size() - 1).getNameOfVar() + ") {\n";
		constructorString2 += "\t\tthis." + fields.get(fields.size() - 1).getNameOfVar() + " = "
				+ fields.get(fields.size() - 1).getNameOfVar() + ";\n";
		//add together and add "}"
		return constructorString1 + constructorString2 + "\t}\n\n";
	}

	/**
	 * method to create the Getters for each variable
	 * @return String for each getter required
	 */
	public String makeGetters() {

		String getterString = "";
		for (Var field : fields) {
			//makes first letter upper case
			String capitalField = field.getNameOfVar().substring(0, 1).toUpperCase()
					+ field.getNameOfVar().substring(1);
			//makes getters
			getterString += "\tpublic " + field.getTypeOfVar() + " get" + capitalField + "() {\n\t\treturn "
					+ field.getNameOfVar() + ";\n\t}\n\n";
		}

		return getterString;
	}

	/**
	 * method to create Setters for each variable
	 * @return String for each setter required
	 */
	public String makeSetters() {

		String setterString = "";
		for (Var field : fields) {
			//makes first letter upper case
			String capitalField = field.getNameOfVar().substring(0, 1).toUpperCase()
					+ field.getNameOfVar().substring(1);
			//make setters
			setterString += "\tpublic void set" + capitalField + "(" + field.getTypeOfVar() + " " + field.getNameOfVar()
					+ ") {\n\t\tthis." + field.getNameOfVar() + " = " + field.getNameOfVar() + ";\n\t}\n\n";
		}

		return setterString;
	}

	/**
	 * method to build a complete class
	 * @return String of complete class given
	 */
	public String buildClass() {

		return "public class " + className + " {\n\n" + makeFields() + makeConstructor() + makeGetters() + makeSetters()
				+ "}";

	}

}
