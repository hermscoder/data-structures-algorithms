package com.hermscoder.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }

        return false;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addEdge(String vertex1, String vertex2) {

        ArrayList<String> vertex1EdgeList = adjList.get(vertex1);
        ArrayList<String> vertex2EdgeList = adjList.get(vertex2);

        if(vertex1EdgeList != null && vertex2EdgeList != null) {
            vertex1EdgeList.add(vertex2);
            vertex2EdgeList.add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {

        ArrayList<String> vertex1EdgeList = adjList.get(vertex1);
        ArrayList<String> vertex2EdgeList = adjList.get(vertex2);

        if(vertex1EdgeList != null && vertex2EdgeList != null) {
            vertex1EdgeList.remove(vertex2);
            vertex2EdgeList.remove(vertex1);
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