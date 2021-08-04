//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics Tree Depth-first Search 
// 👍 2684 👎 184


package q.q110;

import dataStructure.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            int res = my(root);

            return res != -1;
        }

        int my(TreeNode node) {
            if (node == null) return 0;

            int left = my(node.left);
            if (left == -1) return -1;

            int right = my(node.right);
            if (right == -1) return -1;

            int diff = Math.abs(left - right);
            if (diff < 2) return Math.max(right, left) + 1;
            else return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}