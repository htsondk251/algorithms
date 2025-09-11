package com.example.algorithms.dp;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 11/09/2025 12:06 AM
 */

public class KnapsackBacktrack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return backtrack(profits, weights, capacity, 0);
    }


    private int backtrack(int[] profits, int[] weights, int capacity, int start) {
        if (start >= profits.length || capacity <= 0) return 0;
        int notInclude = backtrack(profits, weights, capacity, start+1);
        int include = 0;
        if (weights[start] <= capacity) {
            include = profits[start] + backtrack(profits, weights, capacity - weights[start], start+1);
        }
        return Math.max(include, notInclude);
    }

    public static void main(String[] args) {
        KnapsackBacktrack i = new KnapsackBacktrack();
        System.out.println(i.solveKnapsack(
                new int[]{1, 6, 10, 16},
                new int[]{1, 2, 3, 5},
                7
        ));
    }
}
