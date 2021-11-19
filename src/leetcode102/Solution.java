package leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if ( root == null) {
            return results;
        }
        int curLevelNum = 1;
        int nextLevelNum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            curLevelNum--;

            if (node.left != null) {
                queue.add(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNum++;
            }

            if (curLevelNum == 0) {
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
                results.add(list);
                list = new ArrayList<>();
            }
        }

        return results;
    }
}
