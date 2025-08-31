package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 31/08/2025 10:04 AM
 */

public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {

        if (left == right) return nums[left];
        if (left == right - 1) return Math.min(nums[left], nums[right]);
        int mid = (left + right) /2;
        if (nums[left] > nums[mid]) {
            return findMin(nums, left, mid);
        }

        if (nums[mid] > nums[right]) {
            return findMin(nums, mid, right);
        }

        return Math.min(nums[left], nums[mid]);
    }

    public static void main(String[] args) {
        _153_FindMinimumInRotatedSortedArray i = new _153_FindMinimumInRotatedSortedArray();
//        System.out.println(i.findMin(new int[]{0,1,2,4,5,6,7}));
        System.out.println(i.findMin(new int[]{3,4,5,1,2}));
    }
}
