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

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The VegetableTest class contains JUnit tests for the Vegetable class.
 * 
 * @version 1.0
 */
class VegetableTest {

    private Vegetable vegetable;

    /**
     * Initializes a new Vegetable object before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        vegetable = new Vegetable();
    }

    /**
     * Tests the addItem method of the Vegetable class.
     */
    @Test
    public void testAddItem() {
        assertTrue(vegetable.addItem(new Scanner("20\nCarrot\n10\n0.2\n0.5\nFarmX\n")));
        assertEquals("FarmX", vegetable.farmName);
    }
}
