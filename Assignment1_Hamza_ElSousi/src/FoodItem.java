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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a food item in the inventory.
 *
 * @version 1.0
 */
public class FoodItem {
	/**
	 *  Product code
	 */
	private int itemCode;
	/**
	 *  Product name
	 */
	private String itemName;
	/**
	 *  Product retail sales price
	 */
	private float itemPrice;
	/**
	 *  Product amount in stock
	 */
	private int itemQuantityInStock;
	/**
	 *  Product cost from supplier/ wholesale price
	 */
	private float itemCost;

	/**
	 * Default constructor for FoodItem.
	 */
	public FoodItem() {
		setItemCode(0);
		itemName = "";
		itemPrice = 0.0f;
		setItemQuantityInStock(0);
		itemCost = 0.0f;
	}

	/**
	 * Returns a string representation of the food item.
	 *
	 * @return The string representation of the food item.
	 */
	public String toString() {
		return "Item: " + getItemCode() + " " + itemName + " " + getItemQuantityInStock() + " price: $" + itemPrice
				+ " cost: $" + itemCost;
	}

	/**
     * Gets the item code.
     *
     * @return The item code.
     */
	public int getItemCode() {
		return itemCode;
	}

	/**
     * Sets the item code.
     *
     * @param itemCode The item code to set.
     */
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	/**
     * Updates the quantity of the food item.
     *
     * @param amount The amount to update the quantity by.
     * @return True if the update is successful, false otherwise.
     */
	public boolean updateItem(int amount) {
		if (this.getItemQuantityInStock() + amount < 0) {
			System.out.println("Insufficient stock. Transaction halted.");
			return false;
		}
		this.setItemQuantityInStock(this.getItemQuantityInStock() + amount);
		return true;
	}

	/**
     * Gets the item quantity in stock.
     *
     * @return The item quantity in stock.
     */
	public int getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	/**
     * Sets the item quantity in stock.
     *
     * @param itemQuantityInStock The item quantity in stock to set.
     */
	public void setItemQuantityInStock(int itemQuantityInStock) {
		this.itemQuantityInStock = itemQuantityInStock;
	}
	
	/**
     * Checks if two FoodItem objects have the same item code.
     *
     * @param item The FoodItem to compare.
     * @return True if the item codes are equal, false otherwise.
     */
	public boolean isEqual(FoodItem item) {
		return this.getItemCode() == item.getItemCode();
	}
	
	/**
     * Adds a new FoodItem to the inventory based on user input.
     *
     * @param scanner The Scanner object for user input.
     * @return True if the item was added successfully, false otherwise.
     */
	public boolean addItem(Scanner scanner) {
        if (!inputCode(scanner))
            return false;

        System.out.print("Enter item name: ");
        itemName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter item quantity: ");
                int quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Invalid quantity. Please enter a non-negative integer.");
                } else {
                    setItemQuantityInStock(quantity);
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid integer.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        while (true) {
            try {
                System.out.print("Enter item cost: ");
                float cost = scanner.nextFloat();
                if (cost < 0) {
                    System.out.println("Invalid cost. Please enter a non-negative float.");
                } else {
                    itemCost = cost;
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid cost. Please enter a valid float.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        while (true) {
            try {
                System.out.print("Enter item sales price: ");
                float price = scanner.nextFloat();
                if (price < 0) {
                    System.out.println("Invalid sales price. Please enter a non-negative float.");
                } else {
                    itemPrice = price;
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid sales price. Please enter a valid float.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        return true;
    }
	
	/**
     * Reads an item code from the user using a Scanner object.
     *
     * @param scanner The Scanner object for user input.
     * @return True if the item code was successfully read, false otherwise.
     */
	public boolean inputCode(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the code for the item: ");
                setItemCode(scanner.nextInt());
                    scanner.nextLine();  // Consume the newline character
                    return true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }
     }
}
