package com.example.datastructures.prefixsum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 23/09/2025 10:52 PM
 */
public class _930_BinarySubArraysWithSum_Queue {
    public int numSubArraysWithSum(int[] nums, int goal) {
        int left = 0;
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                queue.add(i);
            }

            if (queue.size() > goal) {
                left = queue.pollFirst() + 1;
            }

            if (queue.size() == goal) {
                int right = queue.isEmpty() ? i : queue.peek();
                count += right - left + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        _930_BinarySubArraysWithSum_Queue i = new _930_BinarySubArraysWithSum_Queue();

        System.out.println(i.numSubArraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(i.numSubArraysWithSum(new int[]{1, 1, 0, 1, 1}, 2));
    }
}
