//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search 
// 👍 2144 👎 41


package q.q106;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{1,2,3, 4}, new int[]{1,4,3,2}));
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
        Map<Integer, Integer> pos;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            pos = new HashMap<>();
            for (int i = 0; i < inorder.length; i ++){
                pos.put(inorder[i], i);
            }
            return getTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        TreeNode getTree(int [] inorder, int l1, int r1, int[] postorder, int l2, int r2){
            if (l1 == r1) return new TreeNode(inorder[l1]);
            if (l1 > r1) return null;
            int val = postorder[r2];
            int indexInInorder = pos.get(val);

            TreeNode node = new TreeNode(val);

            node.left = getTree(inorder, l1, indexInInorder - 1, postorder, l2, l2 + indexInInorder - l1 - 1);
            node.right = getTree(inorder, indexInInorder + 1, r1, postorder, l2 + indexInInorder - l1 - 1 + 1, r2 - 1);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}