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
            int[] ans = new int [n+1];

            if(n == 1) return 1;
            if(n == 2) return 1;
            if(n == 3) return 2;
            if(n == 4) return 4;
            ans[1] = 1;
            ans[2] = 2;
            ans[3] = 3;
            ans[4] = 4;

            for(int i = 5; i < n + 1; i ++){
                ans[i] = ans[i-3] * 3;
            }

            return ans[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}