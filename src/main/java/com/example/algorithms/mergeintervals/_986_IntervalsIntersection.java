package com.example.algorithms.mergeintervals;


import com.example.datastructures.orderedset.Interval;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 30/09/2025 13:36
 */
public class _986_IntervalsIntersection {
    public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        List<Interval> firstList = Arrays.asList(arr1);
        List<Interval> secondList = Arrays.asList(arr2);
        firstList.sort(Comparator.comparingInt(Interval::getStart));
        secondList.sort(Comparator.comparingInt(Interval::getStart));

        int firstIndex = 0, secondIndex = 0;

        while (firstIndex < firstList.size() && secondIndex < secondList.size()) {
            Interval first = firstList.get(firstIndex);
            Interval second = secondList.get(secondIndex);
            if (isOverlap(first, second)) {
                if (first.getEnd() < second.getEnd()) {
                    result.add(new Interval(Math.max(first.getStart(), second.getStart()),
                            first.getEnd()));
                    firstIndex++;
                } else {
                    result.add(new Interval(Math.max(first.getStart(), second.getStart()), second.getEnd()));
                    secondIndex++;
                }
            } else {
                if (first.getEnd() < second.getEnd()) {
                    firstIndex++;
                } else {
                    secondIndex++;
                }
            }
        }

        return result;
    }

    private boolean isOverlap(Interval i1, Interval i2) {
        return i1.getStart() >= i2.getStart() && i1.getStart() <= i2.getEnd() ||
                i2.getStart() >= i1.getStart() && i2.getStart() <= i1.getEnd();
    }

    public static void main(String[] args) {
        _986_IntervalsIntersection i = new _986_IntervalsIntersection();
        System.out.println(i.merge(new Interval[]{new Interval(0,2), new Interval(5,10), new Interval(13,23),
                        new Interval(24,25)},
                new Interval[]{new Interval(1,5), new Interval(8,12), new Interval(15,24), new Interval(25,26)}));
    }
}
