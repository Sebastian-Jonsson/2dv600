package sj223gb_assign2.exercise4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;


/**
* Class that tests the GenericQueue from exercise 4.
* Instantiates new queues in the tests of different data types to make certain the generic type is possible.
* Junit5 is used.
*
* @version 1.1 28 September 2021
* @author Sebastian Jonsson
*/
public class QueueTest {

    private static final int intElement = 37;
    private static final String stringElement = "37";
    private static final int lotsOfLoops = 1000;


    /**
     * Tests the size before and after adding/removing new elements.
     * Also tests the exception when a size shrinks to zero and reconfirms the size after that.
     */
    @Test
    public void testSize() {
        Queue<Integer> intQueue = new GenericQueue<Integer>();
        Queue<String> stringQueue = new GenericQueue<String>();

        assertEquals("Size is zero before adding any integer elements: ", 0, intQueue.size());
        assertEquals("Size is zero before adding any string elements: ", 0, stringQueue.size());

        intQueue.enqueue(intElement);
        stringQueue.enqueue(stringElement);

        assertEquals("Size has increased after adding integer elements: ", 1, intQueue.size());
        assertEquals("Size has increased after adding string elements: ", 1, stringQueue.size());

        assertThrows("Should throw when called on just emptied integer queue: ", NoSuchElementException.class, () -> intQueue.dequeue());
        assertThrows("Should throw when called on just emptied string queue: ", NoSuchElementException.class, () -> stringQueue.dequeue());

        assertEquals("Size is reduced after removing the first integer element: ", 0, intQueue.size());
        assertEquals("Size is reduced after removing the first string element: ", 0, stringQueue.size());
    }
    
    /**
     * Tests before and after adding/removing elements if the queues are empty or not.
     * Further tests the exception when the last element is removed and reconfirms if it is empty or not.
     */
    @Test
    public void testIsEmpty() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertTrue("The queue is empty before adding an integer element: ", intQueue.isEmpty());
        assertTrue("The queue is empty before adding an string element: ", stringQueue.isEmpty());

        intQueue.enqueue(intElement);
        stringQueue.enqueue(stringElement);
        
        assertFalse("The queue is not empty after adding an integer element: ", intQueue.isEmpty());
        assertFalse("The queue is not empty after adding an string element: ", stringQueue.isEmpty());

        assertThrows("Should throw when called on just emptied integer queue: ", NoSuchElementException.class, () -> intQueue.dequeue());
        assertThrows("Should throw when called on just emptied string queue: ", NoSuchElementException.class, () -> stringQueue.dequeue());

        assertTrue("The queue is empty after removing an integer element: ", intQueue.isEmpty());
        assertTrue("The queue is empty after removing an string element: ", stringQueue.isEmpty());
    }
    
    /**
     * Tests if the queues are empty or not before adding an element.
     * After adding an element to the queues tests that the values added match the values inside.
     * Then tests if the queue is not empty to reconfirm further that the queues have been filled.
     */
    @Test
    public void testEnqueue() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertTrue("The queue is empty before adding an integer element: ", intQueue.isEmpty());
        assertTrue("The queue is empty before adding an string element: ", stringQueue.isEmpty());

        intQueue.enqueue(intElement);
        stringQueue.enqueue(stringElement);
        
        assertTrue("The queue integer queue value match the added value: ", intElement == intQueue.first());
        assertTrue("The queue string queue value match the added value: ", stringElement == stringQueue.first());

        assertFalse("The queue is not empty after adding an integer element: ", intQueue.isEmpty());
        assertFalse("The queue is not empty after adding an string element: ", stringQueue.isEmpty());
    }

    /**
     * Tests an an extreme amount in comparison to testing one enqueue at a time.
     * Further than the previous tests of the regular enqueue it also tests the first, last and size of the queue.
     */
    @Test
    public void testEnqueueExtreme() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();

        assertTrue("The queue is empty before adding an integer element: ", intQueue.isEmpty());

        for (int i = 0; i < lotsOfLoops; i++) {
            intQueue.enqueue(intElement);
        }

        intQueue.enqueue(intElement + 1);

        assertTrue("The integer queue first integer value match the added value: ", intElement == intQueue.first());
        assertTrue("The integer queue last integer value match the added value: ", intElement + 1 == intQueue.last());
        assertTrue("The integer queue should be of the correct size: ", lotsOfLoops + 1 == intQueue.size());
        assertFalse("The queue is not empty after adding an integer element: ", intQueue.isEmpty());
    }
    
    /**
     * Tests that the elements in the queues match what is in them at the first position.
     * Further tests that exceptions are thrown on a just emptied queue.
     * Then adding elements again with different values from the first round to compare that the new ones match the new values and not the old.
     */
    @Test
    public void testDequeue() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        intQueue.enqueue(intElement);
        stringQueue.enqueue(stringElement);

        assertTrue("The integer queue value match the added value: ", intElement == intQueue.first());
        assertTrue("The string queue value match the added value: ", stringElement == stringQueue.first());

        assertThrows("Should throw when called on empty integer queue: ", NoSuchElementException.class, () -> intQueue.dequeue());
        assertThrows("Should throw when called on empty string queue: ", NoSuchElementException.class, () -> stringQueue.dequeue());

        intQueue.enqueue(intElement + 1);
        stringQueue.enqueue(stringElement + " bandits.");

        assertTrue("The integer queue value match the added value: ", intElement == intQueue.first());
        assertTrue("The string queue value match the added value: ", stringElement == stringQueue.first());
    }

    /**
     * Tests an an extreme amount in comparison to testing one dequeue at a time.
     * Further than the previous tests of the regular dequeue it also tests the first, last and size of the queue.
     */
    @Test
    public void testDequeueExtreme() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        
        for (int i = 0; i < lotsOfLoops; i++) {
            intQueue.enqueue(intElement);
        }
        assertTrue("The integer queue should be of the correct size: ", lotsOfLoops == intQueue.size());

        // i is set to 1 so that one can remain for test purposes.
        for (int i = 1; i < lotsOfLoops; i++) {
            intQueue.dequeue();
        }

        assertThrows("Should throw when called on just emptied integer queue: ", NoSuchElementException.class, () -> intQueue.dequeue());

        intQueue.enqueue(intElement);
        intQueue.enqueue(intElement + 1);

        assertTrue("The integer queue first value match the added value: ", intElement == intQueue.first());
        assertTrue("The integer queue last value match the added value: ", intElement + 1 == intQueue.last());
        assertTrue("The integer queue should be of the correct size: ", 2 == intQueue.size());
        assertFalse("The queue is not empty after adding an integer element: ", intQueue.isEmpty());
    }
    
    /**
     * Tests that exceptions are thrown when trying to get the first element in an empty queue.
     * Further tests the enqueued element matching the first position in both queues.
     */
    @Test
    public void testFirst() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertThrows("Should throw when called on empty integer queue: ", NoSuchElementException.class, () -> intQueue.first());
        assertThrows("Should throw when called on empty string queue: ", NoSuchElementException.class, () -> stringQueue.first());

        intQueue.enqueue(intElement);
        intQueue.enqueue(intElement + 1);
        stringQueue.enqueue(stringElement + " bandits.");
        stringQueue.enqueue(stringElement);

        assertTrue("The integer queue first value match the added value: ", intElement == intQueue.first());
        assertTrue("The string queue first value match the added value: ", stringElement + " bandits." == stringQueue.first());
    }
    
    /**
     * Tests that exceptions are thrown when trying to get the last element in an empty queue.
     * Further tests the enqueued element matching the last position in both queues.
     */
    @Test
    public void testLast() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertThrows("Should throw when called on empty queue: ", NoSuchElementException.class, () -> intQueue.last());
        assertThrows("Should throw when called on empty queue: ", NoSuchElementException.class, () -> stringQueue.last());

        intQueue.enqueue(intElement);
        intQueue.enqueue(intElement + 1);
        stringQueue.enqueue(stringElement + " bandits.");
        stringQueue.enqueue(stringElement);

        assertTrue("The integer queue first value match the added value: ", intElement + 1 == intQueue.last());
        assertTrue("The string queue first value match the added value: ", stringElement == stringQueue.last());
    }
    
    /**
     * Tests that empty queues does not have a next element.
     * Further tests that when adding a few new elements to either queues that there is a next element.
     */
    @Test
    public void testIteratorHasNext() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertFalse("The integer queue does not have a next value: ", intQueue.iterator().hasNext());
        assertFalse("The string queue does not have a next value: ", stringQueue.iterator().hasNext());

        intQueue.enqueue(intElement);
        intQueue.enqueue(intElement);
        stringQueue.enqueue(stringElement);
        stringQueue.enqueue(stringElement);

        assertTrue("The integer queue has a next value: ", intQueue.iterator().hasNext());
        assertTrue("The string queue has a next value: ", stringQueue.iterator().hasNext());
    }
    
    /**
     * Tests that an exception is thrown when the queues are empty.
     * Further tests that when having a few elements added to either queue that the next element matches the input.
     */
    @Test
    public void testIteratorNext() {
        GenericQueue<Integer> intQueue = new GenericQueue<Integer>();
        GenericQueue<String> stringQueue = new GenericQueue<String>();

        assertThrows("Should throw when called on empty integer queue: ", NoSuchElementException.class, () -> intQueue.iterator().next());
        assertThrows("Should throw when called on empty string queue: ", NoSuchElementException.class, () -> stringQueue.iterator().next());

        intQueue.enqueue(intElement);
        intQueue.enqueue(intElement + 1);
        stringQueue.enqueue(stringElement + " bandits.");
        stringQueue.enqueue(stringElement);

        assertTrue("The next integer queue value match: ", intElement == intQueue.iterator().next());
        assertTrue("The next string queue value match: ", stringElement + " bandits." == stringQueue.iterator().next());
    }
}
