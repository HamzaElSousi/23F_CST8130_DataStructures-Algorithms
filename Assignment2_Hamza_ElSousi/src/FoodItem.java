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
 * This abstract class represents a generic food item and provides methods to manage its properties.
 * @param <T> Generic types T for FoodItem 
 * @version 2.0
 */
public abstract class FoodItem<T extends FoodItem<T>> implements Comparable<T> {
    /**
     * The code of the food item.
     */
    protected int itemCode;

    /**
     * The name of the food item.
     */
    protected String itemName;

    /**
     * The quantity of the food item in stock.
     */
    protected int itemQuantityInStock;

    /**
     * The cost of the food item.
     */
    protected double itemCost;

    /**
     * The price of the food item.
     */
    protected double itemPrice;

    /**
     * The itemType ("f" Fruit, "v" Vegetable, "p" Preserve)
     */
    protected String itemType;

    /**
     * Constructs a new FoodItem object with default values for its properties.
     */
    public FoodItem() {
        itemCode = 0;
        itemName = "";
        itemQuantityInStock = 0;
        itemCost = 0.0;
        itemPrice = 0.0;
    }

    /**
     * Constructs a new FoodItem object with the specified properties.
     *
     * @param itemCode           The code of the food item.
     * @param itemName           The name of the food item.
     * @param quantityInStock    The quantity of the food item in stock.
     * @param itemCost           The cost of the food item.
     * @param itemPrice          The price of the food item.
     * @param itemSupplier       The supplier or additional info for the food item.
     * @param itemType           The type of the food item ("f" for fruit, "v" for vegetable, etc.).
     */
    public FoodItem(int itemCode, String itemName, int quantityInStock, double itemCost, double itemPrice, String itemSupplier, String itemType) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQuantityInStock = quantityInStock;
        this.itemCost = itemCost;
        this.itemPrice = itemPrice;
        this.itemType = itemType; // Set the item type
    }

    /**
     * Adds a new food item to the inventory.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        try {
            if (!fromFile) {
                System.out.print("Enter the item code: ");
                itemCode = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            }

            System.out.print("Enter the item name: ");
            itemName = scanner.nextLine();

            System.out.print("Enter the quantity in stock: ");
            itemQuantityInStock = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the item cost: $");
            itemCost = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter the item price: $");
            itemPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            return true;
        } catch (Exception e) {
            System.out.println("Error adding item: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates the quantity of the food item in stock.
     *
     * @param quantityChange The change in quantity (positive for buying, negative for selling).
     * @return True if the update is successful, false otherwise.
     */
    public boolean updateItem(int quantityChange) {
        if (quantityChange > 0 || (itemQuantityInStock + quantityChange) >= 0) {
            itemQuantityInStock += quantityChange;
            return true; // Return true to indicate a successful update
        } else {
            return false; // Return false to indicate an unsuccessful update
        }
    }

    /**
     * Outputs additional information specific to the food item to a Formatter object.
     *
     * @param writer The Formatter object used for output.
     */
    protected abstract void outputAdditionalInfo(Formatter writer);

    /**
     * Gets the code of the food item.
     *
     * @return The item code.
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     * Checks if the input code matches the item's code.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the code is successfully set, false otherwise.
     */
    public boolean inputCode(Scanner scanner, boolean fromFile) {
        if (!fromFile) {
            System.out.print("Enter the item code: ");
            if (scanner.hasNextInt()) {
                itemCode = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return true;
            } else {
                System.out.println("Invalid item code...");
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if two food items have the same item code.
     *
     * @param item The food item to compare.
     * @return True if the items have the same item code, false otherwise.
     */
    public boolean isEqual(T item) {
        return (itemCode == item.itemCode);
    }

    /**
     * Generates a string representation of the food item.
     *
     * @return A string representing the food item.
     */
    @Override
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
                + itemCost;
    }

    /**
     * Outputs the food item details to a Formatter object.
     *
     * @param writer The Formatter object used for output.
     */
    public void outputItem(Formatter writer) {
        // Output the item type first (e.g., "f" for fruit)
        writer.format("%s%n%d%n%s%n%d%n%.2f%n%.2f%n", itemType, itemCode, itemName, itemQuantityInStock, itemCost, itemPrice);
        outputAdditionalInfo(writer);
    }

    /**
     * Compares Item codes
     */
    @Override
    public int compareTo(T other) {
        return Integer.compare(itemCode, other.itemCode);
    }

    /**
     * @return itemType ("f" Fruit, "v" Vegetable, "p" Preserve)
     */
    protected abstract Object getItemType();
    /**
     * Returns the quantity of the fruit item in stock.
     *
     * @return The quantity in stock.
     */
	protected abstract Object getItemQuantityInStock();

	/**
     * Returns the price of the fruit item.
     *
     * @return The item price.
     */
	protected abstract Object getItemPrice();

	/**
     * Returns the cost of the fruit item.
     *
     * @return The item cost.
     */
	protected abstract Object getItemCost();

	/**
     * Returns the name of the fruit item.
     *
     * @return The item name.
     */
	protected abstract Object getItemName();
}
