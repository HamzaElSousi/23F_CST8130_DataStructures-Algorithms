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

package programEntryPoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dealership.Car;
import dealership.CarLot;

/**
 * This class represents the entry point of the program for simulating Honest AC's Used Car Lot.
 */
public class CarLotTest {
	/**
     * The main method that reads data from files, manages car inventory, and generates a report.
     * 
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        CarLot carLot = new CarLot();
        
        // Get the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        
        // Read the CSV file and add cars to the CarLot
        try (BufferedReader csvReader = new BufferedReader(new FileReader("car_inventory.csv"))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] parts = line.split(",");
                int year = Integer.parseInt(parts[0].trim());
                String make = parts[1].trim();
                String licensePlate = parts[2].trim();
                Car car = new Car(year, make, licensePlate);
                carLot.addCar(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Read the text file with license plates and print the report
        try (BufferedReader txtReader = new BufferedReader(new FileReader("car_search.txt"))) {
            String line;
            System.out.printf("Car Lot used inventory for %s\n", formattedDate);
            while ((line = txtReader.readLine()) != null) {
                String licensePlate = line.trim();
                Car car = carLot.findCarByLicensePlate(licensePlate);
                if (car != null) {
                    System.out.printf("%s %d %s %n", licensePlate, car.getYear(), car.getMake());
                } else {
                    System.out.printf("\n%s", licensePlate + "\t\tNot Found");//like licenses not paired to vehicle 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * A SimpleDateFormat instance for formatting the current date.
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Represents the current date.
     */
    Date currentDate = new Date();
    /**
     * A string representation of the current date in the "yyyy-MM-dd" format.
     */
    String formattedDate = dateFormat.format(currentDate);

}    
