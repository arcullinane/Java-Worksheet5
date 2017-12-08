import java.math.BigInteger;

/**
 * Class to encrypt a plain number using the RSA algorithm
 * @author andrew cullinane
 */

public class Encryption {

	//field variables
	private int plainNumber;
	private BigInteger n;
	private BigInteger e;

	/**
	 * Constructor for the Encryption class
	 * @param plainNumber given as int
	 * @param n given as a BigInteger (p*q) from the Key class
	 * @param e given as a BigInteger from the Key class
	 * @throws IllegalArgumentException if plain number is less than 2, caught in main method.
	 */
	public Encryption(int plainNumber, BigInteger n, BigInteger e) {
		if (plainNumber < 2) {
			throw new IllegalArgumentException();
		} else {
			this.plainNumber = plainNumber;
		}
		
		this.n = n;
		this.e = e;
	}
		
	/**
	 * Encryption method
	 * Converts integer to BigInteger, then calculates plainNumber ^ e % n
	 * @return encrypted number as BigInteger
	 */
	public BigInteger encrypt() {
		
		BigInteger bigPlainNumber = new BigInteger(String.valueOf(plainNumber));
		return bigPlainNumber.modPow(e, n);
		
	}
	
}