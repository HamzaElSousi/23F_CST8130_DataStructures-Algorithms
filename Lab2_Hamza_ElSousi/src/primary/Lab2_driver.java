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
import java.util.Scanner;
/**
 * 
 * @version 2.2
 * 
 * Added switch cases: 
 * - 6 to add multiple values
 * - 7 to read values from file
 * - 8 to read values from file
 * - 9 Will exit the program
 * Added features: 
 * - Reading from file
 * - Writing from file
 * - Saving to file 
 * This class represents the driver program for Lab2 that is based on lab 1. It allows the user to
 * interactively initialize and manipulate an array of numbers. As well as read and write data to a file. 
 */

//Class name refactored to align with lab(n)
public class Lab2_driver {
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
				// Instantiate a default array
				numbers = new Numbers();
				break;
			case 2:
				// Prompt user to specify the max size of the array
				System.out.print("Enter new size of array: ");
				int maxSize = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				numbers = new Numbers(maxSize);
				break;
			case 3:
				// Add value to the array
				if (numbers == null) {
					numbers = new Numbers();
					}
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
						System.out.println("Average: " + String.format("%.2f", average) + " Minimum value is: " + minMaxArray[0]
								+ " Maximum value is: " + minMaxArray[1] + " Max mod Min: " + minMaxArray[2]
								+ " FactorialMax is " + factorialMax);
					}
				} else {
					System.out.println("Average is: 0.0, Minimum value is 0.0, Maximum value is 0.0 , max mod min, factorialMax");
				}
				break;
			case 6:
				 if (numbers != null) {
                     numbers.addValues(scanner, true);
                 } 
                 break;
			case 7:
				// Add values from a file
			    if (numbers != null) {
			        System.out.print("Enter the filename to read values from: ");
			        String filename = scanner.nextLine();
			        numbers.readFromFile(filename);
			    } 
			    break;
			case 8:
			    // Save values to a file
			    if (numbers != null) {
			        System.out.print("Enter the filename to save values to: ");
			        String filename = scanner.nextLine();
			        numbers.saveToFile(filename);
			    } else {
			        System.out.println("No values to save.");
			    }
			    break;
			case 9:
                // Exit the program
                System.out.println("Exiting program...");
                scanner.close();
                System.exit(0);
                break;
			default:
				System.out.println("Invalid selection. Enter options 1-9\n");
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
		System.out.println("6: Enter multiple values");
		System.out.println("7: Read values from file");
		System.out.println("8: Save values to file");
		System.out.println("9: To Exit");
		System.out.print("> ");
	}						
}
