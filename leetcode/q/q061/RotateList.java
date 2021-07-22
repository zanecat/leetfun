//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics Linked List Two Pointers 
// 👍 2773 👎 1178


package q.q061;

import dataStructure.ListNode;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return null;

            ListNode fast = head, slow = head;
            if (head.next == null) return head;

            int i = 0;
            while (i < k){
                if (fast.next == null) {
                    fast.next = head;
                    k = k % (i + 1);
                    i = 0;
                    fast = head;
                    continue;
                }
                fast = fast.next;
                i ++;
            }

            while (fast.next != head && fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }

            fast.next = head;
            ListNode res = slow.next;
            slow.next = null;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}