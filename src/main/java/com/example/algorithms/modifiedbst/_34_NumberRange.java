package com.example.algorithms.modifiedbst;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 25/09/2025 11:28 PM
 */

public class _34_NumberRange {
    public int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        // TODO: Write your code here
        int left =0, right = arr.length -1;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (arr[mid] == key) {  //found
                left = mid;
                right = mid;
                while (left >= 0  && arr[left] == key) {
                    left--;
                }
                result[0] = left+1;
                while (right < arr.length && arr[right] == key) {
                    right++;
                }
                result[1] = right-1;
                break;
            }

            if (arr[mid] > key) {
                right = mid -1;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _34_NumberRange i = new _34_NumberRange();
        System.out.println(i.findRange(new int[]{4, 6, 6, 6, 9}, 6));
        System.out.println(i.findRange(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 1));
    }
}
