package com.example.test.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 25/08/2025 13:21
 */
public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int topIdx = stack.pop();
                result[topIdx] = i - topIdx;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        _739_DailyTemperatures i = new _739_DailyTemperatures();
        System.out.println(i.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));    //[1,1,4,2,1,1,0,0]
    }
}
