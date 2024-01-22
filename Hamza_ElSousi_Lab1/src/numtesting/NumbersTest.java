/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and its processing.
 * @Owner/Student Name: Hamza El Sousi	
 * Student Number: 040-982-818
 * Section #: CST8130 - 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD.
 */

package numtesting;

/**
 *  This Test class includes 5 test different cases to ensure validity of Array Processing Program.
 * @Version 1.4
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import primary.Numbers;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class NumbersTest {
	private Numbers numbers;
	private Scanner scanner;

	@Before
	public void setUp() {
		numbers = new Numbers();
		// Create a mock Scanner with predefined input for testing addValue method
		String mockInput = "5.0\n";
		InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
		scanner = new Scanner(inputStream);
	}

	/**
	 * Test the addValue method by adding a single value to the array.
	 */
	@Test
	public void testAddValue() {
		// Mock user input with a single value (e.g., 5.0)
		String mockInput = "10.0\n 3\n 5\n";
		InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
		scanner = new Scanner(inputStream);

		// Call addValue method with mock input
		numbers.addValue(scanner);

		// Check if the value was added to the array
		assertEquals(1, numbers.getNumItems());
		assertEquals(10.0f, numbers.getNumbers()[0], 0.01f);
	}

	/**
	 * Test the calcAverage method by adding multiple values to the array and
	 * calculating the average.
	 */
	@Test
	public void testCalcAverage() {
		// Mock user input for adding values to the array
		String input = "5\n7\n2\n4\n1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner scanner = new Scanner(System.in);

		// Add values to the array
		for (int i = 0; i < 5; i++) {
			numbers.addValue(scanner);
		}

		// Test the calcAverage method
		float result = numbers.calcAverage();

		// The expected average is (5 + 7 + 2 + 4 + 1) / 5 = 3.8
		assertEquals(3.8f, result, 0.01); // Using delta to handle floating-point precision

		// Clean up
		System.setIn(System.in);
		scanner.close();
	}

	/**
	 * Test the findMinMax method by adding multiple values to the array and finding
	 * the minimum and maximum.
	 */
	@Test
	public void testFindMinMax() {
		// Create a Numbers object
		Numbers numbers = new Numbers(5);

		// Mock user input for adding values to the array
		String input = "5\n7\n2\n4\n1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner scanner = new Scanner(System.in);

		// Add values to the array
		for (int i = 0; i < 5; i++) {
			numbers.addValue(scanner);
		}

		// Test the findMinMax method
		String result = numbers.findMinMax();

		// The expected result should be "Minimum value is 1.00, Maximum value is 7.00,
		// Max mod Min is 0.00"
		assertEquals("Minimum value is 1.00, Maximum value is 7.00, Max mod Min is 0.00", result);

		// Clean up
		System.setIn(System.in);
		scanner.close();
	}

	/**
	 * Test the findMinMax method when the array is empty.
	 */
	@Test
	public void testFindMinMaxEmptyArray() {
		String result = numbers.findMinMax();
		assertEquals("Array is empty", result);
	}

	/**
	 * Test the getFactorialMax method by adding multiple values to the array and
	 * calculating the factorial of the maximum value.
	 */
	@Test
	public void testGetFactorialMax() {
		// Mock user input for adding values to the array
		String input = "5\n7\n2\n4\n1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Scanner scanner = new Scanner(System.in);

		// Add values to the array
		for (int i = 0; i < 5; i++) {
			numbers.addValue(scanner);
		}

		// Test the getFactorialMax method
		long result = numbers.getFactorialMax();

		// The maximum value in the array is 7, so the expected factorial is 7!
		assertEquals(5040L, result);

		// Clean up
		System.setIn(System.in);
		scanner.close();
	}
}
