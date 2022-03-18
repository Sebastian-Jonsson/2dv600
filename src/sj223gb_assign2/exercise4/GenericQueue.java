package sj223gb_assign2.exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Class that implements a generic queue.
*
* @version 1.1 28 September 2021
* @author Sebastian Jonsson
*/
public class GenericQueue<E> implements Queue<E> {
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    @Override
    public Iterator<E> iterator() {
        return new GenericIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Creates a new node with the element sent.
     * If a head is not set it will set it and the tail to be the new node's value.
     * If the head is not null it will add a new node to the end of the queue where it also reassigns the tail value.
     */
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<E>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            addTail(head, newNode);
        }   
        size++;
    }

    /**
     * Shrinks the size of the queue as it gets dequeued.
     * Setting head/first to be the next reference node of head/first which eliminates the current node.
     * 
     * @returns - the first/head node's element before removing it.
     */
    @Override
    public E dequeue() {  
        size--;
        emptyException();

        head = head.next;
    
        return head.element;  
    }

    /**
     * Finds and returns the first/head element value.
     * 
     * @returns - the first/head node's element.
     */
    @Override
    public E first() {
        emptyException();
        
        return head.element;
    }
    /**
     * Finds and returns the last/tail element value.
     * 
     * @returns - the last/tail node's element.
     */
    @Override
    public E last() {
        emptyException();

        return tail.element;
    }

    /**
     * Recursively checks when the next value equals null and at that point inserts the new node last and sets the tail value to spare iterating over the entirety of the queue to find the last.
     * 
     * @param node - The current node which can be used to check the next node.
     * @param newNode - The new node that will be placed in the current node's next ref.
     */
    private void addTail(Node<E> node, Node<E> newNode) {
        
        if (node.next == null) {
            node.next = newNode;
            tail = newNode;
        }
        else {
            addTail(node.next, newNode);
        }
    }

    /**
     * How a node is structured and what it contains.
     * Next is default null since we create one at a time, generic.
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;        

        public Node(E e) { 
            this.element = e;
            this.next = null;
        }
    }

    /**
     * Checks if the queue is empty and returns an exception if nothing is in it.
     */
    private void emptyException() {

        if (isEmpty()) {
            throw new NoSuchElementException("Nothing in the generic queue.");
        }
    }

    /**
     * Inspired from AbstractIntCollection from task 2.
     * Modified to accept generic.
     */
    private class GenericIterator implements Iterator<E> {
		private Node<E> currentIndex = head;

        /**
         * Checks for the next element in the queue and returns it.
         * If no element, throws an exception.
         * 
         * @returns - The found element.
         */
        @Override
		public E next() throws NoSuchElementException {
            
            if (hasNext()) {
                E element = currentIndex.element;
                currentIndex = currentIndex.next;
                return element;
            }
            throw new NoSuchElementException("No next element.");
        }
		
        /**
         * Checks if the current index which starts at head is null.
         * If null, return false that it has no next.
         * addTail method/function has similar uses.
         */
        @Override
		public boolean hasNext() {
            
            if (currentIndex == null) {
                return false;
            }
            else {
                return true;
            }
        }
    }
		  
}
