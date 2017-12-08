/**
 * Class to create array lists of fields required for class to be constructed
 * @author andrew cullinane
 */
public class Var {

	//field variables
	private String typeOfVar;
	private String nameOfVar;
	
	/**
	 * Constructor for Var class
	 * @param typeOfVar as String
	 * @param nameOfVar as String
	 */
	public Var (String typeOfVar, String nameOfVar) {
		this.typeOfVar = typeOfVar;
		this.nameOfVar = nameOfVar;
	}

	/**
	 * Getter method for typeOfVar
	 * @return String of the typeOfVar
	 */
	public String getTypeOfVar() {
		return typeOfVar;
	}

	/**
	 * Getter method for nameOfVar
	 * @return String of nameOfVar
	 */
	public String getNameOfVar() {
		return nameOfVar;
	}
	
}
