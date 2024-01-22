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

import java.util.Collections; 
import java.util.Comparator;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

/**
 * This class represents an inventory of FoodItems and provides methods to manage its properties.
 * @param <T> The type of FoodItem stored in the inventory.
 * @version 2.0
 */
public class Inventory<T extends FoodItem<T>> implements Comparable<T>{
	/**
	 * MAX_ITEMS is the max size of inventory 
	 */
	private static final int MAX_ITEMS = 20;
	/**
	 * ArrayList to store inventory 
	 */
    protected ArrayList<T> inventory;

    /**
     * Default constructor for Inventory.
     */
    public Inventory() {
        inventory = new ArrayList<T>();
    }

    /**
     * Returns a string representation of the inventory.
     *
     * @return A string representing the inventory.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Inventory:\n");
        for (T item : inventory) {
            result.append(item).append("\n");
        }
        return result.toString();
    }

    /**
     * Adds a new FoodItem to the inventory.
     *
     * @param scanner   The Scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    @SuppressWarnings("unchecked")
	public boolean addItem(Scanner scanner, boolean fromFile) {
        if (inventory.size() >= MAX_ITEMS) {
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
                } else {
                    throw new InputMismatchException("Invalid entry. Please select f, v, or p.");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();  // Consume the invalid input
            }
        }

        T newItem = null;

        switch (choice) {
            case 'f':
                newItem = (T) new Fruit();
                break;
            case 'v':
                newItem = (T) new Vegetable();
                break;
            case 'p':
                newItem = (T) new Preserve();
                break;
            default:
                System.out.println("Invalid choice. Please select f, v, or p.");
                return false;
        }

        if (newItem != null && newItem.addItem(scanner, fromFile)) {
            int existingIndex = alreadyExists(newItem);
            if (existingIndex != -1) {
                System.out.println("Item code already exists.");
                return false;
            }

            inventory.add(newItem);
            if (!fromFile) {
                // Only sort when adding from user input, not from file
                sortInventory();
            }
            return true;
        }

        return false;
    }
    
    /**
     * Searches for a FoodItem in the inventory by its item code.
     *
     * @param scanner The Scanner object for user input.
     */
    public void searchForItem(Scanner scanner) {
        if (inventory.isEmpty()) { 
            System.out.println("Inventory is empty. Cannot search for items.");
            return;
        }

        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int code = scanner.nextInt();
            int index = binarySearchByItemCode(code);

            if (index == -1) {
                System.out.println("Code not found in inventory...");
            } else {
                T item = inventory.get(index);
                System.out.println(item);
            }
        } else {
            System.out.println("Invalid code...");
        }
    }

    /**
     * Saves the inventory data to a file.
     *
     * @param scanner The Scanner object for user input.
     */
    public void saveToFile(Scanner scanner) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Nothing to save.");
            return;
        }

        System.out.print("Enter the filename to save to: ");
        String filename = scanner.nextLine();

        try (Formatter writer = new Formatter(new FileWriter(filename))) {
            for (FoodItem<?> item : inventory) {
                // Write the item type (e.g., "f" for fruit) to the file
                writer.format("%s%n", item.getItemType());
                
                // Write the item code, item name, quantity, cost, and price to the file
                writer.format("%d%n%s%n%d%n%.2f%n%.2f%n", item.getItemCode(), item.getItemName(), item.getItemQuantityInStock(), item.getItemCost(), item.getItemPrice());
                
                // Check if there is additional info (e.g., supplier) and write it to the file
                if (item instanceof Fruit) {
                    writer.format("%s%n", ((Fruit) item).getOrchardSupplier());
                } else if (item instanceof Vegetable) {
                    writer.format("%s%n", ((Vegetable) item).getFarmSupplier());
                } else if (item instanceof Preserve) {
                    writer.format("%s%n", ((Preserve) item).getJarSize());
                }
            }
            System.out.println("Inventory data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error while saving to the file: " + e.getMessage());
        }}

    /**
     * Reads inventory data from a file and populates the inventory.
     *
     * @param scanner The Scanner object for user input.
     */
    @SuppressWarnings("unchecked")
	public void readFromFile(Scanner scanner) {
        System.out.print("Enter the filename to read from: ");
        String filename = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                String type = fileScanner.nextLine();
                int itemCode;
                String itemName;
                int itemQuantityInStock;
                double itemCost;
                double itemPrice;
                String itemSupplier;

                try {
                    itemCode = Integer.parseInt(fileScanner.nextLine());
                    itemName = fileScanner.nextLine();
                    itemQuantityInStock = Integer.parseInt(fileScanner.nextLine());
                    itemCost = Double.parseDouble(fileScanner.nextLine());
                    itemPrice = Double.parseDouble(fileScanner.nextLine());
                    itemSupplier = fileScanner.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing item details in the file: " + e.getMessage());
                    continue;
                }

                T newItem;

                switch (type) {
                    case "f":
                        newItem = (T) new Fruit(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, itemSupplier);
                        break;
                    case "v":
                        newItem = (T) new Vegetable(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, itemSupplier);
                        break;
                    case "p":
                        newItem = (T) new Preserve(itemCode, itemName, itemQuantityInStock, itemCost, itemPrice, itemSupplier);
                        break;
                    default:
                        System.out.println("Invalid item type in the file: " + type);
                        continue;
                }

                int existingIndex = alreadyExists(newItem);
                if (existingIndex != -1) {
                    System.out.println("Item code already exists. Skipping...");
                    continue;
                }

                inventory.add(newItem);
            }
            System.out.println("Inventory data read from " + filename);
            sortInventory();
        } catch (IOException e) {
            System.out.println("Error while reading from the file: " + e.getMessage());
        }
    }

    /**
     * Sorts the inventory based on item code.
     */
    private void sortInventory() {
    	
        // Sort the inventory ArrayList based on itemCode
        Collections.sort(inventory);
        }

    /**
     * Checks if a FoodItem already exists in the inventory.
     *
     * @param item The FoodItem to check for existence.
     * @return The index of the existing item, or -1 if not found.
     */
    private int alreadyExists(T item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).isEqual(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search to find a FoodItem in the inventory by its item code.
     *
     * @param code The item code to search for.
     * @return The index of the item, or -1 if not found.
     */
    private int binarySearchByItemCode(int code) {
        int left = 0;
        int right = inventory.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T currentItem = inventory.get(mid);

            if (currentItem.getItemCode() == code) {
                return mid; // Item found at index 'mid'
            } else if (currentItem.getItemCode() < code) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Item not found
    }

    /**
     * Updates the quantity of a FoodItem in the inventory (buy or sell).
     *
     * @param scanner    The Scanner object for user input.
     * @param buyOrSell  True for buying, false for selling.
     */
    public void updateQuantity(Scanner scanner, boolean buyOrSell) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Cannot update quantity.");
            return;
        }

        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int code = scanner.nextInt();
            int index = binarySearchByItemCode(code);

            if (index == -1) {
                System.out.println("Code not found in inventory...");
                return;
            }

            T item = inventory.get(index);
            System.out.print("Enter valid quantity to " + (buyOrSell ? "buy" : "sell") + ": ");
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                if (buyOrSell) {
                    item.updateItem(quantity);
                    System.out.println("Quantity updated successfully.");
                } else {
                    if (item.updateItem(-quantity)) {
                        System.out.println("Quantity updated successfully.");
                    } else {
                        System.out.println("Error updating quantity. Not enough quantity to sell.");
                    }
                }
            } else {
                System.out.println("Invalid quantity...");
            }
        } else {
            System.out.println("Invalid code...");
        }
    }

	@Override
	public int compareTo(FoodItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
