package com.example.algorithms.subsets;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> currentLevelSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                List<Integer> clone = new ArrayList<>(subset);
                clone.add(num);
                currentLevelSubsets.add(clone);
            }
            subsets.addAll(currentLevelSubsets);
        }
        return subsets;
    }

    public static void main(String[] args) {
        _78_Subsets i = new _78_Subsets();
        System.out.println(i.subsets(new int[]{1,5,3}));
    }
}
