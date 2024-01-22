/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * Lab 5 
 * @Owner/Student Name: Hamza El Sousi	
 * Student Number: 040-982-818
 * Program: CET Computer Science.
 * Course: CST8130 - Data Structures
 * Lab Section: 302
 */

/**
 * This class represents a doubly linked list with generic data type.
 *
 * @param <T> the data type for the elements in the linked list.
 */
public class DoublyLinkedList<T> {
    /**
     * Represents the first node in the linked list.
     */
    private Node<T> first;

    /**
     * Represents the last node in the linked list.
     */
    private Node<T> last;

    /**
     * Inner class representing a node in the linked list.
     *
     * @param <T> the data type for the node's data.
     */
    class Node<T> {
        /**
         * The data stored in the node.
         */
        T mData;

        /**
         * Reference to the next node in the list.
         */
        Node<T> next;

        /**
         * Reference to the previous node in the list.
         */
        Node<T> previous;
    }

    /**
     * Inserts mData at the front of the linked list.
     *
     * @param mData the data to be inserted.
     */
    public void insertAtFront(T mData) {
        Node<T> newNode = new Node<>();
        newNode.mData = mData;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
    }

    /**
     * Inserts mData at the rear of the linked list.
     *
     * @param mData the data to be inserted.
     */
    public void insertAtRear(T mData) {
        Node<T> newNode = new Node<>();
        newNode.mData = mData;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * Inserts new mData after a given element in the linked list.
     *
     * @param mData    the mData to insert.
     * @param newData the data after which to insert the new data.
     */
    public void insertAfter(T mData, T newData) {
        Node<T> newNode = new Node<>();
        newNode.mData = newData;

        Node<T> current = first;
        while (current != null) {
            if (current.mData.equals(mData)) {
                newNode.next = current.next;
                newNode.previous = current;
                current.next = newNode;

                if (current == last) {
                    last = newNode;
                } else {
                    newNode.next.previous = newNode;
                }

                return;
            }
            current = current.next;
        }
    }

    /**
     * Deletes the first node in the linked list.
     */
    public void deleteFirstNode() {
        if (!isEmpty()) {
            first = first.next;
            if (first == null) {
                last = null;
            } else {
                first.previous = null;
            }
        }
    }

    /**
     * Deletes the last node in the linked list.
     */
    public void deleteLastNode() {
        if (!isEmpty()) {
            last = last.previous;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    /**
     * Searches for and deletes a node containing the given data.
     *
     * @param mData the data to search and delete.
     * @return the deleted node or null if not found.
     */
    public Node<T> searchAndDelete(T mData) {
        Node<T> current = first;
        while (current != null) {
            if (current.mData.equals(mData)) {
                if (current == first) {
                    deleteFirstNode();
                } else if (current == last) {
                    deleteLastNode();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Prints the mData elements in the linked list from first to last.
     */
    public void printForwards() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.mData + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Prints the mData elements in the linked list from last to first.
     */
    public void printBackwards() {
        Node<T> current = last;
        while (current != null) {
            System.out.print(current.mData + " ");
            current = current.previous;
        }
        System.out.println();
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
}
