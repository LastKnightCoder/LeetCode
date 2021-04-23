package leetcode39;

import java.util.*;

public class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        search(candidates, 0, target, path, 0);

        return results;
    }

    private void search(int[] candidates, int startLevel, int target, ArrayList<Integer> path, int sum) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> list = new ArrayList<>(path);
            results.add(list);
            return;
        }

        for (int i = startLevel; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            search(candidates, i, target, path, sum);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidate, target));
    }
}
