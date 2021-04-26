package leetcode57;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lists = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && newInterval[0] > intervals[index][0]) {
            lists.add(intervals[index++]);
        }

        int start = newInterval[0];
        int t = newInterval[1];
        if (index > 0 && start <= intervals[index - 1][1]) {
            start = intervals[index - 1][0];
            t = Math.max(intervals[index - 1][1], t);
            lists.remove(lists.size() - 1);
        }

        while (index < intervals.length && t >= intervals[index][0]) {
            t = Math.max(t, intervals[index][1]);
            index++;
        }

        lists.add(new int[]{start, t});

        for (int i = index; i < intervals.length; i++) {
            lists.add(intervals[i]);
        }

        int[][] merges = new int[lists.size()][2];
        int i = 0;
        for (int[] item: lists) {
            merges[i++] = item;
        }

        return merges;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newIntervals = {2, 3};
        int[][] res = new Solution().insert(intervals, newIntervals);
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
