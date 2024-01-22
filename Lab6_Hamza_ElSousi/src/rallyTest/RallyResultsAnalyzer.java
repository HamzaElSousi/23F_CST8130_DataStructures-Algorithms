/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Lab 6 
 * @Owner/Student Name: Hamza El Sousi
 * Student Number: 040-982-818
 * Section #: CST8130_302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD.
 */
// RallyResultsAnalyzer.java
package rallyTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import rally.HeapSort;
import rally.RallyTeam;

/**
 * A class that analyzes rally results and generates rankings for each leg of the rally.
 * 
 * Main entry into program
 */
public class RallyResultsAnalyzer {
	 /**
     * The main method to run the rally results analysis.
     *
     * @param args The command-line arguments (not used in this program).
     */
	public static void main(String[] args) {
        List<RallyTeam> rallyTeams = readRallyResults("RallyResults.csv");

        // Sort teams for each leg using Heap Sort
        for (int leg = 1; leg <= 4; leg++) {
            List<RallyTeam> legTeams = filterTeamsByLeg(rallyTeams, leg);

//            HeapSort.heapSort(legTeams);

            System.out.println("Team Rankings for Rally Leg " + leg);
            for (RallyTeam team : legTeams) {
                System.out.println(team);
            }
            System.out.println();
        }
    }

	/**
     * Reads rally results from a CSV file and creates a list of RallyTeam objects.
     *
     * @param filePath The path to the CSV file containing rally results.
     * @return A list of RallyTeam objects representing the rally results.
     */
    private static List<RallyTeam> readRallyResults(String filePath) {
        List<RallyTeam> rallyTeams = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int leg = Integer.parseInt(data[0]);
                String teamName = data[1];
                int time = Integer.parseInt(data[2]);

                RallyTeam team = new RallyTeam(leg, teamName, time);
                rallyTeams.add(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rallyTeams;
    }

    /**
     * Filters a list of RallyTeam objects based on the specified rally leg.
     *
     * @param teams The list of RallyTeam objects to filter.
     * @param leg The rally leg to filter by.
     * @return A list of RallyTeam objects for the specified rally leg.
     */
    private static List<RallyTeam> filterTeamsByLeg(List<RallyTeam> teams, int leg) {
        List<RallyTeam> legTeams = new ArrayList<>();
        for (RallyTeam team : teams) {
            if (team.getLeg() == leg) {
                legTeams.add(team);
            }
        }
        return legTeams;
    }
}