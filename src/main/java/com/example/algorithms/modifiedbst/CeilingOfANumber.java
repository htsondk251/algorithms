package com.example.algorithms.modifiedbst;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 25/09/2025 11:00 PM
 */

public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr[arr.length - 1] < key) return -1;
        if ( arr[0] > key) return 0;
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = right - (right - left) / 2;

            if (arr[mid] == key) {
                result = mid;
                break;
            }

            if (arr[mid] > key) {
                result = mid;
                right = mid - 1;
            }

            if (arr[mid] < key) {
//                result = right;
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CeilingOfANumber i  = new CeilingOfANumber();
//        System.out.println(i.searchCeilingOfANumber(new int[]{4,6,10}, 17));    //-1
//        System.out.println(i.searchCeilingOfANumber(new int[]{4,6,10}, 5));     //1
        System.out.println(i.searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12));   //4
    }
}
