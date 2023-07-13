package com.hermscoder.graph.exercises;

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise {
    public static void main(String[] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("Graph before removeVertex():");
        myGraph.printGraph();

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();

    }
}

class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if(adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        ArrayList<String> adjList1 = adjList.get(vertex1);
        ArrayList<String> adjList2 = adjList.get(vertex2);

        if(adjList1 != null && adjList2 != null) {
            adjList1.add(vertex2);
            adjList2.add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        ArrayList<String> adjList1 = adjList.get(vertex1);
        ArrayList<String> adjList2 = adjList.get(vertex2);

        if(adjList1 != null && adjList2 != null) {
            adjList1.remove(vertex2);
            adjList2.remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        ArrayList<String> vertexAdjList = adjList.get(vertex);

        if(vertexAdjList == null) return false;

        for (String otherVertex : vertexAdjList) {
            adjList.get(otherVertex).remove(vertex);
        }

        adjList.remove(vertex);

        return true;
    }

}