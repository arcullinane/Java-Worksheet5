import java.math.BigInteger;
import java.util.Random;

/**
 * Class to generate large prime numbers and the required keys for the RSA algorithm 
 * @author andrew cullinane
 */
public class Key {
	
	//static variables
	private static Random r = new Random();
	private static final int BITLENGTH = 1024;
	
	//field variables
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger lambda;
	private BigInteger e;
	private BigInteger d;
	
	/**
	 * Constructor for the Key class
	 * Requires no arguments.
	 * Generates all other variables by calculation from p and q, 
	 * which are random large prime numbers.
	 */
	public Key() {
		this.p = BigInteger.probablePrime(BITLENGTH, r);
		//this.p = new BigInteger(String.valueOf(99991));
		this.q = BigInteger.probablePrime(BITLENGTH, r);
		//this.q = new BigInteger(String.valueOf(8999));
		this.n = p.multiply(q);
		this.lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		this.e = calculateE();
		//this.e = new BigInteger(String.valueOf(14983));
		this.d = e.modInverse(lambda);
	}
	
	/**
	 * Method to calculate the number e, a prime number that does not divide lambda
	 * @return a BigInteger for e
	 */
	public BigInteger calculateE() {
		//Generate a smaller random prime number for e
		e = BigInteger.probablePrime(BITLENGTH / 2, r);
		//while the greatest common denominator of lambda and e is greater than 1, and e is less than lambda
		//add 1 to e
		while (lambda.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(lambda) < 0) {
			e.add(BigInteger.ONE);
		}
		return e;
	}
	
	/**
	 * Getter method to get n (p*q)
	 * @return BigInteger n
	 */
	public BigInteger getN() {
		return n;
	}
	
	/**
	 * Getter method to get e
	 * @return BigInteger e
	 */
	public BigInteger getE() {
		return e;
	}
	
	/**
	 * Getter method to get d
	 * @return BigInteger d
	 */
	public BigInteger getD() {
		return d;
	}
	
}
