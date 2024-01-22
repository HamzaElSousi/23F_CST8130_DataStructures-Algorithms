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

import java.util.ArrayList;
import java.util.List;

/**
 * A generic Heap data structure implementation.
 *
 * @param <T> The type of elements stored in the heap, must extend Comparable.
 */
public class Heap<T extends Comparable<T>> {
	/** The list representing the heap. */
    private List<T> heapList;

    /**
     * Constructs an empty Heap.
     */
    public Heap() {
        heapList = new ArrayList<>();
    }

    /**
     * Inserts an element into the heap.
     *
     * @param element The element to be inserted.
     */
    public void insert(T element) {
        heapList.add(element);
        heapifyUp();
    }

    /**
     * Restores the heap property by moving the element up to its correct position.
     */
    private void heapifyUp() {
        int index = heapList.size() - 1;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heapList.get(index).compareTo(heapList.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Removes and returns the root element of the heap.
     *
     * @return The removed element or null if the heap is empty.
     */
    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T removedElement = heapList.get(0);

        int lastIndex = heapList.size() - 1;
        heapList.set(0, heapList.get(lastIndex));
        heapList.remove(lastIndex);

        heapifyDown();

        return removedElement;
    }

    /**
     * Restores the heap property by moving the root element down to its correct position.
     */
    private void heapifyDown() {
        int index = 0;
        int size = heapList.size();

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;

            if (leftChildIndex < size && heapList.get(leftChildIndex).compareTo(heapList.get(smallestChildIndex)) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heapList.get(rightChildIndex).compareTo(heapList.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex != index) {
                swap(index, smallestChildIndex);
                index = smallestChildIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return heapList.isEmpty();
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int i, int j) {
        T temp = heapList.get(i);
        heapList.set(i, heapList.get(j));
        heapList.set(j, temp);
    }
}