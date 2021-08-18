//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 6153 👎 462


package q.q234;

import dataStructure.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) return true;
            ListNode fast = head;
            ListNode slow = head;

            while (fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode half = reverse(slow.next);

            ListNode start = head;

            while (half != null && start != null){
                if (half.val != start.val) return false;

                half = half.next;
                start = start.next;
            }

            return true;
        }

        ListNode reverse(ListNode node){
            ListNode prev = null;
            ListNode cur = node;

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