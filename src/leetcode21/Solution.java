package leetcode21;

public class Solution {

     public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummyNode = new ListNode(0);
        ListNode cuerNode = dummyNode;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cuerNode.next = p1;
                cuerNode = cuerNode.next;
                p1 = p1.next;
            } else {
                cuerNode.next = p2;
                cuerNode = cuerNode.next;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            cuerNode.next = p2;
        } else if (p2 == null) {
            cuerNode.next = p1;
        }

        return dummyNode.next;
    }
}
