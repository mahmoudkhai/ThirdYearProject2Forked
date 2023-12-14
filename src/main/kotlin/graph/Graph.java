package graph;

import java.util.ArrayList;

//save nodes in arrayList , save edges to a 2-D array
public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int [] [] adjacentMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacentMatrix = new int [nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge (int indexOfFirstNode , int indexOfSecondNode) {
        adjacentMatrix[indexOfFirstNode][indexOfSecondNode] = 1;
        adjacentMatrix[indexOfSecondNode][indexOfFirstNode] = 1;
    }



}
