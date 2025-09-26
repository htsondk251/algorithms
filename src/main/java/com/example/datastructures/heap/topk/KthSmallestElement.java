package com.example.datastructures.heap.topk;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 26/09/2025 14:37
 */
public class KthSmallestElement {
    public int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallestElement i = new KthSmallestElement();
        System.out.println(i.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 6}, 3));
        System.out.println(i.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 6}, 4));
        System.out.println(i.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3));
    }
}
