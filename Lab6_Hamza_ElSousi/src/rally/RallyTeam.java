/**
 * Represents a team participating in a rally with information about the team's name, leg, and completion time.
 * 
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Lab 6 
 * @Owner/Student Name: Hamza El Sousi
 * Student Number: 040-982-818
 * Section #: CST8130_302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD.
 */
package rally;
/**
 * A class to represent a rally team.
 */
public class RallyTeam implements Comparable<RallyTeam> {
	/** The name of the rally team. */
	private String teamName;
	/** The leg of the rally. */
	private int leg;
	/** The completion time of the rally */
	private int time;

	/**
	 * Constructs a RallyTeam with the specified leg, team name, and completion
	 * time.
	 *
	 * @param leg      The leg of the rally.
	 * @param teamName The name of the rally team.
	 * @param time     The completion time of the rally team.
	 */
	public RallyTeam(int leg, String teamName, int time) {
		this.leg = leg;
		this.teamName = teamName;
		this.time = time;
	}

	/**
     * Compares this RallyTeam to another based on their completion times.
     *
     * @param other The RallyTeam to compare to.
     * @return A negative integer, zero, or a positive integer if this RallyTeam's time is less than, equal to,
     *         or greater than the time of the specified RallyTeam.
     */
	@Override
	public int compareTo(RallyTeam other) {
		return Integer.compare(this.time, other.time);
	}

	 /**
     * Returns a string representation of the RallyTeam.
     *
     * @return A formatted string including the team name and completion time.
     */
	@Override
	public String toString() {
		return String.format("%20s %10d", teamName, time);
	}

	/**
     * Gets the leg of the rally for this team.
     *
     * @return The leg of the rally.
     */
	public int getLeg() {
		return leg;
	}
}
