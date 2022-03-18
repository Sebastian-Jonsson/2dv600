package sj223gb;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;
import java.util.Iterator;

/**
* Class that utilizes the abstract class GML and overrides the toGML method in it.
*
* @version 1.0 11 October 2021
* @author Sebastian Jonsson
*/
public class MyGML<E> extends GML<E> {
    StringBuilder sbcomplete = new StringBuilder();
    StringBuilder sbnode = new StringBuilder();
    StringBuilder sbedge = new StringBuilder();

    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    /**
     * Method to be overriden, formatting the graph to the GML format.
     */
    @Override
    public String toGML() {
        addGraphInfo();

        return sbcomplete.toString();
    }

    /**
     * Encompassing section that builds the GML for the graph given.
     */
    private void addGraphInfo() {
        sbcomplete.append("graph [\n");
        sbcomplete.append("\thierarchic 1\n");
        sbcomplete.append("\tdirected 1\n");
        sbcomplete.append("\tcomment " + "\"" + "This is a sample directed graph\"\n");
        sbcomplete.append("\tlabel \"Directed Graph\"\n");

        addAllNodes();
        sbcomplete.append(sbnode);
        sbcomplete.append(sbedge);
        
        sbcomplete.append("]");
    }

    /**
     * Node section of the GML format.
     */
    private void addAllNodes() {
        

        for (Node<E> node : graph) {
            sbnode.append("\tnode [\n");
            sbnode.append("\t\tid " + node.item() + "\n");
            sbnode.append("\t\tlabel \"" + node.item() + "\"\n");
            sbnode.append("\t]\n");
            addAllEdges(node);
        }
    }

    /**
     * Edge section of the GML format.
     * @param node
     */
    private void addAllEdges(Node<E> node) {
        Iterator<Node<E>> iterator = node.succsOf();

        while (iterator.hasNext()) {
            Node<E> next = iterator.next();
            sbedge.append("\tedge [\n");
            sbedge.append("\t\tsource " + node + "\n");
            sbedge.append("\t\ttarget " + next + "\n");
            sbedge.append("\t\tlabel \"Edge from node " + node + " to node " + next + "\"\n");
            sbedge.append("\t]\n");
        }
    }
    
}
