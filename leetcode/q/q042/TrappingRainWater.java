//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 12214 👎 174


package q.q042;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int lHi = 0;
            int [] lHs = new int[height.length];
            for (int i = 0; i < height.length; i ++){
                lHs[i] = lHi;
                lHi = Math.max(height[i], lHi);
            }

            int rHi = 0;
            int [] rHs = new int[height.length];
            for (int i = height.length -1; i >= 0; i --){
                rHs[i] = rHi;
                rHi = Math.max(height[i], rHi);
            }

            int res = 0;
            for (int i = 0; i < height.length; i ++) {
                if(lHs[i] > height[i] && rHs[i] > height[i]){
                    res += Math.min(lHs[i], rHs[i]) - height[i];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}