package sj223gb;

import java.util.List;
import java.util.Iterator;
import java.util.HashSet;
import java.util.ArrayList;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

/**
* Class that implements the BFS interface.
*
* @version 1.1 18 October 2021
* @author Sebastian Jonsson
*/
public class MyBFS<E> implements BFS<E> {

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) { 

        if (graph != null && root != null) {
            HashSet<Node<E>> nextToVisit = new HashSet<Node<E>>();
            HashSet<Node<E>> visitedNodes = new HashSet<Node<E>>();
            List<Node<E>> finalList = new ArrayList<Node<E>>();

            nextToVisit.add(root);
            
            return bfsHelper(nextToVisit, visitedNodes, finalList);
        } 
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {

        if (graph != null) {
            HashSet<Node<E>> nextToVisit = new HashSet<Node<E>>();
            HashSet<Node<E>> visitedNodes = new HashSet<Node<E>>();
            List<Node<E>> finalList = new ArrayList<Node<E>>();
            Iterator<Node<E>> iterator = graph.heads();

            while (iterator.hasNext()) {
                Node<E> arbitraryNode = iterator.next();  
                nextToVisit.add(arbitraryNode);

                bfsHelper(nextToVisit, visitedNodes, finalList);
            }
            return finalList;
        } 
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Function that supports both types of BFS operations.
     * 
     * @param nextToVisit - List of nodes to be visited.
     * @param visitedNodes - List of visited nodes.
     * @param finalList - The list in correct order.
     * @return - BFS List.
     */
    private List<Node<E>> bfsHelper(HashSet<Node<E>> nextToVisit, HashSet<Node<E>> visitedNodes,
            List<Node<E>> finalList) {
        Iterator<Node<E>> nextIterator = nextToVisit.iterator();
        nextToVisit = new HashSet<Node<E>>();

        while(nextIterator.hasNext()) {
            Node<E> current = nextIterator.next();
            Iterator<Node<E>> succsIterator = current.succsOf();

            if (!visitedNodes.contains(current)) {
                current.num = finalList.size();
                visitedNodes.add(current);
                finalList.add(current);
            }

            while (succsIterator.hasNext()) {
                Node<E> next = succsIterator.next();

                if (!visitedNodes.contains(next)) {
                    nextToVisit.add(next);
                }
            }
        }
        if (!nextToVisit.isEmpty()) {
            bfsHelper(nextToVisit, visitedNodes, finalList);
        }
        return finalList;  
    }
    
}
