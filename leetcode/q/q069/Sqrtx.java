//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and on
//ly the integer part of the result is returned. 
//
// Note: You are not allowed to use any built-in exponent function or operator, 
//such as pow(x, 0.5) or x ** 0.5. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part is
// truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics Math Binary Search 
// 👍 2282 👎 2503


package q.q069;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        solution.mySqrt(8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            int l = 1, r = x/2;

            while (l < r){
                int mid = l + (r - l + 1)/2;

                if (mid > x/mid) r = mid - 1;
                else l = mid;
            }

            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}