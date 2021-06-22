package leetcode61;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // 统计链表长度，以及找到最后一个节点
        ListNode cur = head;
        int l = 1;
        while (cur.next != null) {
            l++;
            cur = cur.next;
        }
        ListNode end = cur;

        k = k % l + 1;
        if (k == 0) {
            return head;
        }

        // 找到返回的根节点的前一个节点
        cur = head;
        for (int i = 1; i < l - k; i++) {
            cur = cur.next;
        }
        ListNode root = cur.next;

        cur.next = null;
        end.next = head;

        return root;
    }
}
