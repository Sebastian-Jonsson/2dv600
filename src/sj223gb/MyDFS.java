package sj223gb;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

/**
* Class that implements the DFS interface.
*
* @version 1.1 14 October 2021
* @author Sebastian Jonsson
*/
public class MyDFS<E> implements DFS<E> {

    private int postOrderCounter = 0;

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        LinkedHashSet<Node<E>> visitedNodes = new LinkedHashSet<Node<E>>();
        dfsHelper(root, visitedNodes);

        return new ArrayList<Node<E>>(visitedNodes);
    }
    
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> visitedNodes = new LinkedHashSet<Node<E>>();
        Iterator<Node<E>> iterator = graph.heads();
        
        while (iterator.hasNext()) {
            Node<E> arbitraryNode = iterator.next();   
            dfsHelper(arbitraryNode, visitedNodes);
        }
        return new ArrayList<Node<E>>(visitedNodes);
    }
    
    /**
     * Function that support both types of DFS operations.
     * 
     * @param root - The initializing node to check.
     * @param visitedNodes - List of visited nodes.
     */
    private void dfsHelper(Node<E> root, LinkedHashSet<Node<E>> visitedNodes) {
        Iterator<Node<E>> succsIterator = root.succsOf();
        root.num = visitedNodes.size();
        visitedNodes.add(root);

        while (succsIterator.hasNext()) {
            Node<E> node = succsIterator.next();
            
            if (!visitedNodes.contains(node)) {
                dfsHelper(node, visitedNodes);
            }
        }
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        LinkedHashSet<Node<E>> postOrderNodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        postOrderHelper(root, postOrderNodes, visited, true);

        return new ArrayList<Node<E>>(postOrderNodes);
    }
    
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        LinkedHashSet<Node<E>> postOrderNodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        Iterator<Node<E>> iterator = g.heads();
        
        while (iterator.hasNext()) {
            Node<E> arbitraryNode = iterator.next();   
            postOrderHelper(arbitraryNode, postOrderNodes, visited, true);
        }
        return new ArrayList<Node<E>>(postOrderNodes);
    }
    
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        LinkedHashSet<Node<E>> postOrderNodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        Iterator<Node<E>> iterator = g.heads();
        
        while (iterator.hasNext()) {
            Node<E> arbitraryNode = iterator.next();   
            postOrderHelper(arbitraryNode, postOrderNodes, visited, attach_dfs_number);
        }
        return new ArrayList<Node<E>>(postOrderNodes);
    }

    /**
     * Function that support all three postOrder operations, despite the boolean operation not having implemented tests.
     * 
     * @param root - The initializing node.
     * @param postOrderNodes - The node list to be returned after adding nodes in order.
     * @param visitedNodes - List of visited nodes.
     * @param attach_dfs_number - Boolean indicating whether a dfs number should be attaced or not.
     */
    private void postOrderHelper(Node<E> root, LinkedHashSet<Node<E>> postOrderNodes, HashSet<Node<E>> visitedNodes, boolean attach_dfs_number) {
        Iterator<Node<E>> succsIterator = root.succsOf();
        visitedNodes.add(root);

        while (succsIterator.hasNext()) {
            Node<E> node = succsIterator.next();

            if (!visitedNodes.contains(node)) {
                postOrderHelper(node, postOrderNodes, visitedNodes, true);
            }
        }
        if (attach_dfs_number) {
            root.num = postOrderNodes.size();
        }
        else {
            root.num = postOrderCounter++;
        }
        postOrderNodes.add(root);
    }

    /**
     * Returns true if the graph is cyclic.
     * Either a iterator of successors or predecessors passes the tests.
     * 
     * @returns - Boolean if a graph is cyclic or not.
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {

        for (Node<E> node : graph) {
            List<Node<E>> combined = new ArrayList<Node<E>>();
            Iterator<Node<E>> predsIterator = node.predsOf();

            while (predsIterator.hasNext()) {
                Node<E> tempNode = predsIterator.next();

                if (combined.contains(tempNode)) return true;
                if (node == tempNode) return true;

                combined.add(tempNode);
            }
        }
        return false;
    }

    /**
     * Returns a list of all nodes in the graph ordered topological.
     * If the graph is cyclic it returns null.
     * 
     * @returns - A list of nodes i topological order.
     */
    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        LinkedHashSet<Node<E>> postOrderNodes = new LinkedHashSet<Node<E>>();
        HashSet<Node<E>> visited = new HashSet<Node<E>>();
        Iterator<Node<E>> iterator = graph.tails();
        
        if (isCyclic(graph)) postOrderNodes = null;
        else {
            while (iterator.hasNext()) {
                Node<E> arbitraryNode = iterator.next();   
                topSortHelper(arbitraryNode, postOrderNodes, visited);
            }
        }
        return new ArrayList<Node<E>>(postOrderNodes);
    }

    /**
     * Function that support the topSort function, ensuring it is in topological order.
     * 
     * @param root - The initializing node.
     * @param postOrderNodes - The node list to be returned after adding in order.
     * @param visitedNodes - List of visited nodes.
     */
    private void topSortHelper(Node<E> root, LinkedHashSet<Node<E>> postOrderNodes, HashSet<Node<E>> visitedNodes) {
        postOrderCounter = 0;
        Iterator<Node<E>> succsIterator = root.succsOf();
        visitedNodes.add(root);

        while (succsIterator.hasNext()) {
            Node<E> node = succsIterator.next();

            if (!visitedNodes.contains(node)) {
                postOrderHelper(node, postOrderNodes, visitedNodes, true);
            }
        }
        root.num = postOrderCounter++;
        postOrderNodes.add(root);
    }
    
}
