
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

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * This class provides methods for generating random arrays,
 * and performing both binary and linear searches.
 * 
 * @version 2.2
 */
public class BinaryLinearSearch {
    private int[] randomArr; //random array 
    //removed scanner to instantiate in Main with try{}
    
    
    /**
     * Generates and returns an array of 32 random integers between 10 and 100.
     *
     * @return An array of 32 random integers.
     */
    public int[] generateRandomInts() {
        SecureRandom random = new SecureRandom();
        randomArr = new int[32];
        for (int i = 0; i < 32; i++) {
            randomArr[i] = random.nextInt(90) + 10;  // Random number between 10 to 100
        }
        System.out.println("Unsorted Array: " + Arrays.toString(randomArr));
        return randomArr;
    }

    
    /**
     * Performs an iterative binary search.
     *
     * @param arr The sorted array to be searched.
     * @param key The key to be searched for.
     * @return The index of the key if found, -1 otherwise.
     */
    public int iterativeBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Number " + key + " found at index " + mid + ": Iterative Binary Search");
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Number " + key + " was not found.");
        return -1;
    }


    /**
     * Performs a recursive binary search.
     *
     * @param arr The sorted array to be searched.
     * @param key The key to be searched for.
     * @return The index of the key if found, -1 otherwise.
     */
    public int recursiveBinarySearch(int[] arr, int key) {
        return recursiveBinarySearch(arr, 0, arr.length - 1, key);
    }

    private int recursiveBinarySearch(int[] arr, int low, int high, int key) {
        if (low <= high) {
            // Print the current portion of the array being searched
            for (int i = low; i <= high; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return recursiveBinarySearch(arr, low, mid - 1, key);
            } else {
                return recursiveBinarySearch(arr, mid + 1, high, key);
            }
        }
        return -1;
    }

    /**
     * Performs an iterative linear search.
     *
     * @param arr The array to be searched.
     * @param key The key to be searched for.
     * @return The index of the key if found, -1 otherwise.
     */
    public int iterativeLinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Number " + key + " found at index " + i + ": Iterative Linear Search");
                return i;
            }
        }
        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Performs a recursive linear search.
     *
     * @param arr The array to be searched.
     * @param size The size of the array.
     * @param key The key to be searched for.
     * @return The index of the key if found, -1 otherwise.
     */
    public int recursiveLinearSearch(int[] arr, int size, int key) {
        return recursiveLinearSearchHelper(arr, size - 1, key);
    }

    private int recursiveLinearSearchHelper(int[] arr, int index, int key) {
        if (index < 0) {
            System.out.println("Number " + key + " was not found.");
            return -1;
        }
        if (arr[index] == key) {
            System.out.println("Number " + key + " found at index " + index + ": Recursive Linear Search");
            return index;
        }
        return recursiveLinearSearchHelper(arr, index - 1, key);
    }

    // ... time measurement methods in Main ...
}
