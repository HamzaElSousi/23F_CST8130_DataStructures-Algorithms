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
 * The main class for the inventory management program.
 */
public class Assign1 {
    /**
     * Main entry point to program.
     * @version 1.0
     * 
     * @param args Console arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        displayMenu();
        while (true) {
            try {
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter an integer between 1 and 5.");
                    scanner.nextLine(); // Clear the input buffer
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                switch (choice) {
                    case 1:
                        System.out.println("Adding Item to Inventory...");
                        inventory.addItem(scanner);
                        break;
                    case 2:
                        System.out.println("Displaying Current Inventory...");
                        System.out.println(inventory);
                        break;
                    case 3:
                        System.out.println("Buying Item(s)...");
                        if (!inventory.updateQuantity(scanner, true)) {
                            System.out.println("Error... Could not buy item");
                        }
                        break;
                    case 4:
                        System.out.println("Selling Item(s)...");
                        if (!inventory.updateQuantity(scanner, false)) {
                            System.out.println("Error... Could not sell item");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; // Graceful exit
                    default:
                        System.out.println("Incorrect value entered. Please choose 1-5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer between 1 and 5.");
                scanner.nextLine(); // Clear the input buffer
            } 
            displayMenu();
        }
    }
    
    /**
     * Displays the main menu to the console.
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Item to Inventory");
        System.out.println("2: Display Current Inventory");
        System.out.println("3: Buy Item(s)");
        System.out.println("4: Sell Item(s)");
        System.out.println("5: To Exit");
        System.out.print("> ");
    }
}
