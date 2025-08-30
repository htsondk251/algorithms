package com.example.test.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 30/08/2025 12:54 PM
 */

public class _647_PalindromeSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        _647_PalindromeSubstrings i = new _647_PalindromeSubstrings();
        System.out.println(i.countSubstrings("aaa"));
        System.out.println(i.countSubstrings("abc"));
    }
}
