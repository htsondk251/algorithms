package com.example.algorithms.dp;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 14/09/2025 2:13 PM
 */

public class _416_EqualSubsetSumPartition {

    public boolean canPartition(int[] num) {
        //TODO: Write - Your - Code
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];  //refactor: over
        }
        if (sum % 2 == 1) return false;

        Boolean[][] dp = new Boolean[num.length][sum/2+1];
        return canPartition(num, 0, sum/2, dp);
    }

    private boolean canPartition(int[] num, int startIndex, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (target < 0 || startIndex == num.length) return false;

        if (dp[startIndex][target] != null) return dp[startIndex][target];
        dp[startIndex][target] =canPartition(num, startIndex+1, target, dp) || canPartition(num, startIndex + 1, target - num[startIndex], dp);


        return dp[startIndex][target];
    }

    public static void main(String[] args) {
        _416_EqualSubsetSumPartition i = new _416_EqualSubsetSumPartition();
//        System.out.println(i.canPartition(new int[]{2,3,4,6}));
//        System.out.println(i.canPartition(new int[]{1,2,3,4}));
//        System.out.println(i.canPartition(new int[]{1,1,3,4,7}));
        System.out.println(i.canPartition(new int[]{2,2,3,5}));
    }
}
