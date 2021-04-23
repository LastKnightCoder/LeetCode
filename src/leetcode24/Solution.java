package leetcode24;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode after = head.next;


        head.next = swapPairs(after.next);
        after.next = head;
        return after;
    }
}
