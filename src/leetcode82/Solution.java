package leetcode82;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode();
        ListNode cur = root;

        ListNode iterCur = head;
        boolean duplicated = false;

        while (iterCur.next != null) {
            if (iterCur.next.val != iterCur.val) {
                if (!duplicated) {
                    cur.next = new ListNode(iterCur.val);
                    cur = cur.next;
                } else {
                    duplicated = false;
                }
            } else {
                if (!duplicated) {
                    duplicated = true;
                }
            }
            iterCur = iterCur.next;
        }

        if (!duplicated) {
            cur.next = new ListNode(iterCur.val);
        }

        return root.next;
    }

    public void printList(ListNode root) {
         ListNode cur = root;
         while (cur != null) {
             System.out.print(cur.val + "->");
             cur = cur.next;
         }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(3);
//        root.next.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.printList(root);
        ListNode retRoot = solution.deleteDuplicates(root);
        solution.printList(retRoot);
    }
}
