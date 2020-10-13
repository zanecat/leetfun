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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
      if (root == null) return new ArrayList<>();
      HashMap<Integer, List<Integer>> res = new HashMap<>();
      helper(res, root, 0);
      List<List<Integer>> finalRes = new ArrayList<>(res.values());
      for(int i = 1; i < finalRes.size(); i+=2){
        Collections.reverse(finalRes.get(i));
      }
      return finalRes;
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