package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 30/08/2025 10:09 AM
 */

public class _11_ContainerWithMostWarter {
    public int maxArea(int[] height) {
        int maxArea = 0; // To store the maximum area found
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int width = end - start;
            int currentHeight = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, width * currentHeight);

            while (start < end && height[start] <= currentHeight) start++;
            while (start < end && height[end] <= currentHeight) end--;
        }
        return maxArea;
    }


    public static void main(String[] args) {
        _11_ContainerWithMostWarter i = new _11_ContainerWithMostWarter();
        System.out.println(i.maxArea(new int[]{5,2,4,2,6,3}));
    }
}
