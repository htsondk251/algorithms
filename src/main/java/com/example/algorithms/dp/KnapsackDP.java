package com.example.algorithms.dp;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 12/09/2025 12:38 AM
 */

public class KnapsackDP {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[capacity+1][profits.length];
        return backtrack(profits, weights, capacity, 0, dp);
    }

    private int backtrack(int[] profits, int[] weights, int capacity, int start, Integer[][] dp) {
        if (start == profits.length || capacity <= 0) return 0;
        if (dp[capacity][start] != null) return dp[capacity][start];
        else {
            int notInclude = backtrack(profits, weights, capacity, start+1, dp);
            int include = 0;
            if (weights[start] <= capacity) {
                include = profits[start] + backtrack(profits, weights, capacity - weights[start], start+1, dp);
            }
            dp[capacity][start] = Math.max(include, notInclude);
        }
        return dp[capacity][start];
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
