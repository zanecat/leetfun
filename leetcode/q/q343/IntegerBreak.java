//Given a positive integer n, break it into the sum of at least two positive int
//egers and maximize the product of those integers. Return the maximum product you
// can get. 
//
// Example 1: 
//
// 
// 
//Input: 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1. 
//
// 
// Example 2: 
//
// 
//Input: 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36. 
//
// Note: You may assume that n is not less than 2 and not larger than 58. 
// 
// Related Topics Math Dynamic Programming 
// 👍 1284 👎 238


package q.q343;

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;

            int rest = n % 3;
            int threes = n / 3;


            if (rest == 1){
                threes --;
                rest = 4;
            }

            if (rest == 0){
                rest = 1;
            }


            for (int i = 0; i < threes; i ++){
                rest *= 3;
            }

            return rest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}