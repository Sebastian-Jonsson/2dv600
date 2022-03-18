package sj223gb_assign2.exercise2;


/**
* Class that uses the AbstractIntCollection and implements the IntStack, making proper integration as requested.
*
* @version 1.1 24 September 2021
* @author Sebastian Jonsson
*/
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    @Override
    public void push(int n) {

        // Enlarges when we're out of space.
        if (size >= values.length) {
            resize();
        }
        values[size] = n;
        size++;
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        errorHandler();

        // Going by the first in first out, top of the stack, size - 1 is the correct index value.
        int top = values[size - 1];
        // We do Javas job, which set it by default to 0.
        values[size - 1] = 0;

        size--;

        return top;
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        errorHandler();

        // Same as pop without removing it.
        int top = values[size - 1];

        return top;
    }

    private void errorHandler() throws IndexOutOfBoundsException {
        
        // Use extended isEmpty() to check if to throw exception.
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
    }
    
}
