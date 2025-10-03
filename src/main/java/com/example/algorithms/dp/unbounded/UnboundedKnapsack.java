package com.example.algorithms.dp.unbounded;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 03/10/2025 18:50
 */
public class UnboundedKnapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length + 1][capacity + 1];
        return recursive(profits, weights, capacity, 0, dp);
    }

    private int recursive(int[] profits, int[] weights, int capacity, int index, int[][] dp) {

        //base case
        if (capacity <= 0 || index >= profits.length) {
            return 0;
        }

        //logic
        if (dp[index][capacity] != 0) {return dp[index][capacity];}
        int choose = 0;
        if (weights[index] <= capacity) {
            choose = profits[index] + recursive(profits, weights, capacity - weights[index], index, dp);
        }

        int ignore = recursive(profits, weights, capacity, index + 1, dp);

        dp[index][capacity] = Math.max(choose, ignore);

        return dp[index][capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack i = new UnboundedKnapsack();
        System.out.println(i.solveKnapsack(
                new int[]{15, 20, 50},
                new int[]{1, 2, 3},
                5
        ));
    }
}
