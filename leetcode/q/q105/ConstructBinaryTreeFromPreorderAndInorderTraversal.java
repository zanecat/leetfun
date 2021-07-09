//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 5897 👎 144


package q.q105;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{1,2,3}, new int[]{2,3,1});
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
        int[] pre = null;
        int[] in = null;
        Map<Integer, Integer> index;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            pre = preorder;
            in = inorder;
            index = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                index.put(inorder[i], i);
            }

            return myf(0, 0, in.length - 1);
        }

        TreeNode myf(int rootOfPre, int l, int r) {
            if (l > r ) return null;
            TreeNode root = new TreeNode(pre[rootOfPre]);
            if (l == r) return root;

            int i = index.get(pre[rootOfPre]);
            root.left = myf(rootOfPre+1, l, i - 1);
            root.right = myf(rootOfPre+1 + i - l, i + 1, r);

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}