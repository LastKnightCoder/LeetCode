package leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> lists = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        lists.add(intervals[0]);
        int listStart = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] res = lists.get(listStart);
            if (intervals[i][0] <= res[1]) {
                if (res[1] < intervals[i][1]) {
                    res[1] = intervals[i][1];
                }
            } else {
                lists.add(intervals[i]);
                listStart++;
            }
        }

        int[][] merges = new int[lists.size()][2];
        int i = 0;
        for (int[] item: lists) {
            merges[i++] = item;
        }

        return merges;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}};
        Solution solution = new Solution();
        int[][] res = solution.merge(intervals);
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print("[");
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("] ");
        }
    }
}
