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
        int[] inorder;
        int[] postorder;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;

            TreeNode node = helper(0, inorder.length, 0, inorder.length);
            return node;
        }

        TreeNode helper(int in_start, int in_end, int p_start, int p_end){
            if(in_end <= in_start || p_end <= p_start) return null;
            int mid_val = postorder[p_end - 1];
            TreeNode node = new TreeNode(mid_val);
            int mid_in = findIndex(inorder, mid_val);

            node.left = helper(in_start, mid_in, p_start, p_start + mid_in - in_start);
            node.right = helper(mid_in + 1, in_end, p_start + mid_in - in_start, p_start + mid_in - in_start + in_end - mid_in - 1);
            return node;
        }

        int findIndex(int [] nums, int tar){
            for (int i = 0; i < nums.length; i ++){
                if(nums[i] == tar){
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}