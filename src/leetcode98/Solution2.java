package leetcode98;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        return inOrder(root, list);
    }

    private boolean inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return true;
        }

        if (!inOrder(root.left, list)) {
            return false;
        }

        if (list.size() != 0 && root.val <= list.get(list.size() - 1)) {
            return false;
        }
        list.add(root.val);

        if (!inOrder(root.right, list)) {
            return false;
        }

        return true;
    }
}
