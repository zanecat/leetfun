//Given the root of a binary tree and an integer targetSum, return the number of
// paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -109 <= Node.val <= 109 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 5536 👎 327


package q.q437;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3), n4 = new TreeNode(4);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        solution.pathSum(n1, 3);
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
        int res = 0;
        int tar = 0;
        Map<Integer, Integer> sums = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            sums.put(0, 1);
            tar = targetSum;
            my(root, 0);

            return res;
        }

        void my(TreeNode node, int sum){
            if (node == null) return;

            int newSum = sum + node.val;
            res += sums.getOrDefault(newSum - tar, 0);
            sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);
            my(node.left, newSum);
            my(node.right, newSum);
            sums.put(newSum, sums.getOrDefault(newSum, 0) - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}