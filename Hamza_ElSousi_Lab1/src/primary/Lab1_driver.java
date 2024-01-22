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

import java.util.InputMismatchException;
/**
 * @Version 1.6 Added feature: Adjusted error handling mechanism.
 * 
 */
import java.util.Scanner;

/**
 * This class represents the driver program for Lab1. It allows the user to
 * interactively initialize and manipulate an array of numbers.
 */
public class Lab1_driver {
	/**
	 * Main is the driver and main entry point of the program. 
	 * @param args   .
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Numbers numbers = null;

		while (true) {
			displayMainMenu();
		try {
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				// Initialize a default array
				numbers = new Numbers();
				break;
			case 2:
				// Specify the max size of the array
				System.out.print("Enter the max size: ");
				int maxSize = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				numbers = new Numbers(maxSize);
				break;
			case 3:
				// Add value to the array
				if (numbers == null) {
					numbers = new Numbers();}

					numbers.addValue(scanner);
				
				break;
			case 4:
				// Display values in the array
				if (numbers != null) {
					System.out.println(numbers.toString());
				} else {
					System.out.println("numbers are:\n");
				}
				break;
			case 5:
				// Display average, min , max, max-mod-min, factorialMax
				if (numbers != null) {
					float average = numbers.calcAverage();
					String minMax = numbers.findMinMax();
					long factorialMax = numbers.getFactorialMax();
					String[] minMaxArray = minMax.split(",");
					if (minMaxArray.length == 3) {
						System.out.println("Average: " + average + " Minimum value is: " + minMaxArray[0]
								+ " Maximum value is: " + minMaxArray[1] + " Max mod Min: " + minMaxArray[2]
								+ " Factorial of Max is " + factorialMax);
					}
				} else {
					System.out.println("Average is: 0.0, Minimum value is 0.0, Maximum value is 0.0 , max mod min, factorialMax");
				}
				break;
			case 6:
				// Exit the program
				System.out.println("Exiting program.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float value.");
            scanner.nextLine(); // Consume the invalid input
        }}
	}
	/**
	 *  Displays a number based menu selection.
	 */
	public static void displayMainMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Initialize a default array");
		System.out.println("2: To specify the max size of the array");
		System.out.println("3: Add value to the array");
		System.out.println("4: Display values in the array");
		System.out.println("5: Display average of the values, minimum value, maximum value, max mod min, factorialMax");
		System.out.println("6: To Exit");
		System.out.print("> ");
	}						
}
