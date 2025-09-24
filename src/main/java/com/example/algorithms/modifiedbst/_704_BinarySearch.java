package com.example.algorithms.modifiedbst;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 24/09/2025 12:28
 */
public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) { return mid;}

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _704_BinarySearch i = new _704_BinarySearch();
//        System.out.println(i.search(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println(i.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(i.search(new int[]{4,6,10}, 10));
//        System.out.println(i.search(new int[]{10, 6, 4}, 10));
    }
}
