package leetcode83;

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

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        head.next = deleteDuplicates(head.next);
        return head;
    }
}
