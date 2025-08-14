package com.example.datastructures.heap.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {
    public List<Integer> findKLargestNumbers(int[] nums, int k) {
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

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        TopKElements i = new TopKElements();
        System.out.println(i.findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3));
        System.out.println(i.findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3));
    }
}
