package Double_Linked_Lists;

/**
 * @author Tchindro Sossa
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Double_Linked_Lists.SortedDoubleLinkedList.NaturalOrderComparator;

import java.util.Comparator;

public class SortedDoubleLinkedList_STUDENT_Test {

    private SortedDoubleLinkedList<Integer> sortedList;

    @Before
    public void setUp() {
        Comparator<Integer> integerComparator = new SortedDoubleLinkedList.IntegerComparator();
        sortedList = new SortedDoubleLinkedList<>(integerComparator);
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);
    }

    @Test
    public void testAdd() {
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);

        assertEquals(1, sortedList.getFirst().intValue());
        assertEquals(3, sortedList.getLast().intValue());
        assertEquals(6, sortedList.getSize());
    }
    
    @Test
    public void testAddAndSize() {
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);

        assertEquals(1, sortedList.getFirst().intValue());
        assertEquals(3, sortedList.getLast().intValue());
        assertEquals(6, sortedList.getSize());
    }

    @Test
    public void testRemove() {
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);

        assertTrue(sortedList.remove(1, new NaturalOrderComparator<Integer>()));
        assertFalse(sortedList.remove(4, new NaturalOrderComparator<Integer>()));

        assertEquals(5, sortedList.getSize());
        assertEquals(1, sortedList.getFirst().intValue());
        assertEquals(3, sortedList.getLast().intValue());
    }
    
    @Test
    public void testRemoveExistingElement() {
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);

        assertTrue(sortedList.remove(1, new NaturalOrderComparator<Integer>()));
        assertEquals(5, sortedList.getSize());
        assertEquals(1, sortedList.getFirst().intValue());
        assertEquals(3, sortedList.getLast().intValue());
    }
    
    @Test
    public void testRemoveNonExistingElement() {
        sortedList.add(3);
        sortedList.add(1);
        sortedList.add(2);

        assertFalse(sortedList.remove(4, new NaturalOrderComparator<Integer>()));
        assertEquals(6, sortedList.getSize());
        assertEquals(1, sortedList.getFirst().intValue());
        assertEquals(3, sortedList.getLast().intValue());
    }

    @Test
    public void testIterator() {
        StringBuilder result = new StringBuilder();
        for (Integer value : sortedList) {
            result.append(value);
        }

        assertEquals("123", result.toString());
    }
}
