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

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class serves as the main program that provides a menu for performing operations such as initializing and populating an array, searching for elements using recursive binary and linear search, sorting the array using various sorting algorithms, and displaying the sorted array.
 */
public class TestSearchSort {
	/**
     * The main method that serves as the entry point of the program.
     * 
	 * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
    	 /**
         * The SortingAlgorithms instance used for sorting operations.
         */
        SortingAlgorithms sorter = new SortingAlgorithms(1000);
        
        /**
         * The Searching instance used for searching operations.
         */
        Searching<Integer> searcher = new Searching();
        try (Scanner scanner = new Scanner(System.in)) {
			int option = 0;
			do {
			    System.out.println("Select your option in the menu below:");
			    System.out.println("1: Initialize and populate an array of 1000 random integers.");
			    System.out.println("2: Perform recursive binary search.");
			    System.out.println("3: Perform recursive linear search.");
			    System.out.println("4: Sort the array");
			    System.out.println("5: Quit");
			    System.out.print(">");

			    try {
			    option = scanner.nextInt();
			    scanner.nextLine(); // Consume newline

			    switch (option) {
			        case 1:
			            sorter.genRandomElements();
			            System.out.println("Array of randomly generated integers:");
			            System.out.println(Arrays.toString(sorter.randomArr));
			            break;
			        case 2:
			            System.out.print("Please enter an integer value to search:\n>");
			            int target = scanner.nextInt();
			            
			            // Create a sorted copy of the array for binary search
			            Comparable[] sortedArr = Arrays.copyOf(sorter.randomArr, sorter.randomArr.length);
			            Arrays.sort(sortedArr);

			            int index = searcher.recursiveBinarySearch(sortedArr, target, 0, sortedArr.length - 1);
			            System.out.println(Arrays.toString(sorter.randomArr));
			            if (index != -1) {
			                System.out.println(target + " was found at index position " + index + " : Recursive Binary Search.");
			            } else {
			                System.out.println(target + " was not found in the array.");
			            }
			            break;

			        case 3:
			            System.out.print("Please enter an integer value to search:\n>");
			            target = scanner.nextInt();
			            index = searcher.linearSearch(sorter.randomArr, target, 0);
			            System.out.println(Arrays.toString(sorter.randomArr));
			            if (index != -1) {
			                System.out.println(target + " was found at index position " + index + " : Recursive Linear Search.");
			            } else {
			                System.out.println(target + " was not found in the array.");
			            }
			            break;
			        case 4:
   boolean sortingMenu = true;
   do {
			System.out.println("Select a sorting algorithm to sort the data array");
			System.out.println("B. Bubble Sort");
			System.out.println("I. Insertion Sort");
			System.out.println("S. Selection Sort");
			System.out.println("M. Merge Sort");
			System.out.println("Q. Quick Sort");
			System.out.println("R. Return to Main Menu");
			System.out.print(">");

			String sortOption = scanner.nextLine().toUpperCase();

			switch (sortOption) {
			    case "B":
			        long startTime = System.nanoTime();
			        sorter.bubbleSort();
			        long endTime = System.nanoTime();
			        displaySortedArray("Bubble Sort O(n^2)", sorter.randomArr, startTime, endTime);
			        break;
			    case "I":
			        // Implement sorting options for Insertion Sort
			        long insertionSortStartTime = System.nanoTime();
			        sorter.insertionSort();
			        long insertionSortEndTime = System.nanoTime();
			        displaySortedArray("insertion Sort O(n^2)", sorter.randomArr, insertionSortStartTime, insertionSortEndTime);
			        break;
			    case "S":
			        // Implement sorting options for Selection Sort
			        long selectionSortStartTime = System.nanoTime();
			        sorter.selectionSort();
			        long selectionSortEndTime = System.nanoTime();
			        displaySortedArray("Selection Sort O(n^2)", sorter.randomArr, selectionSortStartTime, selectionSortEndTime);
			        break;
			    case "M":
			        // Implement sorting options for Merge Sort
			        long mergeSortStartTime = System.nanoTime();
			        sorter.mergeSort();
			        long mergeSortEndTime = System.nanoTime();
			        displaySortedArray("Merge Sort O(n log n)", sorter.randomArr, mergeSortStartTime, mergeSortEndTime);
			        break;
			    case "Q":
			        // Implement sorting options for Quick Sort
			        long quickSortStartTime = System.nanoTime();
			        sorter.quickSort();
			        long quickSortEndTime = System.nanoTime();
			        displaySortedArray("Quick Sort O(n log n)", sorter.randomArr, quickSortStartTime, quickSortEndTime);
			        break;
			    case "R":
			        sortingMenu = false;
			        System.out.println("Returning to main menu...");
			        break;
			    default:
			        System.out.println("Invalid entry, please try again...");
			}
   } while (sortingMenu);
   break;

			        case 5:
			            System.out.println("Exiting...");
			            break;
			        default:
			            System.out.println("Invalid entry, please try again...");
			            break;
			    }} catch (InputMismatchException e) {
			        System.out.println("Invalid input! Please enter an integer.");
			        scanner.nextLine();
			    }
			} while (option != 5);
		}
    }

    /**
     * Displays the sorted array and the time taken for sorting in nanoseconds and milliseconds.
     *
     * @param algorithmName The name of the sorting algorithm used.
     * @param randomArr     The sorted array.
     * @param startTime     The start time of sorting.
     * @param endTime       The end time of sorting.
     */
    private static void displaySortedArray(String algorithmName, Comparable[] randomArr, long startTime, long endTime) {
    System.out.println(algorithmName + ":");
    System.out.println("Sorted: " + Arrays.toString(randomArr));
    
    long nanoseconds = endTime - startTime;
    long milliseconds = nanoseconds / 1_000_000;
    
    System.out.println("Time taken in nanoseconds: " + nanoseconds);
    System.out.println("Time taken in milliseconds: " + milliseconds);
}

}
