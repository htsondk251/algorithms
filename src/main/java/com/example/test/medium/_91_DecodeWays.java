package com.example.test.medium;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 08/09/2025 13:29
 */
public class _91_DecodeWays {
    public int numDecodings(String s) {
        //backtrack
        return decode(s, 0);
    }

    private int decode(String s, int start) {
        int n = s.length();
        if (start == n -1 ) return s.charAt(start) > '0' ? 1 : 0;
        if (start == n-2) {
            int twoCharsValue = Integer.parseInt(s.substring(start, start + 2));
            if ( twoCharsValue <= 26 && twoCharsValue > 0) return 1 + decode(s, start + 1);
            else return decode(s, start + 1);
        }
        int count = decode(s, start + 1);
        int twoCharsValue = Integer.parseInt(s.substring(start, start + 2));
        if (twoCharsValue <= 26 && twoCharsValue > 0) {
            count += decode(s, start + 2);
        }
        return count;
    }

    public static void main(String[] args) {
        _91_DecodeWays i = new _91_DecodeWays();
        System.out.println(i.numDecodings("0"));   //1
        System.out.println(i.numDecodings("00"));
        System.out.println(i.numDecodings("12"));   //2
        System.out.println(i.numDecodings("226"));  //3
    }
}
