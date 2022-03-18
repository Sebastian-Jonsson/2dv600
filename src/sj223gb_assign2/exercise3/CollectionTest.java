package sj223gb_assign2.exercise3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sj223gb_assign2.exercise2.ArrayIntList;
import sj223gb_assign2.exercise2.ArrayIntStack;

/*
* Date: 2020-09-23.
* File Name: CollectionTest.Java
* Author: Sebastian Jonsson
*
* Copyright (c): Here comes the copyright statement if any ...
*/

/**
* Class that tests the ArrayIntList and ArrayIntStack from exercise 2.
* Junit5 is used.
*
* @version 1.0 24 September 2021
* @author Sebastian Jonsson
*/
public class CollectionTest {
    private static final int valueAdd = 5;
    private static final int valueAddAt = 3;
    private static final int indexValue = 0;
    private static final int lotsOfLoops = 1000;
    
    /**
     * Tests the size of the arraylist before and after adding an integer.
     */
    @Test
    public void testListAdd() {
        ArrayIntList testArrayIntList = new ArrayIntList();      

        assertEquals("Size of Arraylist match: ", 0, testArrayIntList.size());
        
        testArrayIntList.add(valueAdd);

        assertEquals("Size of Arraylist match: ", 1, testArrayIntList.size());
        assertEquals("Inserted value matches position in ArrayList: ", valueAdd, testArrayIntList.get(indexValue));
    }

    /**
     * Tests the size of the arraylist before and after adding a high amount of integers.
     */
    @Test
    public void testListAddExtreme() {
        ArrayIntList testArrayIntList = new ArrayIntList();

        assertEquals("Size of Arraylist match: ", 0, testArrayIntList.size());

        for (int i = 0; i < lotsOfLoops; i++) {
            testArrayIntList.add(valueAdd);
        }
        
        assertEquals("Inserted value matches position in ArrayList: ", valueAdd, testArrayIntList.get(indexValue));
        assertEquals("Size of Arraylist match: ", lotsOfLoops, testArrayIntList.size());
    }
    
    /**
     * Adding a value to the arraylist and then aadding a second value to that point in the array.
     * Tests adding outside of the bounds of the array which should throw an exception.
     * Further tests that the positions, values, and sizes are correct.
     */
    @Test
    public void testListAddAt() {
        ArrayIntList testArrayIntList = new ArrayIntList();

        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);

        assertThrows("Index out of bounds exception is thrown: ", IndexOutOfBoundsException.class, () -> testArrayIntList.addAt(valueAdd, -1));
        assertEquals("Inserted value is at the index values position: ", valueAddAt, testArrayIntList.get(indexValue));
        assertEquals("Old value is at the next index value position: ", valueAdd, testArrayIntList.get(indexValue + 1));
        assertEquals("Size of ArrayList updated correctly after adding value: ", 2, testArrayIntList.size());
    }

    /**
     * Tests a higher quantity to see if it breaks the method or not.
     * Checking that the inserted value matches the value at the index as well as the size of the arraylist.
     */
    @Test
    public void testListAddAtExtreme() {
        ArrayIntList testArrayIntList = new ArrayIntList();

        for (int i = 0; i < lotsOfLoops; i++) {
            testArrayIntList.addAt(valueAddAt, indexValue);
        }

        assertEquals("Inserted value matches position in ArrayList: ", valueAddAt, testArrayIntList.get(indexValue));
        assertEquals("Size of Arraylist match: ", lotsOfLoops, testArrayIntList.size());
    }
    
    /**
     * Tests exception by trying to remove on an empty arraylist and then adds a few integers.
     * Tests size, index value to be correct.
     * Further tests if the previous value matches index value before removal of it and that it does not match after.
     */
    @Test
    public void testListRemove() {
        ArrayIntList testArrayIntList = new ArrayIntList();
        
        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);
        int valuePreRemoval = testArrayIntList.get(indexValue);

        assertThrows("Index out of bounds exception is thrown: ", IndexOutOfBoundsException.class, () -> testArrayIntList.remove(-1));

        assertEquals("Size of Arraylist before removal: ", 2, testArrayIntList.size());
        assertEquals("Index value before removal: ", valueAddAt, valuePreRemoval);
        assertTrue("Value at index equal most recent added value: ", valuePreRemoval == valueAddAt);

        testArrayIntList.remove(indexValue);
        
        assertEquals("Size of Arraylist after removal: ", 1, testArrayIntList.size());
        assertEquals("Value at index equal first added value: ", valueAdd, testArrayIntList.get(indexValue));
        assertFalse("Value at index does not equal removed value: ", valuePreRemoval != valueAddAt);
    }
    
    /**
     * Tests to see if the size is the correct size after adding a few integers.
     * Tests to see that an exception is thrown if the requested index is outside of the bounds.
     * Tests that the value 
     */
    @Test
    public void testListGet() {
        ArrayIntList testArrayIntList = new ArrayIntList();
        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);

        assertThrows("Index out of bounds exception is thrown: ", IndexOutOfBoundsException.class, () -> testArrayIntList.remove(-1));
        assertEquals("Size of Arraylist match: ", 2, testArrayIntList.size());
        assertEquals("Value same as expected: ", valueAddAt, testArrayIntList.get(indexValue));     
    }

    
    /**
     * Tests the size before and after adding, as well as after removing values.
     */
    @Test
    public void testListSize() {
        ArrayIntList testArrayIntList = new ArrayIntList();

        assertEquals("Size has increased after adding: ", 0, testArrayIntList.size());

        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);

        assertEquals("Size has increased after adding: ", 2, testArrayIntList.size());
        
        testArrayIntList.remove(indexValue);
        testArrayIntList.remove(indexValue);
        
        assertEquals("Size has decreased after removing: ", 0, testArrayIntList.size());
    }
    
    /**
     * Tests if the list is empty after adding a few values and after removing the values.
     */
    @Test
    public void testListIsEmpty() {
        ArrayIntList testArrayIntList = new ArrayIntList();
        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);

        assertFalse("Should return false if filled arrayList: ", testArrayIntList.isEmpty());

        testArrayIntList.remove(indexValue);
        testArrayIntList.remove(indexValue);
        
        assertTrue("Should return true if empty arrayList: ", testArrayIntList.isEmpty());
    }
    
    /**
     * Tests that the added values have the right index position.
     * Further tests that an index position does not exist.
     */
    @Test
    public void testListIndexOf() {
        ArrayIntList testArrayIntList = new ArrayIntList();
        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);

        assertEquals("Index value should be the correct int value at the first position: ", indexValue, testArrayIntList.indexOf(valueAddAt));
        assertEquals("Index value should be the correct int value at the second position: ", indexValue + 1, testArrayIntList.indexOf(valueAdd));

        // Checks that 129 does not exist. Should return -1.
        assertEquals("Checks that 129 does not exist: ", -1, testArrayIntList.indexOf(129));  
    }
    
    /**
     * Tests the output string after adding a few values, to see if it matches the expectation.
     */
    @Test
    public void testListToString() {
        ArrayIntList testArrayIntList = new ArrayIntList();
        testArrayIntList.add(valueAdd);
        testArrayIntList.addAt(valueAddAt, indexValue);
        
        String expectedString = "[ " + valueAddAt + " " + valueAdd + " ]";

        assertEquals("Checks that the string is correct: ", expectedString, testArrayIntList.toString());
    }


    // ArrayIntStack test part

    /**
     * Tests two times by adding a value and then checking that the size has grown and that the value is correct in the stack.
     */
    @Test
    public void testStackPush() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();
        testArrayIntStack.push(valueAdd);

        assertEquals("Size of ArrayStack match: ", 1, testArrayIntStack.size());
        assertEquals("Inserted value matches position in ArrayStack: ", valueAdd, testArrayIntStack.peek());

        testArrayIntStack.push(valueAdd);
        
        assertEquals("Size of ArrayStack match: ", 2, testArrayIntStack.size());
        assertEquals("Inserted value matches position in ArrayStack: ", valueAdd, testArrayIntStack.peek());
    }

    /**
     * Tests to pop on an empty stack throws an exception.
     * Tests size before and after adding a value in order to verify that the pop test is reduced after calling it.
     * Tests to pop and then the size again to see it shrunk.
     */
    @Test
    public void testStackPop() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();

        assertThrows("Should throw when called on empty stack: ", IndexOutOfBoundsException.class, () -> testArrayIntStack.pop());
        assertEquals("Pop should reduce the size properly: ", 0, testArrayIntStack.size());

        testArrayIntStack.push(valueAdd);

        assertTrue("Pop should return the correct value: ", valueAdd == testArrayIntStack.pop());
        assertEquals("Pop should reduce the size properly: ", 0, testArrayIntStack.size());
    }

    /**
     * Tests that an exception is thrown when trying to peek on an empty stack.
     * Tests the peek value by adding a value through push and comparing the values.
     */
    @Test
    public void testStackPeek() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();
        
        assertThrows("Should throw when called on empty stack: ", IndexOutOfBoundsException.class, () -> testArrayIntStack.peek());

        testArrayIntStack.push(valueAdd);

        assertTrue("Confirms that the latest value added is the correct value", valueAdd == testArrayIntStack.peek());
    }

    /**
     * Tests the size of the stack is correct before and after adding a value.
     */
    @Test
    public void testStackSize() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();

        assertEquals("Stack should be empty: ", 0, testArrayIntStack.size());

        testArrayIntStack.push(valueAdd);

        assertEquals("Stack should be the correct size: ", 1, testArrayIntStack.size());
    }

    /**
     * Tests if the stack is empty before and after adding a value.
     */
    @Test
    public void testStackIsEmpty() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();

        assertTrue("Stack should be empty: ", testArrayIntStack.isEmpty());

        testArrayIntStack.push(valueAdd);

        assertFalse("Stack should not be empty: ", testArrayIntStack.isEmpty());
    }

    /**
     * Tests the output string after adding a few values, to see if it matches the expectation.
     */
    @Test
    public void testStackToString() {
        ArrayIntStack testArrayIntStack = new ArrayIntStack();
        testArrayIntStack.push(valueAdd);
        testArrayIntStack.push(valueAddAt);

        String expectedString = "[ " + valueAdd + " " + valueAddAt + " ]";

        assertEquals("Checks that the string is correct: ", expectedString, testArrayIntStack.toString());
    }
}
