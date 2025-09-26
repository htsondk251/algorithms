package com.example.algorithms.xor;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 26/09/2025 10:14
 */
public class _260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] array = freq.entrySet().stream()
                .filter(e -> 1 == e.getValue())
                .mapToInt(Map.Entry::getKey)
                .toArray();
        return array;
    }

    public static void main(String[] args) {
        _260_SingleNumberIII i = new _260_SingleNumberIII();
        System.out.println(i.singleNumber(new int[]{1,2,1,3,2,5}));
    }
}
