package sj223gb;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

/**
* Class that implements the ConnectedComponents.
*
* @version 1.0 19 October 2021
* @author Sebastian Jonsson
*/
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    /**
     * Finds the different subgraphs from the supergraph and returns them in a collection.
     * 
     * @returns - A collection of generic node collections.
     */
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        Collection<Collection<Node<E>>> connectedComponents = new HashSet<>();
        Collection<Collection<Node<E>>> removeList = new HashSet<>();
        HashSet<Node<E>> connected = new HashSet<>();
        MyDFS<E> dfs = new MyDFS<E>();

        for (Node<E> node : dg) {
            
            if (!connected.contains(node)) {
                HashSet<Node<E>> dfsList = new HashSet<>(dfs.dfs(dg, node));
                connected.addAll(dfsList);

                for (Collection<Node<E>> collection : connectedComponents) {
    
                    if (!Collections.disjoint(collection, dfsList)) {
                        dfsList.addAll(collection);
                        removeList.add(collection);                       
                    }
                }
                if (!connected.isEmpty()) {
                    connectedComponents.add(dfsList);
                }                
            }
        }

        // Removes the unwanted collections from the connected components list.
        Iterator<Collection<Node<E>>> remIterator = removeList.iterator();

        while (remIterator.hasNext()) {
            Collection<Node<E>> remNext = remIterator.next();            
            connectedComponents.remove(remNext);
        }
        return connectedComponents;
    }

}
