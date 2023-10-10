package Double_Linked_Lists;

/**
 * @author Tchindro Sossa
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Double_Linked_Lists.SortedDoubleLinkedList.NaturalOrderComparator;

public class BasicDoubleLinkedList_STUDENT_Test {

    private BasicDoubleLinkedList<String> stringList; // Declare stringList for testing with strings
    private BasicDoubleLinkedList<Integer> intList; // Declare intList for testing with integers

    @Before
    public void setUp() {
        stringList = new BasicDoubleLinkedList<String>(); // Initialize stringList
        intList = new BasicDoubleLinkedList<Integer>(); // Initialize intList
    }

    @Test
    public void testAddToFrontAndEnd() {
        stringList.addToFront("World");
        stringList.addToEnd("Hello");

        assertEquals("World", stringList.getFirst());
        assertEquals("Hello", stringList.getLast());
        assertEquals(2, stringList.getSize());
    }

    @Test
    public void testRetrieveFirstAndLastElement() {
        stringList.addToFront("World");
        stringList.addToEnd("Hello");

        assertEquals("World", stringList.retrieveFirstElement());
        assertEquals("Hello", stringList.retrieveLastElement());
        assertEquals(0, stringList.getSize());
    }

    @Test
    public void testRemove() {
        stringList.addToFront("World");
        stringList.addToEnd("Hello");
        stringList.addToEnd("Hello");

        assertTrue(stringList.remove("Hello", new BasicDoubleLinkedList.StringComparator()));
        assertFalse(stringList.remove("NotInList", new BasicDoubleLinkedList.StringComparator()));

        assertEquals(2, stringList.getSize());
        assertEquals("World", stringList.getFirst());
        assertEquals("Hello", stringList.getLast());
    }

    @Test
    public void testRemoveExistingElement() {
        intList.addToFront(1);
        intList.addToEnd(2);

        assertTrue(intList.remove(1, new NaturalOrderComparator<Integer>()));
        assertEquals(1, intList.getSize());
        assertEquals(2, intList.getFirst().intValue());
        assertEquals(2, intList.getLast().intValue());
    }

    @Test
    public void testRemoveNonExistingElement() {
        intList.addToFront(1);
        intList.addToEnd(2);

        assertFalse(intList.remove(3, new NaturalOrderComparator<Integer>()));
        assertEquals(2, intList.getSize());
        assertEquals(1, intList.getFirst().intValue());
        assertEquals(2, intList.getLast().intValue());
    }

    @Test
    public void testIterator() {
        intList.addToEnd(1);
        intList.addToEnd(2);
        intList.addToEnd(3);

        int sum = 0;
        for (Integer value : intList) {
            sum += value;
        }

        assertEquals(6, sum);
    }

    @Test
    public void testToArrayList() {
        intList.addToEnd(1);
        intList.addToEnd(2);
        intList.addToEnd(3);

        assertEquals(1, intList.toArrayList().get(0).intValue());
        assertEquals(2, intList.toArrayList().get(1).intValue());
        assertEquals(3, intList.toArrayList().get(2).intValue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(intList.isEmpty());

        intList.addToFront(1);
        assertFalse(intList.isEmpty());

        intList.retrieveFirstElement();
        assertTrue(intList.isEmpty());
    }
    
    @Test
    public void testAddToFrontEmptyList() {
        assertEquals(0, stringList.getSize());
        stringList.addToFront("Hello");
        assertEquals(1, stringList.getSize());
        assertEquals("Hello", stringList.getFirst());
        assertEquals("Hello", stringList.getLast());
    }

    @Test
    public void testAddToFrontNonEmptyList() {
        stringList.addToEnd("World");
        stringList.addToFront("Hello");
        assertEquals(2, stringList.getSize());
        assertEquals("Hello", stringList.getFirst());
        assertEquals("World", stringList.getLast());
    }

    @Test
    public void testRetrieveFirstElementEmptyList() {
        assertNull(stringList.retrieveFirstElement());
    }

    @Test
    public void testRetrieveFirstElementNonEmptyList() {
        stringList.addToEnd("Hello");
        stringList.addToEnd("World");
        assertEquals("Hello", stringList.retrieveFirstElement());
        assertEquals(1, stringList.getSize());
        assertEquals("World", stringList.getFirst());
    }

    @Test
    public void testRetrieveLastElementEmptyList() {
        assertNull(stringList.retrieveLastElement());
    }

    @Test
    public void testRetrieveLastElementNonEmptyList() {
        stringList.addToEnd("Hello");
        stringList.addToEnd("World");
        assertEquals("World", stringList.retrieveLastElement());
        assertEquals(1, stringList.getSize());
        assertEquals("Hello", stringList.getLast());
    }

    @Test
    public void testRemoveFirstElement() {
        stringList.addToEnd("Hello");
        stringList.addToEnd("World");
        stringList.remove("Hello", new BasicDoubleLinkedList.StringComparator());
        assertEquals(1, stringList.getSize());
        assertEquals("World", stringList.getFirst());
        assertEquals("World", stringList.getLast());
    }

    @Test
    public void testRemoveLastElement() {
        stringList.addToEnd("Hello");
        stringList.addToEnd("World");
        stringList.remove("World", new BasicDoubleLinkedList.StringComparator());
        assertEquals(1, stringList.getSize());
        assertEquals("Hello", stringList.getFirst());
        assertEquals("Hello", stringList.getLast());
    }

    @Test
    public void testIsEmptyEmptyList() {
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testIsEmptyNonEmptyList() {
        stringList.addToEnd("Hello");
        assertFalse(stringList.isEmpty());
    }
}