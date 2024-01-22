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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * The InventoryTest class contains JUnit tests for the Inventory class.
 * 
 * @version 2.0
 * includes test cases for buy and sell. 
 */
public class InventoryTest {

    private Inventory inventory;

    /**
     * Initializes a new Inventory object before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    /**
     * Tests the addItem method of the Inventory class.
     */
    @Test
    public void testAddItem() {
        assertTrue(inventory.addItem(new Scanner("f\n10\nApple\n5\n0.5\n1.5\nOrchard\n")));
        assertEquals(1, inventory.numItems);

        assertFalse(inventory.addItem(new Scanner("f\n10\nOrange\n5\n0.5\n1.5\nOrchard\n"))); // Duplicate
    }

    /**
     * Tests the maximum inventory limit of the Inventory class.
     */
    @Test
    public void testMaxInventoryLimit() {
        for (int i = 0; i < Inventory.MAX_ITEMS; i++) {
            assertTrue(inventory.addItem(new Scanner("f\n" + (i + 10) + "\nFruit" + i + "\n5\n0.5\n1.5\nOrchard" + i + "\n")));
        }
        assertEquals(Inventory.MAX_ITEMS, inventory.numItems);

        // Try adding one more item beyond the maximum limit
        assertFalse(inventory.addItem(new Scanner("f\n999\nExcessFruit\n5\n0.5\n1.5\nExcessOrchard\n")));
    }
    
    /**
     * Tests the buying operation for an item in the inventory.
     * The test first adds an item with the code '10' and then tries to buy '5' quantities of that item.
     * The test asserts that the item addition is successful and the buying operation is successful.
     */
    @Test
    public void testBuyItem() {
        // Add item to inventory with code 10
        assertTrue(inventory.addItem(new Scanner("f\n10\nApple\n5\n0.5\n1.5\nOrchard\n")));

        String input = "10\n5\n"; // Code: 10, Quantity: 5
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to read from our byte array

        assertTrue(inventory.updateQuantity(new Scanner(System.in), true));
    }
    
    /**
     * Tests the selling operation for an item in the inventory.
     * The test first adds an item with the code '111' and then tries to sell '5' quantities of that item.
     * The test asserts that the item addition is successful and the selling operation is successful.
     */
    @Test
    public void testSellItem() {
        // Add item to inventory with code 111
        assertTrue(inventory.addItem(new Scanner("f\n111\nOrange\n5\n0.5\n1.5\nOrchard\n")));

        String input = "111\n5\n"; // Code: 111, Quantity: 5
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Set System.in to read from our byte array

        assertTrue(inventory.updateQuantity(new Scanner(System.in), false));
    }

    // Add tests for other methods if need be
}
