package leetcode25;

import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        int left = k;
        while (left > 0) {
            if (cur == null) {
                return head;
            }
            stack.push(cur);
            cur = cur.next;
            left--;
        }

        ListNode root = stack.pop();
        ListNode reverseCur = root;
        while (!stack.isEmpty()) {
            reverseCur.next = stack.pop();
            reverseCur = reverseCur.next;
        }
        reverseCur.next = reverseKGroup(cur, k);
        return root;
    }
}
