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
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * 'AllTests' is a Junit test suite to combine-run multiple Junit tests. 
 */
@Suite
@SelectClasses({ FoodItemTest.class, FruitTest.class, InventoryTest.class, PreserveTest.class, VegetableTest.class })
public class AllTests {

}
