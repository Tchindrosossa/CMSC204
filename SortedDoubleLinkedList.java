package Double_Linked_Lists;

/**
 * @author Tchindro Sossa
 */

import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    // Constructor for SortedDoubleLinkedList
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super(); 		// Call the constructor of the superclass
        this.comparator = comparator;
    }
    

    // Inner class for IntegerComparator
    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    // Override the addToFront method (unsupported operation)
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Cannot add to the front of a sorted list.");
    }

    // Override the addToEnd method (unsupported operation)
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Cannot add to the end of a sorted list.");
    }

    // Add a new node with sorted placement
    public void add(T data) {
    	
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (comparator.compare(data, head.data) <= 0) {
        	// Insert at the begining
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current != null && comparator.compare(data, current.data) > 0) {
                current = current.next;
            }
            if (current == null) {
            	// Insert at the end
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            } else {
            	// Insert in the middle
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

	// Defines a custom comparator for natural order
    static class NaturalOrderComparator<T extends Comparable<T>> implements Comparator<T> {
        @Override
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}