package com.example.datastructures.hashset;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        Set<Character> window = new HashSet<>();
        int start = 0, end = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            while (window.contains(c)) {
                window.remove(str.charAt(start));
                start++;
            }
            window.add(c);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _3_LongestSubstringWithoutRepeating i = new _3_LongestSubstringWithoutRepeating();
        System.out.println(i.lengthOfLongestSubstring("abcdaef"));  //6
        System.out.println(i.lengthOfLongestSubstring("aaaaa"));    //1
        System.out.println(i.lengthOfLongestSubstring("abrkaabcdefghijjxxx"));  //10

    }
}
