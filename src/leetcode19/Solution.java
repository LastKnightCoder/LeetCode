package leetcode19;


import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }

        ListNode slow = dummyHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode deleteNode = slow.next;
        slow.next = deleteNode.next;
        deleteNode.next = null;

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;

        return retNode;
    }
}
