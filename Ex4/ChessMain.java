
public class ChessMain {

	public static void main(String[] args) {
	
		// create game
		Chess test = new Chess();
		// show board at beginning
		System.out.println(test.toString());
		// game loop (pressing q will close the program)
		while (true) {
			try {
				char[] input = test.getInput();
				int[] moveArray = test.convertToArrayPosition(input);
				test.updateBoard(moveArray);
				System.out.println(test.toString());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please try again.");
			}
		}

	}

}
