//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
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
// Related Topics Linked List Math Recursion 
// 👍 12472 👎 2873


package q.q002;

import dataStructure.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
            return addNode(l1, l2, 0);
        }

        ListNode addNode(ListNode n1, ListNode n2, int more){
            ListNode curr = new ListNode();

            if(n1 == null && n2 == null){
                if (more == 0) return null;
                if (more == 1) {
                    curr.val = 1;
                    return curr;
                }
            }
            if (n1 == null){
                curr.val = (n2.val + more)%10;

                curr.next = addNode(null, n2.next, (n2.val + more)/10);
            } else if (n2 == null) {
                curr.val = (n1.val + more)%10;

                curr.next = addNode(n1.next, null, (n1.val + more)/10);
            } else {
                curr.val = (n1.val + n2.val + more)%10;

                curr.next = addNode(n1.next, n2.next, (n1.val + n2.val + more)/10);
            }

            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}