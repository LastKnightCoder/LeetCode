package leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);

        permuteUnique(nums, new ArrayList<>());
        return results;
    }

    private void permuteUnique(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                path.add(nums[i]);
                permuteUnique(nums, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> results = new Solution().permuteUnique(nums);
        System.out.println(results);
    }
}
