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

/**
 * The Car class represents a car with attributes such as year, make, and license plate.
 */
public class Car {
	/** The year of the car. */
	private int year;
	/** The make or manufacturer of the car. */
    private String make;
    /** The license plate of the car. */
    private String licensePlate;

    /**
     * Constructs a new Car instance with the specified year, make, and license plate.
     *
     * @param year         The year of the car.
     * @param make         The make or manufacturer of the car.
     * @param licensePlate The license plate of the car.
     */
    public Car(int year, String make, String licensePlate) {
        this.year = year;
        this.make = make;
        this.licensePlate = licensePlate;
    }

    /**
     * Gets the year of the car.
     *
     * @return The year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the make or manufacturer of the car.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }
    
    /**
     * Gets the license plate of the car.
     *
     * @return The license plate of the car.
     */
    public String getLicensePlate() {
        return licensePlate;
    }
}
