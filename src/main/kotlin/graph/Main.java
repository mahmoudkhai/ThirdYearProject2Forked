package graph;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph graph = new Graph(nodeList);
        // create an edge between A and B
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(0, 3);
        

    }
    public class TreeNode {
        int nodeValue;
        TreeNode left;
        TreeNode right;

        public TreeNode(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original,
                                        final TreeNode cloned,
                                        final TreeNode target) {
        TreeNode ans = null;
        if (original == null) return null;
        if (original == target) ans = cloned;
        getTargetCopy(original.left , cloned.left , target);
        getTargetCopy(original.right , cloned.right , target);
        return ans;

    }
}
