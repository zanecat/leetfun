//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 280 👎 0

  
package q.q103;

import dataStructure.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal{
  public static void main(String[] args) {
    Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;

      LinkedList<TreeNode> st1 = new LinkedList<>();
      LinkedList<TreeNode> st2 = new LinkedList<>();
      Deque<Integer> row;

      boolean use1 = false;
      st1.push(root);

      while (!st1.isEmpty() || !st2.isEmpty()){
        row = new LinkedList<>();
        if (use1){
          while (!st2.isEmpty()){
            TreeNode cur = st2.pop();
            row.push(cur.val);
            if (cur.left != null) st1.offer(cur.left);
            if (cur.right != null) st1.offer(cur.right);
          }
          res.add(new LinkedList<>(row));
          use1 = false;
        } else {
          while (!st1.isEmpty()){
            TreeNode cur = st1.pop();
            row.offer(cur.val);
            if (cur.left != null) st2.offer(cur.left);
            if (cur.right != null) st2.offer(cur.right);
          }
          res.add(new LinkedList<>(row));
          use1 = true;
        }
      }

      return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}