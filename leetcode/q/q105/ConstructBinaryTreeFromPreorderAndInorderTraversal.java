//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 716 👎 0

  
package q.q105;

import dataStructure.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
  public static void main(String[] args) {
    Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
//    TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    TreeNode treeNode = solution.buildTree(new int[]{3,2,1,4}, new int[]{1,2,3,4});
    System.out.println(treeNode);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0){
        return null;
      }

      TreeNode node = new TreeNode(preorder[0]);

      int index_mid_in = -1;

      for (int i =0; i < inorder.length; i ++){
        if(inorder[i] == preorder[0]){
          index_mid_in = i;
        }
      }

      node.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index_mid_in), Arrays.copyOfRange(inorder, 0, index_mid_in));
      node.right = buildTree(Arrays.copyOfRange(preorder, 1 + index_mid_in, preorder.length), Arrays.copyOfRange(inorder, index_mid_in + 1, preorder.length));

      return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}