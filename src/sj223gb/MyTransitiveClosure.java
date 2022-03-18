package sj223gb;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

/**
* Class that implements the TransitiveClosure.
*
* @version 1.0 18 October 2021
* @author Sebastian Jonsson
*/
public class MyTransitiveClosure<E> implements TransitiveClosure<E>{

    /**
     * Determines the transitive closure by using MyDFS, putting it into a list and then into the map.
     * Reference the lecture material on transitive closure.
     * 
     * @returns - Map that contains the transitive closure.
     */
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        Map<Node<E>, Collection<Node<E>>> transitiveClosure = new HashMap<Node<E>, Collection<Node<E>>>();
        MyDFS<E> dfs = new MyDFS<E>();

        for (Node<E> node : dg) {
            List<Node<E>> list = dfs.dfs(dg, node);
            transitiveClosure.put(node, list);
            
        }
        return transitiveClosure;
    }
    
}
