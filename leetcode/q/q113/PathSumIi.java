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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> visited) {
        if (root == null) return;
        visited.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(visited));
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, ans, visited);
            //remove root.left
            visited.remove(visited.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, ans, visited);
            //remove root.right
            visited.remove(visited.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}