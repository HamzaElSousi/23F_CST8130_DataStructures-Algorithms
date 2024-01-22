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
 * This class represents the main program for managing an inventory of food items.
 * It allows users to add, display, buy, sell, search for, save, and load items from an inventory.
 */
public class Assign2 {
    /**
     * The main method that serves as the entry point of the program.
     * @version 2.0
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        @SuppressWarnings("rawtypes")
		Inventory inventory = new Inventory();

        int choice;
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Please select one of the following:");
            System.out.println("1: Add Item to Inventory");
            System.out.println("2: Display Current Inventory");
            System.out.println("3: Buy Item(s)");
            System.out.println("4: Sell Item(s)");
            System.out.println("5: Search for Item");
            System.out.println("6: Save Inventory to File");
            System.out.println("7: Read Inventory from File");
            System.out.println("8: To Exit\n>");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        inventory.addItem(scanner, false);
                        break;
                    case 2:
                        System.out.println(inventory);
                        break;
                    case 3:
                        inventory.updateQuantity(scanner, true);
                        break;
                    case 4:
                        inventory.updateQuantity(scanner, false);
                        break;
                    case 5:
                        inventory.searchForItem(scanner);
                        break;
                    case 6:
                        inventory.saveToFile(scanner);
                        break;
                    case 7:
                        inventory.readFromFile(scanner);
                        break;
                    case 8:
                        continueRunning = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
