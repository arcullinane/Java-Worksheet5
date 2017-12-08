import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for Chess Class
 * @author andrew cullinane
 */

public class Ex4Test {

	@Rule 
	public final ExpectedException exception = ExpectedException.none();
	
	//set up chess board
	Chess test = new Chess();
	
	//test toString method
	@Test
	public void test1() {
		String expected = "	     a      b       c       d       e       f       g       h\n" + 
							"\t|---------------------------------------------------------------|\n" + 
							"8\t| rook\t| knight	| bishop	| queen	| king	| bishop	| knight	| rook	| 	8\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"7	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| 	7\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"6	| 	| 	| 	| 	| 	| 	| 	| 	| 	6\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"5	| 	| 	| 	| 	| 	| 	| 	| 	| 	5\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"4	| 	| 	| 	| 	| 	| 	| 	| 	| 	4\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"3	| 	| 	| 	| 	| 	| 	| 	| 	| 	3\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"2	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| 	2\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"1	| ROOK	| KNIGHT	| BISHOP	| QUEEN	| KING	| BISHOP	| KNIGHT	| ROOK	| 	1\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"	     a      b       c       d       e       f       g       h";
		String actual = test.toString();
		assertEquals(expected, actual);
	}

	//test getInput method
	@Test
	public void test2() {
		//give input to console
		String input = "a2a4";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		char[] expected = {'a','2','a','4'};
		char[] actual = test.getInput();
		assertArrayEquals(expected, actual);
	}
	
	//test convertToArrayPosition method
	@Test
	public void test3() {
		char [] input = {'a','2','a','4'};
		int[] expected = {6,0,4,0};
		int [] actual = test.convertToArrayPosition(input);
		assertArrayEquals(expected, actual);
	}

	//test updateBoard method
	@Test
	public void test4() {
		int[] move = {6,0,4,0};
		test.updateBoard(move);
		String expected = "	     a      b       c       d       e       f       g       h\n" + 
							"\t|---------------------------------------------------------------|\n" + 
							"8\t| rook\t| knight	| bishop	| queen	| king	| bishop	| knight	| rook	| 	8\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"7	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| pawn	| 	7\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"6	| 	| 	| 	| 	| 	| 	| 	| 	| 	6\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"5	| 	| 	| 	| 	| 	| 	| 	| 	| 	5\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"4	| PAWN	| 	| 	| 	| 	| 	| 	| 	| 	4\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"3	| 	| 	| 	| 	| 	| 	| 	| 	| 	3\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"2	| 	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| PAWN	| 	2\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"1	| ROOK	| KNIGHT	| BISHOP	| QUEEN	| KING	| BISHOP	| KNIGHT	| ROOK	| 	1\n" + 
							"	|---------------------------------------------------------------|\n" + 
							"	     a      b       c       d       e       f       g       h";
		String actual = test.toString();
		assertEquals(expected, actual);
	}
	
	//test invalid input
	@Test
	public void test5() {
		//give invalid input
		String input = "2a4a";
		System.setIn(new ByteArrayInputStream(input.getBytes()));	
		
		//get console text
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		//try move
		test.getInput();
		
		//tests if console displays expected message
		String expected = "Please enter your move.\nInvalid Input. ";
		assertEquals(expected, outContent.toString());
	}
	
	//test if no move entered
	@Test
	public void test6() {

		//give no input
		String input = "";
		System.setIn(new ByteArrayInputStream(input.getBytes()));	
		
		//test for exception to be thrown
		exception.expect(NoSuchElementException.class);
		test.getInput();
		
	}
	
}
