//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Note: Assume we are dealing with an environment that could only store integer
//s within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, ass
//ume that your function returns 231 − 1 when the division result overflows. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Example 3: 
//
// 
//Input: dividend = 0, divisor = 1
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: dividend = 1, divisor = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics Math Bit Manipulation 
// 👍 2023 👎 7448


package q.q029;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println((1 << 31 )- 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

            int neg = 1;
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) neg = -1;

            dividend = dividend > 0 ? -1 * dividend : dividend;
            divisor = divisor > 0 ? -1 * divisor : divisor;

            return neg * my(dividend, divisor);
        }

        int my(int n1, int n2){
            if (n1 > n2) return 0;
            int count = 1;
            int cur = n2;

            while (n1 < cur + cur && cur + cur < 0){
                cur = cur + cur;
                count += count;
            }

            return count + my(n1 - cur, n2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}