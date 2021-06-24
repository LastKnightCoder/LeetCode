package leetcode89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        if (n < 0) {
            return res;
        }
        if (n == 0) {
            res.add(0);
            return res;
        }

        res = grayCode(n - 1);
        int l = res.size();
        for (int i = 0; i < l; i++) {
            res.add(res.get(l - i - 1) | 1 << (n - 1));
        }

        return res;
    }
}
