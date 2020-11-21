//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
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
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 666 👎 0


package q.q102;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) return new ArrayList<>();
      HashMap<Integer, List<Integer>> res = new HashMap<>();
      helper(res, root, 0);
      return new ArrayList<>(res.values());
    }

    void helper(HashMap<Integer, List<Integer>> res, TreeNode node, int lv) {
      if (node != null) {
        List<Integer> tmp = res.getOrDefault(lv, new ArrayList<>());
        tmp.add(node.val);
        res.put(lv, tmp);

        helper(res, node.left, lv + 1);
        helper(res, node.right, lv + 1);
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}