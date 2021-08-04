//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// A height-balanced binary tree is a binary tree in which the depth of the two 
//subtrees of every node never differs by more than one. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree 
// 👍 4566 👎 298


package q.q108;

import dataStructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;

            return my(nums, 0, nums.length - 1);
        }

        TreeNode my(int [] nums, int l, int r){
            if (l == r) return new TreeNode(nums[l]);
            if (l > r) return null;
            int mid = l + (r - l >> 1);
            TreeNode node = new TreeNode(nums[mid]);

            node.left = my(nums, l, mid - 1);
            node.right = my(nums, mid + 1, r);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}