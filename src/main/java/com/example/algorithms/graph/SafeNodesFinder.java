package com.example.algorithms.graph;

import java.util.*;
import java.util.stream.Collectors;

public class SafeNodesFinder {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> result = new TreeSet<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];

        for (int currentNode = 0; currentNode < n; currentNode++) {
            if (!visited[currentNode]) {
                visitedDfs(currentNode, graph, visited, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void visitedDfs(int currentNode, int[][] graph, boolean[] visited, Set<Integer> safeNodes) {
        visited[currentNode] = true;
        int[] neighbors = graph[currentNode];

        if (neighbors.length == 0) {
            safeNodes.add(currentNode);
        }

        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                visitedDfs(neighbor, graph, visited, safeNodes);
            }
        }

        if (safeNodes.containsAll(Arrays.stream(neighbors).boxed().collect(Collectors.toList())))
            safeNodes.add(currentNode);
    }

    public static void main(String[] args) {
        SafeNodesFinder i = new SafeNodesFinder();
        System.out.println(i.eventualSafeNodes(new int[][]{{1,2},{2,3},{2},{},{5},{6},{}}));    //{3,4,5,6}
        System.out.println(i.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{},{},{4}}));    //{2,4,5,6}
    }
}
