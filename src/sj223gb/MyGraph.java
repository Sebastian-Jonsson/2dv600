package sj223gb;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import graphs.*;

/**
* Class that makes it possible to implement a DirectedGraph.
*
* @version 1.2 9 October 2021
* @author Sebastian Jonsson
*/
public class MyGraph<E> implements DirectedGraph<E> {
    // https://www.baeldung.com/java-graphs
    private Map<E, MyNode<E>> adjacencyNodes;

    public MyGraph() {
        // Hashmap is quick, speed is prefered.
        adjacencyNodes = new HashMap<>();
    }

    /**
     * Adds a node if it is not already present or is null.
     * 
     * @param item - To be put in a node.
     * @returns - Node representing item.
     * @throws NullPointerException
     * @inheritDoc
     */
    @Override
    public Node<E> addNodeFor(E item) {

        if (item != null) {
            MyNode<E> newNode = new MyNode<E>(item);
            
            if (!containsNodeFor(item)) {
                adjacencyNodes.put(item, newNode);
                return adjacencyNodes.get(item);
            }
            else {
                return adjacencyNodes.get(item);     
            }
        } 
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Gets a node if it exists and isn't null.
     * 
     * @param item - To be returned.
     * @returns - Node representing item.
     * @throws NullPointerException
     * @inheritDoc
     */
    @Override
    public Node<E> getNodeFor(E item) {
        
        if (containsNodeFor(item)) {
            return adjacencyNodes.get(item);
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Adds an edge between the from and to nodes, connecting them.
     * 
     * @param from - Node representing a "start"/from.
     * @param to - Node representing a "end"/to.
     * @returns - Boolean
     * @throws NullPointerException
     * @inheritDoc
     */
    @Override
    public boolean addEdgeFor(E from, E to) {
        MyNode<E> fromNode = null, toNode = null;

        if (from == null || to == null) {
            throw new NullPointerException();
        }
        else {
            fromNode = (MyNode<E>) addNodeFor(from);
            toNode = (MyNode<E>) addNodeFor(to);
            
            if (!fromNode.hasSucc(toNode) || !toNode.hasPred(fromNode)) {
                fromNode.addSucc(toNode);
                toNode.addPred(fromNode);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a boolean value indicating whether item exists or not in the graph.
     * 
     * @param item - To be found.
     * @returns - Boolean.
     * @throws NullPointerException
     * @inheritDoc
     */
    @Override
    public boolean containsNodeFor(E item) {
        
        if (item != null) {
            return adjacencyNodes.containsKey(item);
        } 
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Gets the amount of nodes in the graph container, adjacencyNodes.
     * 
     * @returns - Integer value of the size.
     * @inheritDoc
     */
    @Override
    public int nodeCount() {
        return adjacencyNodes.size();
    }

    /**
     * Returns an iterator of the adjacencyNodes of the graph.
     * 
     * @returns - Graph nodes iterator.
     * @inheritDoc
     */
    @Override
    public Iterator<Node<E>> iterator() {
        Map<E, Node<E>> nodeMap = new HashMap<>();

        for (MyNode<E> node : adjacencyNodes.values()) {
            nodeMap.put(node.item(), node);
        }
        return nodeMap.values().iterator();
    }

    /**
     * Returns an iterator of the nodes with no in-edges.
     * 
     * @returns - Heads iterator.
     * @inheritDoc
     */
    @Override
    public Iterator<Node<E>> heads() {
        Map<E, Node<E>> headMap = new HashMap<>();

        for (MyNode<E> node : adjacencyNodes.values()) {
            if (node.isHead()) {
                headMap.put(node.item(), node);
            }
        }
        return headMap.values().iterator();
    }

    /**
     * Returns the number of nodes with no in-edges.
     * 
     * @returns - Number of nodes with no in-edges.
     * @inheritDoc
     */
    @Override
    public int headCount() {
        int counter = 0;
        Iterator<Node<E>> iterator = heads();

        while (iterator.hasNext()) {
            counter++;
            iterator.next();
        }
        return counter;
    }

    /**
     * Returns an iterator of the nodes with no out-edges.
     * 
     * @returns - Tails iterator.
     * @inheritDoc
     */
    @Override
    public Iterator<Node<E>> tails() {
        Map<E, Node<E>> tailMap = new HashMap<>();

        for (MyNode<E> node : adjacencyNodes.values()) {
            if (node.isTail()) {
                tailMap.put(node.item(), node);
            }
        }
        return tailMap.values().iterator();
    }

    /**
     * Returns the number of nodes with no out-edges.
     * 
     * @returns - Number of nodes with no out-edges.
     * @inheritDoc
     */
    @Override
    public int tailCount() {
        int counter = 0;
        Iterator<Node<E>> iterator = tails();

        while (iterator.hasNext()) {
            counter++;
            iterator.next();
        }
        return counter;
    }

    /**
     * Returns a list over all nodes items currently used in the graph.
     * 
     * @returns - List of items.
     * @inheritDoc
     */
    @Override
    public List<E> allItems() {
        List<E> result = new ArrayList<>();

        for (MyNode<E> node : adjacencyNodes.values()) {
            result.add(node.item());
        }
        return result;
    }

    /**
     * Returns the number of graph edges.
     * 
     * @returns - Amount of graph edges.
     * @inheritDoc
     */
    @Override
    public int edgeCount() {
        int counter = 0;

        for (MyNode<E> node : adjacencyNodes.values()) {
            counter += node.outDegree();
        }
        return counter;
    }

    /**
     * Removes the selected node and all of it's connected edes.
     * Throws exception if there is no node or if item is null.
     * 
     * @param item - Node to be erased.
     * @inheritDoc
     */
    @Override
    public void removeNodeFor(E item) {
    
        if (containsNodeFor(item)) {
            MyNode<E> eraseNode = (MyNode<E>) getNodeFor(item);
            
            for (MyNode<E> node : adjacencyNodes.values()) {
                if (node.hasSucc(eraseNode)) node.removeSucc(eraseNode);
                if (node.hasPred(eraseNode)) node.removePred(eraseNode);
            }
            eraseNode.disconnect();
            adjacencyNodes.remove(item);
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Returns true if an edge exists between the two nodes 'from' and 'to'.
     * 
     * @param from - Source node.
     * @param to - Target node.
     * @returns - A boolean indicating if the edge exists or not.
     * @inheritDoc
     */
    @Override
    public boolean containsEdgeFor(E from, E to) {
        MyNode<E> fromNode = null, toNode = null;;

        if (from == null || to == null) {
            throw new NullPointerException();
        }
        else {
            if (adjacencyNodes.containsKey(from) && adjacencyNodes.containsKey(to)) {
                fromNode = adjacencyNodes.get(from);
                toNode = adjacencyNodes.get(to);

                return fromNode.hasSucc(toNode);
            }
        }
        return false;
    }

    /**
     * Returns true if the edge between represented nodes were found and removed otherwise false.
     * 
     * @param from - Source node.
     * @param to - Target node.
     * @returns - A boolean indicating if the edge was removed or not.
     * @inheritDoc
     */
    @Override
    public boolean removeEdgeFor(E from, E to) {
        MyNode<E> fromNode = null, toNode = null;

        if (from == null || to == null) {
            throw new NullPointerException();
        }
        else {
            if (containsEdgeFor(from, to)) {
                fromNode = adjacencyNodes.get(from);
                toNode = adjacencyNodes.get(to);

                fromNode.removeSucc(toNode);
                toNode.removePred(fromNode);

                return true;
            }
            return false;
        }
    }
    
}
