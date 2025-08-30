package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 30/08/2025 12:54 PM
 */

public class _647_PalindromeSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        _647_PalindromeSubstrings i = new _647_PalindromeSubstrings();
        System.out.println(i.countSubstrings("aaa"));
        System.out.println(i.countSubstrings("abc"));
    }
}
