//Two elements of a binary search tree (BST) are swapped by mistake. 
//
// Recover the tree without changing its structure. 
//
// Example 1: 
//
// 
//Input: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//Output: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// Example 2: 
//
// 
//Input: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//Output: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
// 
//
// Follow up: 
//
// 
// A solution using O(n) space is pretty straight forward. 
// Could you devise a constant space solution? 
// 
// Related Topics Tree Depth-first Search 
// 👍 1811 👎 79

  
package q.q99;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree{
  public static void main(String[] args) {
    Solution solution = new RecoverBinarySearchTree().new Solution();
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
    public void recoverTree(TreeNode root) {
      if(root == null) return;
      ArrayDeque<TreeNode> stack = new ArrayDeque<>();
      List<TreeNode> inOrder = new ArrayList<>();

      TreeNode current = root;

      while (current != null || !stack.isEmpty()){
        while (current != null){
          stack.push(current);
          current = current.left;
        }
        if(!stack.isEmpty()){
          current = stack.pop();
          inOrder.add(current);
          current = current.right;
        }
      }

      int t1 = -1;
      int t2 = -1;

      for (int i = 1; i < inOrder.size(); i ++){
        if(inOrder.get(i).val < inOrder.get(i-1).val){
          if(t1 == -1) t1 = i;
          else t2 = i;
        }
      }

      int tmp;
      if(t2 == -1){
        tmp = inOrder.get(t1).val;
        inOrder.get(t1).val = inOrder.get(t1 - 1).val;
        inOrder.get(t1 - 1).val = tmp;
      } else {
        tmp = inOrder.get(t1 - 1).val;
        inOrder.get(t1 - 1).val = inOrder.get(t2).val;
        inOrder.get(t2).val = tmp;
      }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}