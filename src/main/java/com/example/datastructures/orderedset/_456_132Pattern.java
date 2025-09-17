package com.example.datastructures.orderedset;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 17/09/2025 09:12
 */
public class _456_132Pattern {
    public boolean find132pattern(int[] nums) {
        int ak = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < ak) return true;

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                ak = stack.pop();
            }
            stack.push(nums[i]);

        }
        return false;
    }

    public static void main(String[] args) {
        _456_132Pattern i  = new _456_132Pattern();
        System.out.println(i.find132pattern(new int[]{1, 2, 3, 4, 5, 6, 7}));   //false
        System.out.println(i.find132pattern(new int[]{1, 5, -3, 6, -1}));       //true
        System.out.println(i.find132pattern(new int[]{3, 5, 0, 3, 4}));         //true
    }
}
