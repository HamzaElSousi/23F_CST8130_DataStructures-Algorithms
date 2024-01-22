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
 * This class represents a Vegetable food item and provides methods to manage its properties.
 * @version 2.0
 */
public class Vegetable extends FoodItem<Vegetable> {
	/**
     * The name of the farm supplier for the vegetable.
     */
	private String farmSupplier;
	
    /**
     * Constructs a new Vegetable object with default values for its properties.
     */
    public Vegetable() {
        farmSupplier = "";
    }
    
    /**
     * Constructs a new Vegetable object with the specified properties.
     *
     * @param itemCode        The code of the vegetable item.
     * @param itemName        The name of the vegetable item.
     * @param quantityInStock The quantity of the vegetable item in stock.
     * @param itemCost        The cost of the vegetable item.
     * @param itemPrice       The price of the vegetable item.
     * @param farmSupplier    The name of the farm supplier for the vegetable.
     */
    public Vegetable(int itemCode, String itemName, int quantityInStock, double itemCost, double itemPrice,
            String farmSupplier) {
    	super(itemCode, itemName, quantityInStock, itemCost, itemPrice, farmSupplier, "v");
        this.farmSupplier = farmSupplier;
    }
    
    /**
     * Adds a new vegetable item to the inventory.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            // Prompt for and set the farm name for vegetable
            if (!fromFile) {
                System.out.print("Enter the name of the farm supplier: ");
                String farmSupplier = scanner.nextLine();
                this.farmSupplier = farmSupplier;
            }
            return true;
        }
        return false;
    }

    /**
     * Updates the quantity of the vegetable item in stock.
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
     * Outputs additional information specific to the vegetable item to a Formatter object.
     *
     * @param writer The Formatter object used for output.
     */
    @Override
    protected void outputAdditionalInfo(Formatter writer) {
        writer.format("v%n%s%n", farmSupplier);
    }
    /**
     * Gets the name of the farm supplier for the vegetable.
     *
     * @return The farm supplier name.
     */
    public Object getFarmSupplier() {
        return farmSupplier;
    }

    /**
     * Generates a string representation of the vegetable item.
     *
     * @return A string representing the vegetable item.
     */
    @Override
    public String toString() {
        return super.toString() + " farm supplier: " + farmSupplier;
    }

    /**
     * Returns the item type for a Vegetable (always "v").
     *
     * @return "v" to indicate it's a vegetable item.
     */
    @Override
	protected Object getItemType() {
		return "v";
	}

    /**
     * Returns the quantity of the vegetable item in stock.
     *
     * @return The quantity in stock.
     */
	@Override
	protected Object getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	/**
     * Returns the price of the vegetable item.
     *
     * @return The item price.
     */
	@Override
	protected Object getItemPrice() {
		return itemPrice;
	}

	/**
     * Returns the cost of the vegetable item.
     *
     * @return The item cost.
     */
	@Override
	protected Object getItemCost() {
		return itemCost;
	}

	/**
     * Returns the name of the vegetable item.
     *
     * @return The item name.
     */
	@Override
	protected Object getItemName() {
		return itemName;
	}
}