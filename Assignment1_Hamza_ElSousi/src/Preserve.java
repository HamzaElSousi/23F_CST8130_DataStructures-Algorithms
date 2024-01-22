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
import java.util.Scanner;
/**
 * Represents a preserved food item in the inventory.
 * 
 * @version 1.0
 */
public class Preserve extends FoodItem {
	/**
	 * Size of Jar in mL
	 */
	protected int jarSize;
	/**
     * Default constructor for Preserve.
     */
    public Preserve() {
        super();
        @SuppressWarnings("unused")
		int jarSize = 0;
    }
    
    /**
     * Returns a string representation of the preserved food item.
     *
     * @return The string representation of the preserved food item.
     */
    @Override
    public String toString() {
        return super.toString() + " size: " + jarSize +"mL";
    }

    /**
     * Reads input from the scanner and populates the fields of the Preserve item.
     *
     * @param scanner The scanner to read input from.
     * @return true if the input is successfully read, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        
        while (true) {
            System.out.print("Enter the size of the jar in milliliters: ");
            if (scanner.hasNextInt()) {
                int size = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (size >= 0) {
                    jarSize = size;
                    return true;
                } else {
                    System.out.println("Error: Jar size cannot be negative. Please enter a non-negative value.");
                }
            } else {
                System.out.println("Error: Please enter a numeric value.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }
}
