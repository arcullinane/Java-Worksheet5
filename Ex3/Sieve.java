/**
 * Program to give all prime numbers up to and including a given integer
 * @author andrew cullinane
 */

public class Sieve {

	/**
	 * method to return all prime numbers up to and including a given integer
	 * @param n given as an int is maximum value to be checked
	 * @return int[] of prime numbers
	 */
	public static int[] sieve(int n) {

		// make an array of all numbers to n
		int[] allNums = new int[n+1];
		for (int i = 0; i <= n; i++) {
			allNums[i] = i;
		}
		
		// make a boolean array
		boolean[] sieve = new boolean[n+1];
		sieve[0] = false;
		sieve[1] = false;
		for (int i = 2; i <= n; i++) {
			sieve[i] = true;
		}
		
		// find out which values are prime
		double sqrtN = Math.sqrt(n);
		for (int i = 2; i < sqrtN; i++) {
			for (int j = i+1; j < allNums.length; j++) {
				if (allNums[j] % allNums[i] == 0) {
					sieve[j] = false;
				}
			}
		}
		
		// calculate number of primes
		int numTrue = 0;
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i]) {
				numTrue++;
			}
		}
		
		// make new array with primes
		int[] primeNums = new int[numTrue];
		int newArrayPosition = 0;
		for (int i= 0; i < sieve.length; i++) {
			if (sieve[i]) {
				primeNums[newArrayPosition] = i;
				newArrayPosition++;
			}
		}
		return primeNums;
	}

}
