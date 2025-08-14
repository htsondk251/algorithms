package com.example.datastructures.graph;

import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For an undirected graph
    }

    // Method to perform DFS using a stack
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[adjacencyList.length];
        Stack<Integer> unvisitedVertices = new Stack<>();

        unvisitedVertices.push(startVertex);

        while (!unvisitedVertices.isEmpty()) {
            int currentVertex = unvisitedVertices.pop();
            if (visited[currentVertex]) return;
            System.out.print(" " + currentVertex);
            visited[currentVertex] = true;
            for (int adjacencyVertex : adjacencyList[currentVertex]) {
                if (!visited[adjacencyVertex]) unvisitedVertices.push(adjacencyVertex);
            }
        }

    }
}

class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        System.out.print("DFS Traversal starting from vertex 0: ");
        g.DFS(0);
    }
}
