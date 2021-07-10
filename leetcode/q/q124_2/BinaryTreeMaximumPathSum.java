//A path in a binary tree is a sequence of nodes where each pair of adjacent nod
//es in the sequence has an edge connecting them. A node can only appear in the se
//quence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 
// 👍 6282 👎 419


package q.q124_2;

import dataStructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
        int res;
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            res = root.val;
            my(root);
            return res;
        }

        int my(TreeNode node){
            if (node == null) return 0;
            int sumL = my(node.right);
            int sumR = my(node.left);
            int sum = node.val;
            int larger = Math.max(sumL, sumR);
            res = Math.max(node.val, res);

            if (sumL > 0){
                sum += sumL;
            }

            if (sumR > 0){
                sum += sumR;
            }

            res = Math.max(sum, res);

            if (larger + node.val > 0) {
                return larger + node.val;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}