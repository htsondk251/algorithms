package com.example.algorithms.backtrack;

import java.util.*;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 22/08/2025 16:36
 */
public class _1593_MaxUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        List<List<String>> uniqueSubstrings = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), uniqueSubstrings);
        return uniqueSubstrings.stream().mapToInt(List::size).max().orElse(0);
    }

    private void backtrack(String s, int start, List<String> currentSubstrings, List<List<String>> uniqueSubstrings) {
        if (start >= s.length()) {
            uniqueSubstrings.add(new ArrayList<>(currentSubstrings));
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(start, start + i);
            if (currentSubstrings.contains(sub)) continue;
            currentSubstrings.add(sub);
            backtrack(s, start + i, currentSubstrings, uniqueSubstrings);
            currentSubstrings.remove(currentSubstrings.size() - 1);
        }
    }

//    private boolean isUnique(String substring) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < substring.length(); i++) {
//            if (!set.add(substring.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        _1593_MaxUniqueSubstrings i = new _1593_MaxUniqueSubstrings();
        System.out.println(i.maxUniqueSplit("ababccc"));
        System.out.println(i.maxUniqueSplit("abcabc"));
    }
}
