//In an infinite binary tree where every node has two children, the nodes are la
//belled in row order. 
//
// In the odd numbered rows (ie., the first, third, fifth,...), the labelling is
// left to right, while in the even numbered rows (second, fourth, sixth,...), the
// labelling is right to left. 
//
// 
//
// Given the label of a node in this tree, return the labels in the path from th
//e root of the tree to the node with that label. 
//
// 
// Example 1: 
//
// 
//Input: label = 14
//Output: [1,3,4,14]
// 
//
// Example 2: 
//
// 
//Input: label = 26
//Output: [1,2,6,10,26]
// 
//
// 
// Constraints: 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics Math Tree Binary Tree 
// 👍 737 👎 211


package q.q1104;

import java.util.*;

public class PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        solution.pathInZigZagTree(16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            LinkedList<Integer> res = new LinkedList<>();

            int pow = 1;
            boolean ltr = true;

            while (pow < label){
                pow = pow * 2 + 1;
                ltr = !ltr;
            }

            int pos;
            if (ltr){
                pos = pow/2  - (pow - label);
            } else {
                pos = pow - label;
            }

            while (pow > 0){
                if (ltr){
                    res.push(pow/2 + pos + 1);
                } else {
                    res.push(pow - pos);
                }

                pos /= 2;
                ltr = !ltr;
                pow = pow/2;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}