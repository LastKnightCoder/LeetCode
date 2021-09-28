package leetcode98;

public class Solution {
    public static class TreeNode {
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

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean valid = true;

        if (root.left != null) {
            valid = valid && root.left.val < root.val && isValidBST(root.left);
        }
        if (valid && root.right != null) {
            valid = valid && root.right.val > root.val && isValidBST(root.right);
        }

        return valid;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(treeNode));
    }
}
