package com.example.datastructures.orderedset;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 22/09/2025 17:20
 */
public class _1438_LongestContinuousSubArray {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);

            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[right]);


            while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (maxQueue.peekFirst() == nums[left]) {
                    maxQueue.pollFirst();
                }

                if (minQueue.peekFirst() == nums[left]) {
                    minQueue.pollFirst();
                }

                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        _1438_LongestContinuousSubArray i = new _1438_LongestContinuousSubArray();
        System.out.println(i.longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
