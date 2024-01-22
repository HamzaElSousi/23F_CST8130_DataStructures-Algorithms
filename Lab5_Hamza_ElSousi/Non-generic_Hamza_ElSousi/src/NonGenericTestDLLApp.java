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
 * This class tests the functionality of the NonGenericDoublyLinkedList class.
 */
public class NonGenericTestDLLApp {
    /**
     * Main method to test the NonGenericDoublyLinkedList functionality.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        NonGenericDoublyLinkedList newLL = new NonGenericDoublyLinkedList();

        // Insert 22, 44, 74, 97 at the front of the linked list
        newLL.insertAtFront(97);
        newLL.insertAtFront(74);
        newLL.insertAtFront(44);
        newLL.insertAtFront(22);

        // Insert 9, 33, 55 at the rear of the linked list
        newLL.insertAtRear(9);
        newLL.insertAtRear(33);
        newLL.insertAtRear(55);

        // Display data elements in the linked list from first to last
        System.out.print("Linked List [From first_to_last]: ");
        newLL.printForwards();

        // Display data elements in the linked list from last to first
        System.out.print("Linked List [From last_to_first]: ");
        newLL.printBackwards();

        // Delete the first item
        newLL.deleteFirstNode();

        // Delete the last item
        newLL.deleteLastNode();

        // Delete item with number 9
        NonGenericDoublyLinkedList.Node deletedNode = newLL.searchAndDelete(9);

        // Display data elements in the linked list from first to last
        System.out.print("Linked List [From first_to_last]: ");
        newLL.printForwards();

        // Insert 69 after 22
        newLL.insertAfter(22, 69);

        // Insert 88 after 33
        newLL.insertAfter(33, 88);

        // Display data elements in the linked list from first to last
        System.out.print("Linked List [From first_to_last]: ");
        newLL.printForwards();
    }
}