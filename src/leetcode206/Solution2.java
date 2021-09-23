package leetcode206;

import java.util.LinkedList;

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = head;
        LinkedList<ListNode> list = new LinkedList<>();
        while (cur != null) {
            list.push(cur);
            cur = cur.next;
        }
        cur = dummyHead;
        while (!list.isEmpty()) {
            cur.next = list.pop();
            cur = cur.next;
        }
        cur.next = null;

        return dummyHead.next;
    }
}
