package com.example.datastructures.prefixsum;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 17/09/2025 19:16
 */
public class _1991_FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _1991_FindTheMiddleIndexInArray i = new _1991_FindTheMiddleIndexInArray();
        System.out.println(i.findMiddleIndex(new int[]{1, 7, 3, 6, 5, 6}));     //3
        System.out.println(i.findMiddleIndex(new int[]{2,1,-1}));               //0
        System.out.println(i.findMiddleIndex(new int[]{2, 3, 5, 5, 3, 2}));     //-1
        System.out.println(i.findMiddleIndex(new int[]{2,3,-1,8,4}));           //3
    }
}
