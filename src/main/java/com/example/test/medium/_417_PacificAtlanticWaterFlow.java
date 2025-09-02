package com.example.test.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();         //[[0,2], [1,3]]
        Boolean[][][] dp = new Boolean[heights.length][heights[0].length][2]; //[[[true,false], [true,false], ...]]
        int m = heights.length;;
        int n = heights[0].length;;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( canFlow(heights, i, j, dp)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean canFlow(int[][] heights, int row, int col, Boolean[][][] dp) {
        int m = heights.length;
        int n = heights[0].length;
        return toPacific(heights, row, col, dp, new boolean[m][n]) && toAtlantic(heights, row, col, dp, new boolean[m][n]);
    }

    private boolean toPacific(int[][] heights, int row, int col, Boolean[][][] dp, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        visited[row][col] = true;
        if (row == 0 || col == 0) return true;
        if ( row == m || col == n ) return false;
        if ( dp[row][col][0] != null) return dp[row][col][0];
        else {
            dp[row][col][0] = findRouteToPacific(heights, row, col, dp, visited);
        }
        return dp[row][col][0];
    }

    private Boolean findRouteToPacific(int[][] heights, int row, int col, Boolean[][][] dp, boolean[][] visited) {
        boolean canFlowToPacific = false;
        int currentHeight = heights[row][col];
        if (row >=1 && !visited[row-1][col] && currentHeight >= heights[row-1][col]) {
            canFlowToPacific = toPacific(heights, row-1, col, dp, visited);
        }
        if (row <= heights.length - 2 && !visited[row+1][col] && currentHeight >= heights[row+1][col]) {
            canFlowToPacific = canFlowToPacific || toPacific(heights, row+1, col, dp, visited);
        }

        if (col >= 1 && !visited[row][col-1] && currentHeight >= heights[row][col-1]) {
            canFlowToPacific = canFlowToPacific || toPacific(heights, row, col-1, dp, visited);
        }

        if (col <= heights[0].length - 2 && !visited[row][col-1] && currentHeight >= heights[row][col+1]) {
            canFlowToPacific = canFlowToPacific || toPacific(heights, row, col+1, dp, visited);
        }

        return canFlowToPacific;
    }

    private boolean toAtlantic(int[][] heights, int row, int col, Boolean[][][] dp, boolean[][] visited) {
        if ( row == heights.length - 1 || col == heights[0].length - 1) return true;
        if ( row == -1 || col == -1) return false;
        visited[row][col] = true;
        if (dp[row][col][1] != null) return dp[row][col][1];
        else {
            dp[row][col][1] = findRouteToAtlantic(heights, row, col, dp, visited);
        }
        return dp[row][col][1];
    }

    private Boolean findRouteToAtlantic(int[][] heights, int row, int col, Boolean[][][] dp, boolean[][] visited) {
        boolean canFlowToAtlantic = false;

        int currentHeight = heights[row][col];
        if (row >=1 && !visited[row-1][col] && currentHeight >= heights[row-1][col]) {
            canFlowToAtlantic = toAtlantic(heights, row-1, col, dp, visited);
        }

        if (row <= heights.length - 2 && !visited[row+1][col] && currentHeight >= heights[row+1][col]) {
            canFlowToAtlantic = canFlowToAtlantic || toAtlantic(heights, row+1, col, dp, visited);
        }

        if (col>=1 && !visited[row][col-1] && currentHeight >= heights[row][col-1]) {
            canFlowToAtlantic = canFlowToAtlantic || toAtlantic(heights, row, col-1, dp, visited);
        }

        if (col <= heights[0].length && !visited[row][col+1] && currentHeight >= heights[row][col+1]) {
            canFlowToAtlantic = canFlowToAtlantic || toAtlantic(heights, row, col+1, dp, visited);
        }

         return canFlowToAtlantic;
    }

    public static void main(String[] args) {
        _417_PacificAtlanticWaterFlow i = new _417_PacificAtlanticWaterFlow();
//        System.out.println(i.pacificAtlantic(new int[][]{
//                {1,2,2,3,5},
//                {3,2,3,4,4},
//                {2,4,5,3,1},
//                {6,7,1,4,5},
//                {5,1,1,2,4}
//        }));

//        System.out.println(i.pacificAtlantic(new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        }));

        System.out.println(i.pacificAtlantic(new int[][]{
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        }));
    }

}
