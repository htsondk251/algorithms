package com.example.algorithms.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinationRecursive(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void findCombinationRecursive(int[] candidates, int target, int start, List<Integer> currentList) {
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                List<Integer> clone = new ArrayList<>(currentList);
                clone.add(candidates[i]);
                result.add(clone);
                //backtrack
                break;
            }
            if (target - candidates[i] < 0) break;
            if (target - candidates[i] > 0) {
                //continue
                List<Integer> clone = new ArrayList<>(currentList);
                clone.add(candidates[i]);
                findCombinationRecursive(candidates, target - candidates[i], i, clone);
            }
        }
        if (!currentList.isEmpty()) {
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum i = new _39_CombinationSum();
        System.out.println(i.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
