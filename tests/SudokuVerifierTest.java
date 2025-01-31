import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.

	// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String gc = "123456789456789123789123456231564897564897231897231564312645978645978312978312645";
	SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(gc);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);

	}

	@Test
	public void testShortInput() {
		String a = "123456789";
		int result = v.verify(a);
		assertEquals("correct string", result, -1);
	}

	@Test
	public void testEmptyInput() {
		String a = "";
		int result = v.verify(a);
		assertEquals("empty string", result, -1);
	}

	@Test
	public void testOneNumberInput() {
		String a = "1";
		int result = v.verify(a);
		assertEquals("one number string", result, -1);
	}

	@Test
	public void testTooLongInput() {
		String a = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931";
		int result = v.verify(a);
		assertEquals("long string", result, -1);
	}

	@Test
	public void testDecimalInput() {
		String bleh = "4.7369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(bleh);
		assertEquals("decimal input", result, 1);
	}

	@Test
	public void testNegativeInput() {
		String bleh = "-47369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(bleh);
		assertEquals("negative input", result, 1);
	}

	@Test
	public void testLessThanOneInput() {
		String bleh = "407369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(bleh);
		assertEquals("negative input", result, -1);
	}


	@Test
	public void testDuplicateInSubGrid() {
		String bleh = "417369825642158947958724316825437169791586432346912758289643571573291684164875293";
		int result = v.verify(bleh);
		assertEquals("sub grid duplicate", result, -2);
	}

	@Test
	public void testDuplicateInRow() {
		String bleh = "423456789156789123789123456231564897564897231897231564312645978645978312978312645";
		int result = v.verify(bleh);
		assertEquals("row duplicate", result, -3);
	}

	@Test
	public void testDuplicateInColumn() {
		String bleh = "213456789456789123789123456231564897564897231897231564312645978645978312978312645";
		int result = v.verify(bleh);
		assertEquals("column duplicate", result, -4);
	}

	@Test
	public void testMainMethodRuns() {
		String[] args = {};
		SudokuVerifier.main(args);

	}

}
