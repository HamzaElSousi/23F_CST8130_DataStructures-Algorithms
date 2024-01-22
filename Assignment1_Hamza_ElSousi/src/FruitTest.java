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
 * The FruitTest class contains JUnit tests for the Fruit class.
 * 
 * @version 1.0
 */
class FruitTest {

    private Fruit fruit;

    /**
     * Initializes a new Fruit object before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        fruit = new Fruit();
    }

    /**
     * Tests the addItem method of the Fruit class.
     */
    @Test
    public void testAddItem() {
        assertTrue(fruit.addItem(new Scanner("30\nApple\n15\n0.3\n0.7\nOrchardY\n")));
        assertEquals("OrchardY", fruit.orchardName);
    }
}