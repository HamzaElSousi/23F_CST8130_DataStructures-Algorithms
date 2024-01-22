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
 *  This Test class includes 7 test different cases to ensure validity of Array Processing Program including File I/O for Lab 2.
 * @Version 2.1
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import primary.Numbers;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * NumbersTest is a J-unit test class. The purpose of this class is to test the
 * features for the Array Processing Program
 */
public class NumbersTest {
	private Numbers numbers;
	private Scanner scanner;
	@SuppressWarnings("unused")
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	/**
	 * Tests the constructor of object 'Numbers'
	 */
	@Before
	public void setUp() {
		numbers = new Numbers();
		// Create a mock Scanner with predefined input for testing addValue method
		String mockInput = "5.0\n";
		InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
		scanner = new Scanner(inputStream);
	}

	/**
	 * Test the addValue method by adding values to the array.
	 */
	@Test
	public void testAddValues() {
		// Mock user input with multiple values
		String mockInput = "4\n5.0\n3.0\n2.0\n1.0\nq\n";
		scanner = new Scanner(mockInput);

		// Call addValues method with mock input
		numbers.addValues(scanner, true);

		// Check if the values were added to the array
		assertEquals(4, numbers.getNumItems(), 4);
		assertEquals(5.0, numbers.getNumbers()[0], 5.0);
		assertEquals(3.0f, numbers.getNumbers()[1], 3.0);
		assertEquals(2.0f, numbers.getNumbers()[2], 2.0);
		assertEquals(1.0f, numbers.getNumbers()[3], 1.0);
	}

	/**
	 * Tests the calcAverage method by adding multiple values to the array and
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

	/**
	 * Test the readFromFile method by reading values from a file and adding them to
	 * the array.
	 */
	@Test
	public void testReadFromFile() {
		// Create a temporary file with sample data
		try {
			File tempFile = File.createTempFile("testfile", ".txt");
			String testData = "4\n5.0\n6.0\n7.0\n8.0\n";
			Files.write(tempFile.toPath(), testData.getBytes());

			// Call readFromFile method
			numbers.readFromFile(tempFile.getAbsolutePath());

			// Check if values were correctly read from the file
			assertEquals(4, numbers.getNumItems());
			assertEquals(5.0f, numbers.getNumbers()[0], 5.0);
			assertEquals(6.0f, numbers.getNumbers()[1], 6.0);
			assertEquals(7.0f, numbers.getNumbers()[2], 7.0);
			assertEquals(8.0f, numbers.getNumbers()[3], 8.0);

			// Clean up
			tempFile.delete();
		} catch (Exception e) {
			fail("Exception occurred: " + e.getMessage());
		}
	}

	/**
	 * Test the saveToFile method by saving values from the array to a file.
	 */
	@Test
	public void testSaveToFile() {
		// Create a temporary file for testing
		try {
			File tempFile = File.createTempFile("testfile", ".txt");

			// Create a mock input for adding values to the array
			String mockInput = "4\n0.0\n1.0\n2.0\n3.0\nq\n"; // Add 'q' to stop input
			InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
			Scanner inputScanner = new Scanner(inputStream);

			// Add values to the array
			numbers.addValues(inputScanner, false);

			// Call saveToFile method
			numbers.saveToFile(tempFile.getAbsolutePath());

			// Check if the file was created and contains the correct data
			Scanner fileScanner = new Scanner(tempFile);
			assertEquals(4, fileScanner.nextInt(), 4); // Check the number of floats in the file
			assertEquals(0.0f, fileScanner.nextFloat(), 0.01f);
			assertEquals(1.0f, fileScanner.nextFloat(), 0.01f);
			assertEquals(2.0f, fileScanner.nextFloat(), 0.01f);
			assertEquals(3.0f, fileScanner.nextFloat(), 0.01f);
			fileScanner.close();

			// Clean up
			tempFile.delete();
		} catch (Exception e) {
			e.printStackTrace(); // Print the exception for debugging purposes
		}
	}
}