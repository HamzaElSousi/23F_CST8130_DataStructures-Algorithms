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
 * This class represents a fruit food item and extends the FoodItem class.
 * @version 2.0
 */
public class Fruit extends FoodItem <Fruit> {
	/**
     * The supplier of the fruit from an orchard.
     */
    private String orchardSupplier;

    /**
     * Constructs a new Fruit object with default values for its properties.
     */
    public Fruit() {
        orchardSupplier = "";
    }

    /**
     * Constructs a new Fruit object with the specified properties.
     *
     * @param itemCode           The code of the fruit item.
     * @param itemName           The name of the fruit item.
     * @param quantityInStock    The quantity of the fruit item in stock.
     * @param itemCost           The cost of the fruit item.
     * @param itemPrice          The price of the fruit item.
     * @param orchardSupplier    The supplier from an orchard for the fruit.
     */
    public Fruit(int itemCode, String itemName, int quantityInStock, double itemCost, double itemPrice,
            String orchardSupplier) {
        super(itemCode, itemName, quantityInStock, itemCost, itemPrice, orchardSupplier, "f");
        this.orchardSupplier = orchardSupplier;
    }

    /**
     * Adds a new fruit item to the inventory.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            // Prompt for and set the supplier name for fruit
            if (!fromFile) {
                System.out.print("Enter the supplier name: ");
                String orchardSupplier = scanner.nextLine();
                this.orchardSupplier = orchardSupplier;
            }
            return true;
        }
        return false;
    }

    /**
     * Updates the quantity of the fruit item in stock.
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
     * Outputs additional information specific to the fruit item to a Formatter object.
     *
     * @param writer The Formatter object used for output.
     */
    @Override
    protected void outputAdditionalInfo(Formatter writer) {
        writer.format("f%n%s%n", orchardSupplier);
    }

    /**
     * Gets the supplier from an orchard for the fruit.
     *
     * @return The orchard supplier name.
     */
    public Object getOrchardSupplier() {
        return orchardSupplier;
    }

    /**
     * Generates a string representation of the fruit item.
     *
     * @return A string representing the fruit item.
     */
    @Override
    public String toString() {
        return super.toString() + " orchard supplier: " + orchardSupplier;
    }

    /**
     * Returns the item type for a Fruit (always "f").
     *
     * @return "f" to indicate it's a fruit item.
     */
	@Override
	protected Object getItemType() {
		return "f";
	}

	/**
     * Returns the quantity of the fruit item in stock.
     *
     * @return The quantity in stock.
     */
	@Override
	protected Object getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	/**
     * Returns the price of the fruit item.
     *
     * @return The item price.
     */
	@Override
	protected Object getItemPrice() {
		return itemPrice;
	}

	/**
     * Returns the cost of the fruit item.
     *
     * @return The item cost.
     */
	@Override
	protected Object getItemCost() {
		return itemCost;
	}

	/**
     * Returns the name of the fruit item.
     *
     * @return The item name.
     */
	@Override
	protected Object getItemName() {
		return itemName;
	}
}
