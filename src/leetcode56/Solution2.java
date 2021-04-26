package leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        List<int[]> lists = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);

        int start = intervals[0][0];
        int t = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= t) {
                t = Math.max(t, intervals[i][1]);
            } else {
                lists.add(new int[]{start, t});
                start = intervals[i][0];
                t = intervals[i][1];
            }
        }
        lists.add(new int[]{start, t});

        int[][] merges = new int[lists.size()][2];
        int i = 0;
        for (int[] item: lists) {
            merges[i++] = item;
        }

        return merges;
    }
}
