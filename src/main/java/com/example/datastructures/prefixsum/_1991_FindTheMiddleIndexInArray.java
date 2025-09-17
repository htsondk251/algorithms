package com.example.datastructures.prefixsum;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 17/09/2025 19:16
 */
public class _1991_FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {
        int[] prefixSum = calPrefixSum(nums);
        for (int i = 0; i < nums.length; i++) {
            int leftSum;
            int rightSum;
            if (i == 0) {leftSum = 0;} else leftSum = rangeSumQuery(prefixSum, 0, i);
            if (i == nums.length - 1) rightSum = 0; else rightSum = rangeSumQuery(prefixSum, i+1, nums.length - 1);
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    private int[] calPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }

    private int rangeSumQuery(int[] prefixSum, int start, int end) {
        if (start == 0) return prefixSum[end];
        return prefixSum[end] - prefixSum[start - 1];
    }

    public static void main(String[] args) {
        _1991_FindTheMiddleIndexInArray i = new _1991_FindTheMiddleIndexInArray();
//        System.out.println(i.findMiddleIndex(new int[]{1, 7, 3, 6, 5, 6}));     //3
        System.out.println(i.findMiddleIndex(new int[]{2,1,-1}));               //0
        System.out.println(i.findMiddleIndex(new int[]{2, 3, 5, 5, 3, 2}));     //-1
        System.out.println(i.findMiddleIndex(new int[]{2,3,-1,8,4}));           //3
    }
}
