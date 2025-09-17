package com.example.datastructures.orderedset;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 17/09/2025 13:29
 */
public class _729_MyCalendar1 {

    public static List<Boolean> book(int[][] nums) {
        List<Boolean> results = new ArrayList<>();
        TreeSet<Interval> nonOverlap = new TreeSet<>();

        for (int[] num : nums) {
            Interval current = new Interval(num[0], num[1]);
            Interval lower = nonOverlap.lower(current);
            Interval higher = nonOverlap.higher(current);

            if (overlap(current, lower, higher)) {
                results.add(false);
            } else {
                results.add(nonOverlap.add(current));
            }
        }
        return results;
    }

    private static boolean overlap(Interval current,
                                   Interval lower,
                                   Interval higher) {
        return lower != null && lower.getEnd() > current.getStart() ||
                higher != null && higher.getStart() < current.getEnd();
    }


    public static void main(String[] args) {
        _729_MyCalendar1 i = new _729_MyCalendar1();
        System.out.println(i.book(new int[][]{
                {20, 29}, {13, 22}, {44, 50}, {1, 7}, {2, 10}, {14, 20}, {19, 25}, {36, 42}, {45, 50}, {47, 50},
                {39, 45}, {44, 50}, {16, 25}, {45, 50}, {45, 50}, {12, 20}, {21, 29}, {11, 20}, {12, 17}, {34, 40},
                {10, 18}, {38, 44}, {23, 32}, {38, 44}, {15, 20}, {27, 33}, {34, 42}, {44, 50}, {35, 40}, {24, 31}
        }));
//        System.out.println(i.book(new int[}[]{
//                {10, 20}, {15, 25}, {20, 30}
//        }));
//
//        System.out.println(i.book(new int[][]{
//                {5, 10}, {20, 30}, {10, 20}
//        }));
//        System.out.println(i.book(new int[][]{
//                {47,50},{33,41},{39,45},{33,42},{25,32},{26,35},{19,25},{3,8},{8,13},{18,27}
//        }));


    }
}

class Interval implements Comparable<Interval> {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() { return start; }
    public int getEnd() { return end; }

    @Override
    public int compareTo(Interval other) {
        int cmp = Integer.compare(this.start, other.start);
        if (cmp == 0) {
            cmp = Integer.compare(this.end, other.end);
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval that = (Interval) o;
        return start == that.start && end == that.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
