package leetcode92;

import java.util.LinkedList;

public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        ListNode end = dummyHead;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            end.next = cur;
            cur = cur.next;
            end = end.next;
        }

        LinkedList<ListNode> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            list.push(cur);
            cur = cur.next;
        }
        while (!list.isEmpty()) {
            end.next = list.pop();
            end = end.next;
        }
        end.next = cur;

        return dummyHead.next;
    }
}
