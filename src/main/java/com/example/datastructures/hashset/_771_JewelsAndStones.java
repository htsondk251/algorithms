package com.example.datastructures.hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 15/08/2025 13:31
 */
public class _771_JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> checkList = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            checkList.add(ch);
        }
        for (char c : stones.toCharArray()) {
            if (checkList.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _771_JewelsAndStones i = new _771_JewelsAndStones();
        System.out.println(i.numJewelsInStones( "aA", "aAAbbbb")); //3
    }
}
