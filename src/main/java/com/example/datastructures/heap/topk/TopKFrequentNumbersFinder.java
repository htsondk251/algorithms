package com.example.datastructures.heap.topk;

import java.util.*;

public class TopKFrequentNumbersFinder {
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topFreq = new PriorityQueue<>(k, Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            topFreq.add(entry);
            if (topFreq.size() > k) {
                topFreq.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        for (Map.Entry<Integer, Integer> entry : topFreq) {
            topNumbers.add(entry.getKey());
        }
        return topNumbers;
    }


}
