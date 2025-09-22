package com.example.datastructures.prefixsum;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 22/09/2025 17:57
 */
public class _930_BinarySubArraysWithSum {
    public int numSubArraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0 ) {
            return 0;
        }
        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        _930_BinarySubArraysWithSum i = new _930_BinarySubArraysWithSum();
//        System.out.println(i.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(i.numSubArraysWithSum(new int[]{1, 1, 0, 1, 1}, 2));
    }

}
