//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 1858 👎 765

  
package q.q111;

import dataStructure.TreeNode;

import java.util.ArrayDeque;

public class MinimumDepthOfBinaryTree{
  public static void main(String[] args) {
    Solution solution = new MinimumDepthOfBinaryTree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                if (node.left != null) {
                    q.addLast(node.left);
                    if (node.right != null) {
                        q.addLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        q.addLast(node.right);
                    } else {
                        return depth;
                    }
                }
            }

            depth++;
        }


        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}