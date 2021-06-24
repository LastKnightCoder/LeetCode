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
        // 返回的根节点的前一个节点
        ListNode root = new ListNode();
        // 用以表示返回链表的末尾
        ListNode cur = root;

        // 遍历链表时的当前节点
        ListNode iterCur = head;
        // 是否与前一个元素重复
        boolean duplicated = false;

        while (iterCur.next != null) {
            // 与后面元素的值不同
            if (iterCur.next.val != iterCur.val) {
                // 如果与前面的元素不重复，则添加到返回的链表
                if (!duplicated) {
                    cur.next = new ListNode(iterCur.val);
                    cur = cur.next;
                } else {
                    // 如果与前面的元素重复，则更新为不重复
                    duplicated = false;
                }
            } else {
                // 与后面的元素相同，如果更新为重复
                if (!duplicated) {
                    duplicated = true;
                }
            }
            iterCur = iterCur.next;
        }

        // 最后一个元素需要单独判断，因为没有下一个元素，所以只需判断是否与前面元素重复
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
