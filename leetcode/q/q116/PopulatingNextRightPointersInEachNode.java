//You are given a perfect binary tree where all leaves are on the same level, an
//d every parent has two children. The binary tree has the following definition: 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no ne
//xt right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
//
// Follow up: 
//
// 
// You may only use constant extra space. 
// Recursive approach is fine, you may assume implicit stack space does not coun
//t as extra space for this problem. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function sho
//uld populate each next pointer to point to its next right node, just like in Fig
//ure B. The serialized output is in level order as connected by the next pointers
//, with '#' signifying the end of each level.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is less than 4096. 
// -1000 <= node.val <= 1000 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 3931 👎 177


package q.q116;

import dataStructure.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Deque<Node> st1 = new ArrayDeque<>();
            Deque<Node> st2 = new ArrayDeque<>();

            boolean use1 = true;

            st1.add(root);

            while (!st1.isEmpty() || !st2.isEmpty()){
                if (use1){
                    while (!st2.isEmpty()){
                        Node n = st2.poll();
                        n.next = st2.peek();

                        if (n.left != null) st1.add(n.left);
                        if (n.right != null) st1.add(n.right);
                    }
                    use1 = false;
                } else {
                    while (!st1.isEmpty()){
                        Node n = st1.poll();
                        n.next = st1.peek();

                        if (n.left != null) st2.add(n.left);
                        if (n.right != null) st2.add(n.right);
                    }
                    use1 = true;
                }
            }

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}