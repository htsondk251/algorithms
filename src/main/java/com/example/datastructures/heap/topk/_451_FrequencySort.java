package com.example.datastructures.heap.topk;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 29/09/2025 10:50
 */
public class _451_FrequencySort {
    public String sortCharacterByFrequency(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        freq.entrySet().forEach(maxHeap::add);
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        _451_FrequencySort i = new _451_FrequencySort();
        System.out.println(i.sortCharacterByFrequency("Programming"));
        System.out.println(i.sortCharacterByFrequency("abcbab"));
    }
}
