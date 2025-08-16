package com.example.algorithms.greedy;

import java.util.Arrays;

public class _646_MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int maxLength = 0;
        int end = -1001;
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                maxLength++;
                end = pair[1];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _646_MaximumLengthOfPairChain i = new _646_MaximumLengthOfPairChain();
        System.out.println(i.findLongestChain(new int[][]{{7,8}, {5,6}, {1,2}, {3,5}, {4,5}, {2,3}}));
        System.out.println(i.findLongestChain(new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}})); //
        System.out.println(i.findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}})); //3
    }

}
