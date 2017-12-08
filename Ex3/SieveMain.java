
public class SieveMain{

	public static void main(String[] args) {
		
		int n = 0; 										//<- change this number
		
		if (n == 1) {
			System.out.println("No prime numbers in range given.");
		} else {
			try {
				int[] test = Sieve.sieve(n);
				String output = "";
				for (int prime : test) {
					output+=prime + " ";
				}
				System.out.println(output);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter a number greater than zero.");
			} catch (NegativeArraySizeException e) {
				System.out.println("Please enter a number greater than zero.");
			}
		}
		
	}

}
