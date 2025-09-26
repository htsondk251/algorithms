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
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][n-1-j] ^ 1;
                image[i][n-1-j] = temp;
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
