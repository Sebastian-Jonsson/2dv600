package sj223gb;

import java.util.HashSet;
import java.util.Iterator;

import graphs.Node;

/**
* Class that adds functionality upon the node interface, extending the node interface.
*
* @version 1.1 7 October 2021
* @author Sebastian Jonsson
*/
public class MyNode<E> extends Node<E> {
    private final HashSet<Node<E>> predecessors = new HashSet<Node<E>>();
    private final HashSet<Node<E>> successors = new HashSet<Node<E>>();
    
    public MyNode(E item) {
        super(item);  
    }

    /**
     * Checks if the current node has a successor node.
     * 
     * @returns - Boolean.
     */
    @Override
    public boolean hasSucc(Node<E> node) {
        return this.successors.contains(node);
    }

    /**
     * Checks how many successors the current node has.
     * 
     * @returns - Integer representing how many successors exists.
     */
    @Override
    public int outDegree() {
        return this.successors.size();
    }

    /**
     * An iterator of the successors of the current node.
     * 
     * @returns - Iterator.
     */
    @Override
    public Iterator<Node<E>> succsOf() {
        return this.successors.iterator();
    }

    /**
     * Checks if the current node has a predecessor node.
     * 
     * @returns - Boolean.
     */
    @Override
    public boolean hasPred(Node<E> node) {
        return this.predecessors.contains(node);
    }

    /**
     * Checks how many predecessors the current node has.
     * 
     * @returns - Integer representing how many predecessors exists.
     */
    @Override
    public int inDegree() {
        return this.predecessors.size();
    }

    /**
     * An iterator of the predecessors of the current node.
     * 
     * @returns - Iterator.
     */
    @Override
    public Iterator<Node<E>> predsOf() {
        return this.predecessors.iterator();
    }

    /**
     * Adds a successor node to the current node.
     */
    @Override
    protected void addSucc(Node<E> succ) {
        this.successors.add(succ);
    }

    /**
     * Removes the successor node from the current node.
     */
    @Override
    protected void removeSucc(Node<E> succ) {
        this.successors.remove(succ);
    }

    /**
     * Adds a predecessor node to the current node.
     */
    @Override
    protected void addPred(Node<E> pred) {
        this.predecessors.add(pred);
    }

    /**
     * Removes the predecessor node from the current node.
     */
    @Override
    protected void removePred(Node<E> pred) {
        this.predecessors.remove(pred);
    }

    /**
     * Disconnects this node from all predecessor and successor nodes.
     */
    @Override
    protected void disconnect() {
        this.predecessors.clear();
        this.successors.clear();    
    }
    
}
