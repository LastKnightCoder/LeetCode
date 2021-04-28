package leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;

    private void combine(int start, ArrayList<Integer> path, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start + 1; i <= nums.length - (k - path.size()); i++) {
            path.add(nums[i]);
            combine(i, path, k);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        for (int k = 0; k <= nums.length; k++) {
            combine(-1, new ArrayList<>(), k);
        }
        return res;
    }
}
