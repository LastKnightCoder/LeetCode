package leetcode82;

import java.util.List;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }

        while (head.next != null) {
            if (head.val == head.next.val) {
                head = head.next;
            } else {
                break;
            }
        }

        return deleteDuplicates(head.next);
    }
}
