import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for Key, Encryption, and Decryption Classes
 * @author andrew cullinane
 */

public class Ex5Test {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	// test 2 keys to make sure they aren't the same
	@Test
	public void test1() {
		// set up keys
		Key testKey1a = new Key();
		Key testKey1b = new Key();

		// getN method
		assertFalse(testKey1a.getN() == testKey1b.getN());
		// getE method
		assertFalse(testKey1a.getE() == testKey1b.getE());
		// getD method
		assertFalse(testKey1a.getD() == testKey1b.getD());
	}

	// test plain number is not the same as encrypted number
	@Test
	public void test2() {
		// set up Key
		Key testKey2 = new Key();
		BigInteger n = testKey2.getN();
		BigInteger e = testKey2.getE();

		// encrypt plain number
		int numberToEncrypt = 65;
		BigInteger plainNumber = new BigInteger(String.valueOf(numberToEncrypt));
		Encryption test2 = new Encryption(numberToEncrypt, n, e);
		BigInteger encrypted = test2.encrypt();

		// ensures plain number is not the same as encrypted number
		assertFalse(plainNumber == encrypted);
	}

	// test encrypted number is not the same as decrypted number
	@Test
	public void test3() {
		// set up key
		Key testKey3 = new Key();
		BigInteger n = testKey3.getN();
		BigInteger e = testKey3.getE();
		BigInteger d = testKey3.getD();

		// encryption
		int numberToEncrypt = 100;
		Encryption test3e = new Encryption(numberToEncrypt, n, e);
		BigInteger encrypted = test3e.encrypt();

		// decryption
		Decryption test3d = new Decryption(encrypted, d, n);
		BigInteger decrypted = test3d.decrypt();

		assertFalse(encrypted == decrypted);
	}

	// test that encryption and decryption methods work together to give the same plain number
	@Test
	public void test4() {
		// set up key
		Key testKey4 = new Key();
		BigInteger n = testKey4.getN();
		BigInteger e = testKey4.getE();
		BigInteger d = testKey4.getD();

		// encryption
		int numberToEncrypt = 50;
		BigInteger plainNumber = new BigInteger(String.valueOf(numberToEncrypt));
		Encryption test4e = new Encryption(numberToEncrypt, n, e);
		BigInteger encrypted = test4e.encrypt();

		// decryption
		Decryption test4d = new Decryption(encrypted, d, n);
		BigInteger decrypted = test4d.decrypt();

		assertEquals(plainNumber, decrypted);
	}

	// test maximum integer value to be encrypted and then decrypted
	@Test
	public void test5() {
		// set up key
		Key testKey5 = new Key();
		BigInteger n = testKey5.getN();
		BigInteger e = testKey5.getE();
		BigInteger d = testKey5.getD();

		// encryption
		int numberToEncrypt = Integer.MAX_VALUE;
		BigInteger plainNumber = new BigInteger(String.valueOf(numberToEncrypt));
		Encryption test5e = new Encryption(numberToEncrypt, n, e);
		BigInteger encrypted = test5e.encrypt();

		// decryption
		Decryption test5d = new Decryption(encrypted, d, n);
		BigInteger decrypted = test5d.decrypt();

		assertEquals(plainNumber, decrypted);

	}

	// test exception for negative plain number
	@Test
	public void test6() {
		// set up key
		Key testKey6 = new Key();
		BigInteger n = testKey6.getN();
		BigInteger e = testKey6.getE();

		int numberToEncrypt = -2;
		exception.expect(IllegalArgumentException.class);
		Encryption test6e = new Encryption(numberToEncrypt, n, e);
		test6e.encrypt();
	}

}
