package leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return res;
        }

        this.n = n;
        this.k = k;

        combine(0, new ArrayList<>());
        return res;
    }

    public void combine(int start, ArrayList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start + 1; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combine(i, path);
            path.remove(path.size() - 1);
        }
    }
}
