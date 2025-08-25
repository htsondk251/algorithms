package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 25/08/2025 13:21
 */
public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _739_DailyTemperatures i = new _739_DailyTemperatures();
        System.out.println(i.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));    //[1,1,4,2,1,1,0,0]
    }
}
