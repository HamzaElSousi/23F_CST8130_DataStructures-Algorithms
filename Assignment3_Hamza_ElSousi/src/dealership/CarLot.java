/**
 * CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * Assignment 3 
 * @Owner/Student Name: Hamza El Sousi	
 * Student Number: 040-982-818
 * Program: CET Computer Science.
 * Course: CST8130 - Data Structures
 * Lab Section: 302
 */

package dealership;

import java.util.HashMap;
import java.util.Map;

/**
 * The CarLot class represents a car inventory storage using a map, where cars are stored and retrieved based on their license plates.
 */
public class CarLot {
	/**
	 * A map that stores car objects with license plates as keys for easy retrieval.
	 */
    private Map<String, Car> carInventory;

    /**
     * Constructs a new CarLot instance with an empty car inventory.
     */
    public CarLot() {
        carInventory = new HashMap<>();
    }

    /**
     * Adds a car to the car inventory.
     *
     * @param car The car to be added to the inventory.
     */
    public void addCar(Car car) {
        carInventory.put(car.getLicensePlate(), car);
    }

    /**
     * Finds and retrieves a car in the inventory based on its license plate.
     *
     * @param licensePlate The license plate of the car to find.
     * @return The Car object if found, or null if not found.
     */
    public Car findCarByLicensePlate(String licensePlate) {
        return carInventory.get(licensePlate);
    }
}