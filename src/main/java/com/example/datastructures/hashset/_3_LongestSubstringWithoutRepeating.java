package com.example.datastructures.hashset;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        char[] chars = str.toCharArray();
        int n = chars.length;
        Set<Character> uniqueChars = new HashSet<>();
        int start = 0, end = 0;
        while (end < n) {
            if (uniqueChars.add(chars[end])) {
                end++;
            } else {
                //tinh maxLength
                maxLength = Math.max(maxLength, end - start);
                //loai bo char trung
                while (start < end && chars[start] != chars[end]) {
                    uniqueChars.remove(chars[start]);
                    start++;
                }
                start++;
                end++;
            }
        }
        return Math.max(maxLength, end - start);
    }

    public static void main(String[] args) {
        _3_LongestSubstringWithoutRepeating i = new _3_LongestSubstringWithoutRepeating();
        System.out.println(i.lengthOfLongestSubstring("abcdaef"));  //6
        System.out.println(i.lengthOfLongestSubstring("aaaaa"));    //1
        System.out.println(i.lengthOfLongestSubstring("abrkaabcdefghijjxxx"));  //10

    }
}
