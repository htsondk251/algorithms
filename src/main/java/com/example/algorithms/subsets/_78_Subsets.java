package com.example.algorithms.subsets;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int n = subsets.size();
            for (int i=0; i <n; i++) {
                List<Integer> clone = new ArrayList<>(subsets.get(i));
                clone.add(num);
                subsets.add(clone);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        _78_Subsets i = new _78_Subsets();
        System.out.println(i.subsets(new int[]{1,5,3}));
    }
}
