package leetcode23;

import java.util.Arrays;

// 归并
public class Solution2 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0 , lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        ListNode leftList = null;
        ListNode rightList = null;

        int mid = left + (right - left) / 2;
        leftList = mergeKLists(lists, left, mid);
        rightList = mergeKLists(lists, mid + 1, right);

        return mergeTwoList(leftList, rightList);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
        } else {
            cuerNode.next = p1;
        }

        return dummyNode.next;
    }
}
