//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may b
//e changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
//
// 
//Follow-up: Can you solve the problem in O(1) extra memory space? Related Topic
//s Linked List Recursion 
// 👍 4101 👎 412


package q.q025;

import dataStructure.ListNode;

import java.util.Stack;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        solution.reverseKGroup(n1, 2);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            return reverse(head, k);
        }

        public ListNode reverse(ListNode node, int count){
            Stack<ListNode> st = new Stack<>();
            ListNode cur = node;
            int k = count;

            while (count > 0 && cur != null){
                st.push(cur);
                cur = cur.next;
                count --;
            }

            if (count == 0 && !st.empty()){
                ListNode res = st.pop();
                ListNode next = res;
                while (!st.empty()){
                    next.next = st.pop();
                    next = next.next;
                }
                next.next = reverse(cur, k);
                return res;
            } else {
                return node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}