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
 * The PreserveTest class contains JUnit tests for the Preserve class.
 * 
 * @version 1.0
 */
public class PreserveTest {

    private Preserve preserve;

    /**
     * Initializes a new Preserve object before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        preserve = new Preserve();
    }

    /**
     * Tests the addItem method of the Preserve class.
     */
    @Test
    public void testAddItem() {
        assertTrue(preserve.addItem(new Scanner("10\nJam\n5\n0.5\n1.5\n200\n")));
        assertEquals(200, preserve.jarSize);
    }
}
