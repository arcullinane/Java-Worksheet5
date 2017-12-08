import java.math.BigInteger;

public class RSAMain {

	public static void main(String[] args) {

		//Create Key class object and get needed variables
		Key test = new Key();
		BigInteger n = test.getN();
		BigInteger e = test.getE();
		BigInteger d = test.getD();
		
		//Encryption
		int numberToEncrypt = 65;											// <- can be changed
		try {
			Encryption test1 = new Encryption(numberToEncrypt, n, e);
			BigInteger encrypted = test1.encrypt();
			System.out.println("The number to be encrypted is " + numberToEncrypt);
			System.out.println("Encrypted number is " + encrypted);	
		} catch (IllegalArgumentException a) {
			System.out.println("Plain number should be greater than 1");
		}

		//Decryption
		try {
			//encrypt first
			Encryption test2e = new Encryption(numberToEncrypt, n, e);
			BigInteger encrypted = test2e.encrypt();
			//then decrypt
			BigInteger numberToDecrypt = encrypted; 						// <- can be changed to
			Decryption test2d = new Decryption(numberToDecrypt, d, n);
			BigInteger decrypted = test2d.decrypt();
			System.out.println("The decrypted number is " + decrypted);
		} catch (IllegalArgumentException a) {
			;
		}
		
	}

}
