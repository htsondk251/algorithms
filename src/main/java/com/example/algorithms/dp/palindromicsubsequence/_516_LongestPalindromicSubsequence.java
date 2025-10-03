package com.example.algorithms.dp.palindromicsubsequence;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 03/10/2025 11:40 PM
 */

public class _516_LongestPalindromicSubsequence {
    public int findLPSLength(String st) {

        int n = st.length();
        int[][] dp = new int[n][n];
        return recursive(st, 0, st.length()-1, dp);
    }

    private int recursive(String st, int start, int end, int[][] dp) {

        //base case
        if (start > end) return 0;
        if (start == end) return 1;

        //logic + call next step
        if (dp[start][end] != 0) return dp[start][end];

        if (st.charAt(start) == st.charAt(end)) {
            dp[start][end] = 2 + recursive(st, start+1, end-1, dp);
            return dp[start][end];
        }

        dp[start][end] = Math.max(recursive(st,start+1, end, dp), recursive(st, start, end-1, dp));

        return dp[start][end];

    }


    public static void main(String[] args) {
        _516_LongestPalindromicSubsequence i = new _516_LongestPalindromicSubsequence();
        System.out.println(i.findLPSLength("abdbca"));
    }
}
