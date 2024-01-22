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
 * Represents an inventory of food items.
 * 
 * @version 1.0
 */
public class Inventory {
    private FoodItem[] inventory;
    /**
     * 
     */
    protected int numItems;
    /**
     * 
     */
    protected static final int MAX_ITEMS = 20;
    
    /**
     * Default constructor for Inventory.
     */
    public Inventory() {
        inventory = new FoodItem[MAX_ITEMS];
        numItems = 0;
    }

    /**
     * Returns a string representation of the inventory.
     *
     * @return The string representation of the inventory.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Inventory:\n");
        for (int i = 0; i < numItems; i++) {
            result.append(inventory[i].toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Checks if a FoodItem with the same item code already exists in the inventory.
     *
     * @param item The FoodItem to check.
     * @return The index of the existing FoodItem or -1 if not found.
     */
    public int alreadyExists(FoodItem item) {
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].isEqual(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds a new item to the inventory.
     *
     * @param scanner The scanner to read input from.
     * @return true if the item is successfully added, false otherwise.
     */
    public boolean addItem(Scanner scanner) {
        if (numItems >= MAX_ITEMS) {
            System.out.println("Inventory is full. Cannot add more items.");
            return false;
        }
        char choice;

        while (true) {
            try {
                System.out.print("Do you wish to add a fruit(f), vegetable(v), or a preserve(p)? ");
                String input = scanner.nextLine().toLowerCase();

                if (input.length() == 1) {
                    choice = input.charAt(0);
                    if (choice == 'f' || choice == 'v' || choice == 'p') {
                        break;  // Valid choice, exit the loop
                    }
                }

                throw new InputMismatchException("Invalid entry. Please select f, v, or p.");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        FoodItem newItem = null;

        switch (choice) {
            case 'f':
                newItem = new Fruit();
                break;
            case 'v':
                newItem = new Vegetable();
                break;
            case 'p':
                newItem = new Preserve();
                break;
            default:
                System.out.println("Invalid choice. Please select f, v, or p.");
                return false;
        }

        if (newItem != null && newItem.addItem(scanner)) {
            int existingIndex = alreadyExists(newItem);
            if (existingIndex != -1) {
                System.out.println("Item code already exists.");
                return false;
            }

            inventory[numItems++] = newItem;
            return true;
        }

        return false;
    }

    /**
     * Updates the quantity of an item in the inventory.
     *
     * @param scanner   The scanner to read input from.
     * @param buyOrSell true for buying, false for selling.
     * @return true if the update is successful, false otherwise.
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        if (numItems == 0) {
            System.out.println("Error...could not " + (buyOrSell ? "buy" : "sell") + " item. Inventory is empty.");
            return false;
        }
    System.out.print("Enter the code for the item: ");
    if (scanner.hasNextInt()) {
        int code = scanner.nextInt();
        int index = -1;

        for (int i = 0; i < numItems; i++) {
            if (inventory[i].getItemCode() == code) {  // Fixed the code comparison
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Code not found in inventory...");
            return false;
        }

        FoodItem item = inventory[index];
        System.out.print("Enter valid quantity to " + (buyOrSell ? "buy" : "sell") + ": ");
        if (scanner.hasNextInt()) {
            int quantity = scanner.nextInt();
            return buyOrSell ? item.updateItem(quantity) : item.updateItem(-quantity);
        } else {
            System.out.println("Invalid quantity...");
        }
    } else {
        System.out.println("Invalid code...");
    }

    System.out.println("Error...could not " + (buyOrSell ? "buy" : "sell") + " item");
    return true;
}
}