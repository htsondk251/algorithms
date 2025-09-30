package com.example.datastructures.orderedset;

import java.util.Objects;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 30/09/2025 13:37
 */
public class Interval implements Comparable<Interval> {
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
