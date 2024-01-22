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

import java.util.*;
import java.util.Scanner;

/**
 * Main class for Binary and Linear Search operations.
 * 
 * @version 2.2 
 */
public class Lab3BinLinSearchMain {

	/**
     * Main method to drive the menu and user interaction.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			BinaryLinearSearch search = new BinaryLinearSearch();
			int[] randomArr = null;
			int[] sortedArr = null;

			while (true) { 
				// displays menu options 1-4
				displayMenu();
			    
			    try {
			    int choice = scanner.nextInt();

			    switch (choice) {
			        case 1:
			        	randomArr = search.generateRandomInts();
			            sortedArr = Arrays.copyOf(randomArr, randomArr.length);
			            Arrays.sort(sortedArr);
			            System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
			            break;
			        case 2:
			            if (randomArr == null) {
			                System.out.println("Please generate a random array first.");
			                break;
			            }
			            System.out.print("Enter the number to search: \n");
			            int keyRec = scanner.nextInt();

			         // Recursive Binary Search
			            long startNanoRecBin = System.nanoTime();
			            long startMillisRecBin = System.currentTimeMillis();
			            int indexRecBin = search.recursiveBinarySearch(sortedArr, keyRec);
			            long endNanoRecBin = System.nanoTime();
			            long endMillisRecBin = System.currentTimeMillis();
			            if (indexRecBin == -1) {
			                System.out.println(keyRec + " was not found: recursive Binary Search");
			            } else {
			                System.out.println(keyRec + " was found at index position " + indexRecBin + ": recursive Binary Search");
			            }
			            System.out.println("Time taken in nanoseconds: " + (endNanoRecBin - startNanoRecBin));
			            System.out.println("Time taken in milliseconds: " + (endMillisRecBin - startMillisRecBin)+"\n");
			            
			            // Recursive Linear Search
			            long startNanoRecLin = System.nanoTime();
			            long startMillisRecLin = System.currentTimeMillis();
			            search.recursiveLinearSearch(randomArr, randomArr.length, keyRec);
			            long endNanoRecLin = System.nanoTime();
			            long endMillisRecLin = System.currentTimeMillis();
			            System.out.println("Time taken for recursive linear search in nanoseconds: " + (endNanoRecLin - startNanoRecLin));
			            System.out.println("Time taken for recursive linear search in milliseconds: " + (endMillisRecLin - startMillisRecLin)+"\n");

			            break;
			        case 3:
			            if (sortedArr == null) {
			                System.out.println("Please generate a random array first.");
			                break;
			            }
			            System.out.print("Enter the number to search: ");
			            int keyIter = scanner.nextInt();

			            // Iterative Binary Search
			            long startNanoIterBin = System.nanoTime();
			            long startMillisIterBin = System.currentTimeMillis();
			            search.iterativeBinarySearch(sortedArr, keyIter);
			            long endNanoIterBin = System.nanoTime();
			            long endMillisIterBin = System.currentTimeMillis();
			            System.out.println("Time taken for iterative binary search in nanoseconds: " + (endNanoIterBin - startNanoIterBin));
			            System.out.println("Time taken for iterative binary search in milliseconds: " + (endMillisIterBin - startMillisIterBin)+"\n");

			            // Iterative Linear Search
			            long startNanoIterLin = System.nanoTime();
			            long startMillisIterLin = System.currentTimeMillis();
			            search.iterativeLinearSearch(randomArr, keyIter);
			            long endNanoIterLin = System.nanoTime();
			            long endMillisIterLin = System.currentTimeMillis();
			            System.out.println("Time taken for iterative linear search in nanoseconds: " + (endNanoIterLin - startNanoIterLin));
			            System.out.println("Time taken for iterative linear search in milliseconds: " + (endMillisIterLin - startMillisIterLin)+"\n");

			            break;
			        case 4:
			            System.out.println("Exiting program...");
			            System.exit(0);
			        default:
			            System.out.println("Please choose the option 1 to 4");
			    }
			}catch (InputMismatchException e) {
			    System.out.println("Invalid input. Please enter a valid integer.");
			    scanner.nextLine(); // Consume the invalid input
			    continue;
			}}
		}
    }
    /**
     * Displays the main menu to the user.
     */
    private static void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("1. Initialize and populate an array of 32 random integers.");
        System.out.println("2. Perform a recursive binary and linear search.");
        System.out.println("3. Perform iterative binary and linear search.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");}}
