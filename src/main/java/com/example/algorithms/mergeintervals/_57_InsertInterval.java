package com.example.algorithms.mergeintervals;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 30/09/2025 09:55
 */
public class _57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> queue = new ArrayList<>();
        queue.addAll(Arrays.asList(intervals));

        queue.add(newInterval);

        queue.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> mergeIntervals = new ArrayList<>();

        int[] prev = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            int[] curr = queue.get(i);
            if (prev[1] >= curr[0]) {
                curr[0] = prev[0];
                curr[1] = Math.max(curr[1], prev[1]);
            } else {
                mergeIntervals.add(prev);
            }
            prev = curr;
        }
        mergeIntervals.add(queue.get(queue.size() - 1));

        int[][] result = new int[mergeIntervals.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = mergeIntervals.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        _57_InsertInterval test = new _57_InsertInterval();
        System.out.println(test.insert(new int[][]{{1,3}, {6,9}}, new int[]{2,5}));
        System.out.println(test.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}));
    }
}
