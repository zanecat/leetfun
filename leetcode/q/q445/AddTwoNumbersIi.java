//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contains a sin
//gle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
// 
//
// Example 3: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
//
// 
// Follow up: Could you solve it without reversing the input lists? 
// Related Topics Linked List Math Stack 
// 👍 2676 👎 206


package q.q445;

import dataStructure.ListNode;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            var r1 = reverse(l1);
            var r2 = reverse(l2);
            return reverse(add(r1, r2, 0));
        }

        ListNode add(ListNode n1, ListNode n2, int c){
            if (n1 == null && n2 ==null && c ==0){
                return null;
            }

            int v1 = n1 == null ? 0 : n1.val;
            int v2 = n2 == null ? 0 : n2.val;

            ListNode node = new ListNode((v1 + v2 +c) % 10);
            node.next =add(n1 == null ? null : n1.next, n2 == null ? null : n2.next, (v1 + v2 + c) /10);

            return node;
        }

        ListNode reverse(ListNode node) {
            if (node == null) return null;
            ListNode prev;
            ListNode cur;
            prev = node;
            cur = node.next;
            prev.next = null;
            while (cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}