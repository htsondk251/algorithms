package com.example.datastructures.heap.topk;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 26/09/2025 14:20
 */
public class _215_KthLargestNumber {
    public int findKthLargestNumber(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        _215_KthLargestNumber i = new _215_KthLargestNumber();
        System.out.println(i.findKthLargestNumber(new int[]{1, 5, 12, 2, 11, 6}, 3));
        System.out.println(i.findKthLargestNumber(new int[]{1, 5, 12, 2, 11, 6}, 4));
        System.out.println(i.findKthLargestNumber(new int[]{5, 12, 11, -1, 125}, 4));
    }
}
