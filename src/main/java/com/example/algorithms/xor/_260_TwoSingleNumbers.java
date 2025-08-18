package com.example.algorithms.xor;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 18/08/2025 09:34
 */
public class _260_TwoSingleNumbers {
    public int[] findSingleNumbers(int[] nums) {
        int n1xn2 = 0;
        for (int num: nums) {
            n1xn2 ^= num;
        }

        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit <<= 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        _260_TwoSingleNumbers i = new _260_TwoSingleNumbers();
        System.out.println(i.findSingleNumbers(new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5}));
    }
}
