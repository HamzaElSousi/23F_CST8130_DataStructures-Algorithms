/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 *
 * @Owner/Student Name: Hamza El Sousi
 * Student Number: 040-982-818
 * Section #: CST8130 - 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD.
 */


/**
 * This class contains methods for searching elements in arrays using recursive binary search and recursive linear search.
 * @param <T> Generic T extends Comparable class
 */
public class Searching<T extends Comparable<T>> {
	 /**
     * Performs a recursive binary search to find a target element in a sorted array.
     *
     * @param arr    The sorted array to search in.
     * @param target The target element to search for.
     * @param left   The index of the left boundary.
     * @param right  The index of the right boundary.
     * @return The index of the target element if found; otherwise, -1.
     */
	public int recursiveBinarySearch(Comparable[] arr, Comparable<?> target, int left, int right) {
	    if (left <= right) {
	        int mid = left + (right - left) / 2;

	        int comparison = arr[mid].compareTo(target);
	        if (comparison == 0) {
	            return mid; // Element found, return its index
	        } else if (comparison > 0) {
	            return recursiveBinarySearch(arr, target, left, mid - 1);
	        } else {
	            return recursiveBinarySearch(arr, target, mid + 1, right);
	        }
	    }

	    return -1; // Element not found
	    }

	/**
     * Performs a recursive linear search to find a target element in an array.
     *
     * @param randomArr The array to search in.
     * @param target    The target element to search for.
     * @param index     The current index during the search.
     * @return The index of the target element if found; otherwise, -1.
     */
    public int linearSearch(Comparable[] randomArr, T target, int index) {
        if (index == randomArr.length) {
            return -1; // Element not found
        }

        if (randomArr[index].equals(target)) {
            return index; // Element found, return its index
        }

        return linearSearch(randomArr, target, index + 1);
    }
}
