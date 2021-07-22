//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge Sor
//t 
// 👍 7966 👎 369


package q.q023;

import dataStructure.ListNode;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }

        ListNode merge(ListNode[] lists, int l, int r){
            if (l == r) return lists[l];

            int mid = l + (r - l)/2;

            ListNode l1 = merge(lists, l, mid);
            ListNode l2 = merge(lists, mid + 1, r);

            return mergeTwo(l1, l2);
        }

        ListNode mergeTwo(ListNode l1, ListNode l2){
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode node = new ListNode();
            ListNode cur = node;

            while (l1 != null && l2 != null){
                if (l1.val > l2.val){
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }

                cur = cur.next;
            }

            if (l1 != null) cur.next = l1;
            if (l2 != null) cur.next = l2;

            return node.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}