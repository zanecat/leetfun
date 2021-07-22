//Implement pow(x, n), which calculates x raised to the power n (i.e., xn). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics Math Recursion 
// 👍 2724 👎 4048


package q.q050;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        solution.myPow(2.0, -2147483648);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n == -1) return 1.0/x;

            double cur = myPow(x, n/2);

            int add = n%2;
            return cur * cur * myPow(x, add);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}