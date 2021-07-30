//You are given the head of a singly linked-list. The list can be represented as
//: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 104]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 
// 👍 3593 👎 157


package q.q143;

import dataStructure.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        solution.reorderList(n1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            ListNode mid = findMid(head);
            ListNode n2 = reverse(mid);
            merge(head, n2);
        }

        ListNode findMid(ListNode head){

            ListNode n1 = head;
            ListNode n2 = head;

            while (n2.next != null){
                n1 = n1.next;
                n2 = n2.next;

                if (n2.next != null) n2 = n2.next;
            }

            return n1;
        }

        ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode cur = head;

            while (cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }

        ListNode merge(ListNode n1, ListNode n2){
            ListNode dum = new ListNode();
            ListNode cur = dum;
            boolean use1 = true;
            while (n1 != null && n2!= null){
                if (use1){
                    cur.next = n1;
                    n1 = n1.next;

                } else {
                    cur.next = n2;
                    n2 = n2.next;
                }

                use1 = !use1;
                cur = cur.next;
            }

            return dum.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}