package com.example.algorithms.xor;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 26/09/2025 10:42
 */
public class _476_NumberComplement {
    public int findComplement(int num) {
        int bits = 0;
        int temp = num;
        while (temp > 0) {
            bits++;
            temp = temp >> 1;
        }
        Integer.highestOneBit(num);
        int mask = ( 1 << bits ) - 1;

        return num ^ mask;
    }
}
