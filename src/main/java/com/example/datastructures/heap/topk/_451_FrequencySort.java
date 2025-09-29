package com.example.datastructures.heap.topk;

import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 29/09/2025 10:50
 */
public class _451_FrequencySort {
    public String sortCharacterByFrequency(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(e -> repeat(e.getKey(), e.getValue()))
                .collect(Collectors.joining());
    }

    private String repeat(Character key, Long count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(key);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _451_FrequencySort i = new _451_FrequencySort();
        System.out.println(i.sortCharacterByFrequency("Programming"));
        System.out.println(i.sortCharacterByFrequency("abcbab"));
    }
}
