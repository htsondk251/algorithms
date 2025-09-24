package com.example.algorithms.modifiedbst;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 24/09/2025 12:28
 */
public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        return bst(nums, 0, nums.length - 1, target);
    }

    private int bst(int[] nums, int left, int right, int target) {
        if (left > right || left == right && nums[left] != target) {return -1;}
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return bst(nums, mid+1, right, target);
        else return bst(nums, left, mid, target);
    }

    public static void main(String[] args) {
        _704_BinarySearch i = new _704_BinarySearch();
//        System.out.println(i.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(i.search(new int[]{-1,0,3,5,9,12}, 2));
//        System.out.println(i.search(new int[]{10, 6, 4}, 10));
    }
}
