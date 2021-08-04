//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 2196 👎 77

  
package q.q113;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi{
  public static void main(String[] args) {
    Solution solution = new PathSumIi().new Solution();
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
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        my(new LinkedList<>(), targetSum, root);

        return res;
    }

    void my(List<Integer> list, int target, TreeNode node){
        if (node == null) return;
        list.add(node.val);
        if (node.right == null && node.left == null && node.val == target){

            res.add(new ArrayList<>(list));

        } else {
            if (node.left != null){
                my(list, target - node.val, node.left);
            }

            if (node.right != null){
                my(list, target - node.val, node.right);
            }
        }

        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}