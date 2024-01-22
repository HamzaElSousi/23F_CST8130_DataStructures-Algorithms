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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The FoodItemTest class contains JUnit tests for the FoodItem class.
 * 
 * @version 1.0
 */
class FoodItemTest {

    private FoodItem item;

    /**
     * Initializes a new FoodItem object before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        item = new FoodItem();
    }

    /**
     * Tests the updateItem method of the FoodItem class.
     */
    @Test
    public void testUpdateItem() {
        assertTrue(item.updateItem(5));
        assertEquals(5, item.getItemQuantityInStock());

        assertTrue(item.updateItem(-3));
        assertEquals(2, item.getItemQuantityInStock());

        assertFalse(item.updateItem(-10));
    }

    /**
     * Tests the isEqual method of the FoodItem class.
     */
    @Test
    public void testIsEqual() {
        FoodItem anotherItem = new FoodItem();
        assertTrue(item.isEqual(anotherItem));

        anotherItem.setItemCode(10);
        assertFalse(item.isEqual(anotherItem));
    }
}
