package leetcode86;

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode greaterDummyHead = new ListNode();
        ListNode greaterCur = greaterDummyHead;

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        ListNode iterCur = head;
        while (iterCur != null) {
            if (iterCur.val < x) {
                cur.next = new ListNode(iterCur.val);
                cur = cur.next;
            } else {
                greaterCur.next = new ListNode(iterCur.val);
                greaterCur = greaterCur.next;
            }
            iterCur = iterCur.next;
        }

        cur.next = greaterDummyHead.next;

        return dummyHead.next;
    }
}
