import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for Sieve Class
 * @author andrew cullinane
 */

public class Ex3Test {

	@Rule 
	public final ExpectedException exception = ExpectedException.none();
	
	//Primes up to 50.
	@Test
	public void test1() {
		
		int[] expected = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
		int[] actual = Sieve.sieve(50);
		assertArrayEquals(expected, actual);
	}

	//Test includes up to n
	@Test
	public void test2() {
		int[] expected = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
		int[] actual = Sieve.sieve(47);
		assertArrayEquals(expected, actual);
		
	}
	
	//Test larger number of n
	@Test
	public void test3() {
		int[] expected = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,
								101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,
								211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,
								307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,
								401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,
								503,509,521,523,541,547,557,563,569,571,577,587,593,599,
								601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,
								701,709,719,727,733,739,743,751,757,761,769,773,787,797,
								809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,
								907,911,919,929,937,941,947,953,967,971,977,983,991,997};
		int [] actual = Sieve.sieve(1000);
		assertArrayEquals(expected, actual);
	}
	
	//test 1 for n
	@Test
	public void test4() {
		int[] expected = new int[0];
		int[] actual = Sieve.sieve(1);
		assertArrayEquals(expected, actual);
	}
	
	//test 0 for n
	@Test
	public void test5() {
		exception.expect(ArrayIndexOutOfBoundsException.class);
		Sieve.sieve(0);	
	}
	
	//Test negative number for n
	@Test
	public void test6() {
		exception.expect(NegativeArraySizeException.class);
		Sieve.sieve(-50);	
	}
		
}
