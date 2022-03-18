package sj223gb_assign2.exercise2;

import java.util.Iterator;

/**
* Class that uses the AbstractIntCollection and implements the IntList, making proper integration as requested.
*
* @version 1.1 24 September 2021
* @author Sebastian Jonsson
*/
public class ArrayIntList extends AbstractIntCollection implements IntList {

    @Override
    public void add(int n) {

        if (size >= values.length) {
            resize();
        }
        // Size is the index that is after the last value.
        values[size] = n;
        size++;
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        errorHandler(index, upperValue());

        if (size >= values.length) {
            resize();
        }
        
        Iterator<Integer> iter = iterator();
        // Counter to compare to requested index
        int i = 0;
        
        while (iter.hasNext()) {
            int currentValue = iter.next();
            
            // When Counter 'i' reached the same as index value we start to replace values.
            // First it replaces the requested index with the requested index value, we save the value existing in that index before inserting the new.
            // We then keep saving and inserting til the end of the loop. So the index values gets pushed one step further.
            if (i == index) {
                values[i] = n;
                n = currentValue;
                index++;
            }
            i++;
        }
        // Last value that's pushed to the end.
        values[i] = n;
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        errorHandler(index, upperValue());
        
        Iterator<Integer> iter = iterator();
        int i = 0;

        while (iter.hasNext()) {
            iter.next();
            
            // Similar to addAt but in reverse. Remove at position index requested and the rest are moved back one step.
            if (i == index) {
                values[index] = values[index + 1];
                index++;
            }
            i++;
        }
        // We do Javas job, which set it by default to 0.
        values[size] = 0;
        size--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        errorHandler(index, upperValue());
        
        Iterator<Integer> iter = iterator();
        int i = 0;
        int value = 0;

        while (iter.hasNext()) {
            int currentValue = iter.next();

            // Similar to both addAt and remove. However once we reach the first value we set it to a value and then break the loop and return it.
            if (i == index) {
                value = currentValue;
                break;
            }
            i++;
        }
        return value;
    }

    @Override
    public int indexOf(int n) {
        Iterator<Integer> iter = iterator();
        int i = 0;

        while (iter.hasNext()) {
            int currentValue = iter.next();

            // If the current value is what we look for we return the index value which is the position of our own 'i' counter.
            if (currentValue == n) {
                return i;
            }
            i++;
        }
        // Else return negative one as a false, non-existent.
        return -1;
    }

    private void errorHandler(int index, int upper) throws IndexOutOfBoundsException {
        
        if (index > upper || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        checkIndex(index, upper);
    }

    /**
     * Helper function about knowing where the ceiling of the arraylist is.
     * 
     * @returns - The upper limit of the arraylist.
     */
    private int upperValue() {
        int upper;

        if (size < 1) {
            upper = 0;
        }
        else {
            upper = size - 1;
        }
        return upper;
    }
    
}
