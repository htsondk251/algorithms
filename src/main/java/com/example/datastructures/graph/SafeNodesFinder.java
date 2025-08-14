package com.example.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SafeNodesFinder {

    private enum State {UNVISITED, VISITING, SAFE}

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        State[] states = new State[n];
        Arrays.fill(states, State.UNVISITED);

        for (int currentNode = 0 ; currentNode < n ; currentNode++) {
            if (isSafe(currentNode, graph, states)) {
                safeNodes.add(currentNode);
            }
        }
        safeNodes.sort(Comparator.naturalOrder());
        return safeNodes;
    }

    private boolean isSafe(int currentNode, int[][] graph, State[] states) {
        if (states[currentNode] == State.VISITING) return false; //cycle
        if (states[currentNode] == State.SAFE) return true;

        states[currentNode] = State.VISITING;
        for (int neighbor : graph[currentNode]) {
            if (!isSafe(neighbor, graph, states)) return false;
        }

        states[currentNode] = State.SAFE;
        return true;
    }

    public static void main(String[] args) {
        SafeNodesFinder i = new SafeNodesFinder();
        System.out.println(i.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {2}, {}, {5}, {6}, {}}));    //{3,4,5,6}
        System.out.println(i.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {}, {}, {4}}));    //{2,4,5,6}
    }
}
