//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge Sort
// 
// 👍 4639 👎 183


package q.q148;

import dataStructure.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode temp = slow.next;
            slow.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(temp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null){
                if (left.val > right.val){
                    h.next = right;
                    h = h.next;
                    right = right.next;
                } else {
                    h.next = left;
                    h = h.next;
                    left = left.next;
                }
            }

            h.next = left == null ? right : left;

            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}