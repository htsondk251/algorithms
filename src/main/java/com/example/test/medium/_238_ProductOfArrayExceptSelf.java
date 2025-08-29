package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 29/08/2025 09:43
 */
public class _238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        right[n-1] = 1;
        for (int i = 1; i <= n-1; i++) {
            left[i] = left[i-1] * nums[i - 1];
        }

        for (int i = n-2 ; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        _238_ProductOfArrayExceptSelf i = new _238_ProductOfArrayExceptSelf();
        System.out.println(i.productExceptSelf(new int[]{1,2,3,4}));
    }
}
