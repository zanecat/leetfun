//Given a binary tree, imagine yourself standing on the right side of it, return
// the values of the nodes you can see ordered from top to bottom. 
//
// Example: 
//
// 
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// Related Topics Tree Depth-first Search Breadth-first Search 
// 👍 3064 👎 167


package q.q199;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        List<Integer> levels = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<>();
            helper(0, root);

            return res;
        }

        void helper(int lv, TreeNode node){
            if(node == null) return;

            boolean isFirst = !levels.contains(lv);

            if(isFirst) {
                res.add(node.val);
                levels.add(lv);
            }

            helper(lv + 1, node.right);
            helper(lv + 1, node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}