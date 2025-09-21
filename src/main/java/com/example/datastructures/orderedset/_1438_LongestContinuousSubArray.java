package com.example.datastructures.orderedset;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 21/09/2025 12:37 AM
 */

public class _1438_LongestContinuousSubArray {
    public int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        TreeMap<Integer, Integer> sequence = new TreeMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sequence.put(nums[right], sequence.getOrDefault(nums[right], 0) + 1);

            while (sequence.lastKey() - sequence.firstKey() > limit) {
                sequence.put(nums[left], sequence.get(nums[left]) - 1);
                if (sequence.get(nums[left]) == 0) {
                    sequence.remove(nums[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        _1438_LongestContinuousSubArray i = new _1438_LongestContinuousSubArray();
        System.out.println(i.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));   //3
    }
}
