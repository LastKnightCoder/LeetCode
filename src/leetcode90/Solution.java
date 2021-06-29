package leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
           if (i == 0 || nums[i - 1] != nums[i]) {
               combine(i, new ArrayList<>());
           }
        }

        return res;
    }

    private void combine(int i, List<Integer> path) {
        path.add(nums[i]);
        res.add(path);

        for (int k = i + 1; k < nums.length; k++) {
            if (k == i + 1 || nums[k] != nums[k - 1]) {
                combine(k, new ArrayList<>(path));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 5};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
