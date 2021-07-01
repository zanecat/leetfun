//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 5024 👎 7609


package q.q007;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(1 << 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long tar = 0;
//            int neg = x > 0 ? 1 : -1;

            for (long i = 10; x !=0 ; ){
                tar *= 10;
                long cur = x%i;
                tar += cur;
                x = x/10;
            }

//            tar = tar * neg;
            if (tar > Integer.MAX_VALUE || tar < Integer.MIN_VALUE ) return 0;
            return (int)tar;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}