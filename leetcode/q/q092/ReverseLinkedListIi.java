//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 
// 👍 4370 👎 223


package q.q092;

import dataStructure.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        solution.reverseBetween(n1, 1, 2);
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode dum = new ListNode();
            dum.next = head;
            prev = dum;

            int i = 1;

            while (i != left){
                prev = cur;
                cur = cur.next;
                i ++;
            }

            ListNode preL = prev;
            ListNode le = cur;

            while (i - 1 != right){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                i ++;
            }

            ListNode nextR = cur, ri = prev;

            preL.next = ri;
            le.next = nextR;

            return dum.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}