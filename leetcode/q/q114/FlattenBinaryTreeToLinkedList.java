//Given a binary tree, flatten it to a linked list in-place. 
//
// For example, given the following tree: 
//
// 
//    1
//   / \
//  2   5
// / \   \
//3   4   6
// 
//
// The flattened tree should look like: 
//
// 
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// 
// Related Topics Tree Depth-first Search 
// 👍 3407 👎 367


package q.q114;

import dataStructure.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left=node3;
        solution.flatten(node1);
        System.out.println(node1);
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
        public void flatten(TreeNode root) {
            if(root == null) return;

            flatten(root.left);
            flatten(root.right);
            TreeNode rightMost = getRightMost(root.left);
            if(rightMost != null){
                rightMost.right = root.right;
                root.right = root.left;
                root.left =null;
            }
        }

        TreeNode getRightMost(TreeNode node){
            if(node == null) return null;
            System.out.println(node.val);
            TreeNode cur = node;
            while (cur.right != null){
                cur = cur.right;
            }

            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}