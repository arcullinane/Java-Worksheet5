import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Interactive program for chess board
 * @author andrewc ullinane
 */

public class Chess {

	/**
	 * Starting String array for chess board pieces
	 */
	private String[][] chessBoard = { { "rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook" },
									{ "pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn", "pawn" }, 
									{ "", "", "", "", "", "", "", "" },
									{ "", "", "", "", "", "", "", "" }, 
									{ "", "", "", "", "", "", "", "" }, 
									{ "", "", "", "", "", "", "", "" },
									{ "PAWN", "PAWN", "PAWN", "PAWN", "PAWN", "PAWN", "PAWN", "PAWN" },
									{ "ROOK", "KNIGHT", "BISHOP", "QUEEN", "KING", "BISHOP", "KNIGHT", "ROOK" } };

	/**
	 * Method to convert array to String output
	 * @return String of chess board
	 */
	public String toString() {
		String outputText = "\t     a      b       c       d       e       f       g       h\n"
				+ "\t|---------------------------------------------------------------|\n";
		for (int i = 0; i < chessBoard.length; i++) {
			outputText += (8 - i) + "\t| ";
			for (int j = 0; j < chessBoard[i].length; j++) {
				outputText += chessBoard[i][j] + "\t| ";
			}
			outputText += "\t" + (8 - i) + "\n\t|"
					+ "---------------------------------------------------------------|\n";
		}
		outputText += "\t     a      b       c       d       e       f       g       h";
		return outputText;
	}

	/**
	 * Method to read the console input
	 * Tests for correct input
	 * Pressing 'q' quits the program
	 * @return char array of input text
	 */
	public char[] getInput() {
		//set up pattern and matcher for correct input (p)
		System.out.println("Please enter your move.");
		Scanner input = new Scanner(System.in);
		String inputText = input.nextLine();
		Pattern p = Pattern.compile("[a-h][1-8][a-h][1-8]");
		Matcher mp = p.matcher(inputText);
		
		//check for which input is given
		char[] characters = new char[4];
		//correct
		if (mp.find()) {
			characters = inputText.toCharArray();
		//quit
		} else if (inputText.equals("q")) {
			input.close();
			System.out.println("Thanks for playing!");
			System.exit(0);
		//invalid
		} else {
			System.out.print("Invalid Input. ");
		}
		return characters;
	}

	/**
	 * method to convert char[] to int[] for move
	 * @param a as char array from getInput method
	 * @return int[] for changing position of piece on board
	 */
	public int[] convertToArrayPosition(char[] a) {

		int[] position = new int[4];

		int fromRow = 8 - (a[1] - 48);
		int fromColumn = (int) a[0] - 97;
		int toRow = 8 - (a[3] - 48);
		int toColumn = (int) a[2] - 97;

		position[0] = fromRow;
		position[1] = fromColumn;
		position[2] = toRow;
		position[3] = toColumn;

		return position;
	}

	/**
	 * method to update chess board double array
	 * checks if there is a piece to move in the specified location
	 * @param a as int[] from convertToArrayPosition method
	 */
	public void updateBoard(int[] a) {

		//nothing to move
		if (chessBoard[a[0]][a[1]].equals("")) {
			System.out.println("There is nothing to move form this location. Please try again.");
		//move piece
		} else {
			chessBoard[a[2]][a[3]] = chessBoard[a[0]][a[1]];
			chessBoard[a[0]][a[1]] = "";
		}
	}
	
}
