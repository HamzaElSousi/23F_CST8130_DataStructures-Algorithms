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

import java.util.Formatter;
import java.util.Scanner;

/**
 * This class represents a Preserve food item and provides methods to manage its properties.
 * @version 2.0
 */
public class Preserve extends FoodItem<Preserve> {
	/**
     * The size of the jar in milliliters for the preserve.
     */
    private String jarSize;

    /**
     * Constructs a new Preserve object with default values for its properties.
     */
    public Preserve() {
        jarSize = "";
    }

    /**
     * Constructs a new Preserve object with the specified properties.
     *
     * @param itemCode        The code of the preserve item.
     * @param itemName        The name of the preserve item.
     * @param quantityInStock The quantity of the preserve item in stock.
     * @param itemCost        The cost of the preserve item.
     * @param itemPrice       The price of the preserve item.
     * @param jarSize         The size of the jar in milliliters.
     */
    public Preserve(int itemCode, String itemName, int quantityInStock, double itemCost, double itemPrice,
            String jarSize) {
        super(itemCode, itemName, quantityInStock, itemCost, itemPrice, jarSize, "p");
        this.jarSize = jarSize;
    }
    
    /**
     * Adds a new preserve item to the inventory.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            // Prompt for and set the jarSize for Preserve
            if (!fromFile) {
                System.out.print("Enter the size of the jar in millilitres: ");
                String jarSize = scanner.nextLine();
                this.jarSize = jarSize;
            }
            return true;
        }
        return false;
    }

    /**
     * Updates the quantity of the preserve item in stock.
     *
     * @param quantityChange The change in quantity (positive for buying, negative for selling).
     * @return True if the update is successful, false otherwise.
     */
    @Override
    public boolean updateItem(int quantityChange) {
        if (quantityChange > 0 || (itemQuantityInStock + quantityChange) >= 0) {
            itemQuantityInStock += quantityChange;
            return true; // Return true to indicate a successful update
        } else {
            return false; // Return false to indicate an unsuccessful update
        }
    }
    
    /**
     * Outputs additional information specific to the preserve item to a Formatter object.
     *
     * @param writer The Formatter object used for output.
     */
    @Override
    protected void outputAdditionalInfo(Formatter writer) {
        writer.format("p%n%s%n", jarSize);
    }
    
    /**
     * Gets the size of the jar in milliliters for the preserve.
     *
     * @return The jar size.
     */
    public Object getJarSize() {
        return jarSize;
    }

    /**
     * Generates a string representation of the preserve item.
     *
     * @return A string representing the preserve item.
     */
    @Override
    public String toString() {
        return super.toString() + " jar size: " + jarSize + "mL";
    }
    
    /**
     * Returns the item type for a Preserve (always "p").
     *
     * @return "p" to indicate it's a preserve item.
     */
    @Override
	protected Object getItemType() {
		return "p";
	}

    /**
     * Returns the quantity of the preserve item in stock.
     *
     * @return The quantity in stock.
     */
	@Override
	protected Object getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	/**
     * Returns the price of the preserve item.
     *
     * @return The item price.
     */
	@Override
	protected Object getItemPrice() {
		return itemPrice;
	}

	/**
     * Returns the cost of the preserve item.
     *
     * @return The item cost.
     */
	@Override
	protected Object getItemCost() {
		return itemCost;
	}

	/**
     * Returns the name of the preserve item.
     *
     * @return The item name.
     */
	@Override
	protected Object getItemName() {
		return itemName;
	}
}
