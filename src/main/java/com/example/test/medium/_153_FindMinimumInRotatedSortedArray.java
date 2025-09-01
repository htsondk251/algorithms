package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 31/08/2025 10:04 AM
 */

public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;


            if (nums[mid] > nums[right]) {
                left = mid + 1;

            } else {
                right = mid;

            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        _153_FindMinimumInRotatedSortedArray i = new _153_FindMinimumInRotatedSortedArray();
        System.out.println(i.findMin(new int[]{0,1,2,4,5,6,7}));
        System.out.println(i.findMin(new int[]{3,4,5,1,2}));
        System.out.println(i.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
