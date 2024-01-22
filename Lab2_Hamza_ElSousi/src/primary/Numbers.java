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

package primary;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Version 2.2 Represents a class for performing operations on an array of
 *          numbers. Reads and writes to and from files as well as stores data
 *          to file. - Added methods 'readFromFile' and 'saveToFile' - Modified
 *          method 'addValue' Included features: - Reading from file - Writing
 *          from file - Saving to file
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] numbers;
	/**
	 * Size of the array.
	 */
	private int size;
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor. Initializes the array with a default size of 5 for short
	 * demo.
	 */
	public Numbers() {
		size = 5; // Default size
		numbers = new Float[size];
		numItems = 0;
	}

	/**
	 * Constructor that initializes the numbers array with a specified size.
	 *
	 * @param size Max size of the numbers array
	 */
	public Numbers(int size) {
		this.size = size;
		numbers = new Float[size];
		numItems = 0;
	}

	/**
     * Adds a value to the array if there is space available. Otherwise, will print "Array full"
     * 
     * @param keyboard The Scanner object for input.
     */
    public void addValue(Scanner keyboard) {
        try {
            if (numItems < size) {
                System.out.print("Enter value: ");
                float value = keyboard.nextFloat();
                numbers[numItems++] = value;
            } else {
                System.out.println("Array full");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float value.");
            keyboard.nextLine(); // Consume the invalid input
        }
    }
	/**
	 * New method to add values from a Scanner (file or standard input)
	 * 
	 * @param scanner         Takes inputs to process data
	 * @param displayMessages Boolean option to display messages.
	 */
    public void addValues(Scanner scanner, boolean displayMessages) {
        try {
            System.out.print("How many values do you wish to add? ");
            int numInputs = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (numInputs > size - numItems) {
                System.out.println("Not enough space in the array to store " + numInputs + " values. You can add " + (size - numItems));
                return;
            }

            for (int i = 0; i < numInputs; i++) {
                if (!displayMessages) {
                    // Skip message display when reading from a file
                    float value = scanner.nextFloat();
                    numbers[numItems++] = value;
                } else {
                    System.out.print("Enter value " + (i + 1) + ":\nEnter 'q' to Escape: ");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("q")) {
                        break;
                    }

                    try {
                        float value = Float.parseFloat(input);
                        numbers[numItems++] = value;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format. Please enter a valid float value.");
                        i--; // Decrement i to retry input for the same value
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer value for the number of inputs.");
            scanner.nextLine(); // Consume the invalid input
        }
    }


	/**
	 * Gets the numbers array.
	 * 
	 * @return The array of Float numbers.
	 */
	public Float[] getNumbers() {
		return numbers;
	}

	/**
	 * Gets the number of items in the array.
	 * 
	 * @return The number of items.
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * Calculates the average of all the float numbers in the array.
	 * 
	 * @return The average of the numbers.
	 */
	public float calcAverage() {
		float sum = 0;
		for (int i = 0; i < numItems; i++) {
			sum += numbers[i];
		}
		if (numItems > 0) {
			return sum / numItems;
		} else {
			return 0.0f;
		}
	}

	/**
	 * Finds and returns the minimum and maximum values in the array.
	 *
	 * @return Min and Max formatted as specified, or an error message if an issue
	 *         occurs.
	 */
	public String findMinMax() {
		try {
			if (numItems > 0) {
				float min = numbers[0];
				float max = numbers[0];

				for (int i = 1; i < numItems; i++) {
					if (numbers[i] < min) {
						min = numbers[i];
					}
					if (numbers[i] > max) {
						max = numbers[i];
					}
				}

				return String.format("Minimum value is %.2f, Maximum value is %.2f, Max mod Min is %.2f", min, max,
						max % min);
			} else {
				return "Array is empty";
			}
		} catch (Exception e) {
			return "An error occurred while finding min and max values: " + e.getMessage();
		}

	}

	/**
	 * Calculates and returns the factorial of the maximum integer value in the
	 * array.
	 * 
	 * @return The factorial of the maximum integer value.
	 */
	public long getFactorialMax() {
		if (numItems == 0) {
			System.out.println("Array is empty. Cannot calculate factorial.");
			return -1; // Return -1 to indicate an error
		}

		float max = numbers[0];
		for (int i = 1; i < numItems; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		try {
			// Convert max to an integer and calculate its factorial
			int maxInt = (int) max;
			long factorial = 1;
			for (int i = 1; i <= maxInt; i++) {
				factorial *= i;
			}

			return factorial;
		} catch (ArithmeticException e) {
			System.out.println("Factorial calculation error.");
			return -1; // Return -1 to indicate an error
		}
	}

	/**
	 * Reads values from a file and adds them to the array.
	 *
	 * @param fileName The name to the file containing float values.
	 */
	public void readFromFile(String fileName) {
		try (Scanner fileScanner = new Scanner(new File(fileName))) {
			int count = fileScanner.nextInt(); // Read the number of floats
			fileScanner.nextLine(); // Consume the newline character

			// Reset the array
//			numbers = new Float[size];
//			numItems = 0;

			while (numItems < size && count > 0 && fileScanner.hasNextFloat()) {
				float value = fileScanner.nextFloat();
				numbers[numItems++] = value;
				count--;
			}

			System.out.println("Values read from " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input in file: " + fileName);
		}
	}

	/**
	 * Saves the current values to a file.
	 *
	 * @param filename The name/path to the file where values will be saved.
	 */
	public void saveToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(filename)) {
			writer.println(numItems); // Write the number of floats first
			for (int i = 0; i < numItems; i++) {
				writer.println(numbers[i]);
			}
			System.out.println("Values saved to " + filename);
		} catch (IOException e) {
			System.out.println("Error while saving to file: " + e.getMessage());
		}
	}

	/**
	 * toString method to format the outputs
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Numbers are:\n");
		for (int i = 0; i < numItems; i++) {
			sb.append(numbers[i]).append("\n");
		}
		return sb.toString();
	}
}
