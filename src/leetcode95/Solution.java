package leetcode95;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        if (left == right) {
            list.add(new TreeNode(left));
            return list;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTreeRoot = generateTrees(left, i - 1);
            List<TreeNode> rightTreeRoot = generateTrees(i + 1, right);

            for (int m = 0; m < leftTreeRoot.size(); m++) {
                for (int n = 0; n < rightTreeRoot.size(); n++) {
                    TreeNode root = new TreeNode(i, leftTreeRoot.get(m), rightTreeRoot.get(n));
                    list.add(root);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> list = solution.generateTrees(4);
        System.out.println(list.size());
    }


}
