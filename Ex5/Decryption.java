import java.math.BigInteger;

/**
 * Class to decrypt an encrypted number using the RSA algorithm
 * @author andrew cullinane
 */
public class Decryption {
	
	//field variables
	private BigInteger encryptedNumber;
	private BigInteger d;
	private BigInteger n;
	
	/**
	 * Constructor for the Decryption class
	 * @param encryptedNumber as BigInteger to be decrypted
	 * @param d given as a BigInteger from the Key class
	 * @param n given as a BigInteger (p*q) from the Key class
	 */
	public Decryption(BigInteger encryptedNumber, BigInteger d, BigInteger n) {
		this.encryptedNumber = encryptedNumber;
		this.d = d;
		this.n= n;
	}
	
	/**
	 * Method to decrypt encrypted number
	 * @return a BigInteger of the decrypted number
	 */
	public BigInteger decrypt() {
		return encryptedNumber.modPow(d, n);
	}

}
