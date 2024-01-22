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
 * Represents a class for performing operations on an array of numbers.
 * @Version 1.5 Improved implementation of Catch block for better error handling. 
 */
import java.util.Scanner;
//TODO: Correct GetFactorialMax method 
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
     * Default Constructor.
     * Initializes the array with a default size of 5 for short demo.
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
     * Gets the numbers array.
     * @return The array of Float numbers.
     */
    public Float[] getNumbers() {
        return numbers;
    }

    /**
     * Gets the number of items in the array.
     * @return The number of items.
     */
    public int getNumItems() {
        return numItems;
    }

//    /**
//     * Sets the number of items in the array.
//     * @param numItems The number of items to set.
//     */
//    private void setNumItems(int numItems) {
//        this.numItems = numItems;
//    }

    /**
     * Calculates the average of all the float numbers in the array.
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
     * @return Min and Max formatted as specified, or an error message if an issue occurs.
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

                return String.format("Minimum value is %.2f, Maximum value is %.2f, Max mod Min is %.2f", min, max, max % min);
            } else {
                return "Array is empty";
            }
        } catch (Exception e) {
            return "An error occurred while finding min and max values: " + e.getMessage();
        }
        
    }

    /**
     * Calculates and returns the factorial of the maximum integer value in the array.
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Numbers are:\n");
        for (int i = 0; i < numItems; i++) {
            sb.append(numbers[i]).append("\n");
        }
        return sb.toString();
    }
}
