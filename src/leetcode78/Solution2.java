package leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            combine(i, new ArrayList<>());
        }

        return res;
    }

    private void combine(int i, ArrayList<Integer> path) {
        path.add(nums[i]);
        res.add(path);

        for (int k = i + 1; k < nums.length; k++) {
            combine(k, new ArrayList<>(path));
        }
    }
}
