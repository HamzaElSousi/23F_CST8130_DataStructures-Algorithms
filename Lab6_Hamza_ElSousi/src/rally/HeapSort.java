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

package rally;

import java.util.List;
/**
 * A class containing the implementation of the Heap Sort algorithm for sorting lists.
 */
public class HeapSort {

	/**
     * Sorts a list using the Heap Sort algorithm.
     *
     * @param list The list to be sorted. Elements in the list must implement the Comparable interface.
     * @param <T> The type of elements in the list, must extend Comparable.
     */
    public static <T extends Comparable<T>> void heapSort(List<T> list) {
        int n = list.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // One by one extract an element from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Call max heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    /**
     * Heapifies a subtree rooted at the given index.
     *
     * @param list The list to be heapified.
     * @param n The size of the heap.
     * @param i The index of the root of the subtree to be heapified.
     * @param <T> The type of elements in the list, must extend Comparable.
     */
    private static <T extends Comparable<T>> void heapify(List<T> list, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}