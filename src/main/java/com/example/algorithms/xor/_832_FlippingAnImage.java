package com.example.algorithms.xor;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 26/09/2025 11:14
 */
public class _832_FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for (int i = 0; i < image.length; i++) {
            int[] clone = new int[n];
            for (int j = 0; j < n; j++) {
                clone[j] = image[i][j];
            }

            for (int j = 0; j < n; j++) {
                image[i][j] = clone[n-1-j] ^ 1;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        _832_FlippingAnImage i = new _832_FlippingAnImage();
        System.out.println(i.flipAndInvertImage(new int[][]{
                {1,1,0},{1,0,1},{0,0,0}
        }));
    }
}
