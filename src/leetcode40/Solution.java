package leetcode40;

import java.util.*;

public class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        search(candidates, target, 0, new ArrayList<Integer>());

        return results;
    }

    private void search(int[] candidates, int target, int startIndex, ArrayList<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            search(candidates, target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidate = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
//        solution.combinationSum2(candidate, target);
        System.out.println(solution.combinationSum2(candidate, target));
    }
}
