package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 29/08/2025 11:06 PM
 */

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int temp = currentMax;
            currentMax = Math.max(current, Math.max(currentMax * current, currentMin * current));
            currentMin = Math.min(current, Math.min(temp * current, currentMin * current));

            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        _152_MaximumProductSubarray i = new _152_MaximumProductSubarray();
        System.out.println(i.maxProduct(new int[]{-4,-3,-2}));  //12
//        System.out.println(i.maxProduct(new int[]{2, 3, -2, 4})); //6
//        System.out.println(i.maxProduct(new int[]{-2, 0, -1}));   //0
//        System.out.println(i.maxProduct(new int[]{-2, 3, 2, -4})); //48
    }
}
