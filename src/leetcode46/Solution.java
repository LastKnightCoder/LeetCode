package leetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        permute(nums, new ArrayList<Integer>());
        return results;
    }

    private void permute(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                permute(nums, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = new Solution().permute(nums);
        System.out.println(results);
    }
}
