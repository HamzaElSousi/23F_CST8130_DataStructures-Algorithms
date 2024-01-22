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
 * Represents a vegetable in the inventory.
 * 
 * @version 1.0
 */
public class Vegetable extends FoodItem {
    
	/**
     * Name of Farm/Supplier
     */
    protected String farmName;

    /**
     * Constructs a new Vegetable with default values.
     */
    public Vegetable() {
        super();
        farmName = "";
    }
    
    /**
     * Returns a string representation of the vegetable.
     *
     * @return The string representation of the vegetable.
     */	
    @Override
    public String toString() {
        return super.toString() + " farm supplier: " + farmName;
    }
    
    /**
     * Reads input from the scanner and populates the fields of the Vegetable item.
     *
     * @param scanner The scanner to read input from.
     * @return true if the input is successfully read, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the name of the farm supplier: ");
        farmName = scanner.nextLine();  // Use nextLine() to capture the full name
        return true;
    }

}
