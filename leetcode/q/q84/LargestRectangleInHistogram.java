//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack 
// 👍 4490 👎 93


package q.q84;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            int [] left = new int[len];
            int [] right = new int[len];



            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < len; i ++){
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }

                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = len - 1; i >= 0; i --){
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }

                right[i] = stack.isEmpty() ? len : stack.peek();
                stack.push(i);
            }

            int result = 0;
            for (int i = 0; i < len; i ++){
                result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}