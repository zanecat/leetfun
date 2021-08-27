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


package q.q084;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] h) {
            Stack<Integer> st = new Stack<>();

            int [] left = new int[h.length];
            st.push(-1);

            for (int i = 0; i < h.length; i ++){
                while (st.peek() != -1){
                    if (h[st.peek()] >= h[i]){
                        st.pop();
                    } else {
                        break;
                    }
                }

                left[i] = st.peek();
                st.push(i);
            }

            st = new Stack<>();
            st.push(h.length);
            int res = 0;
            for (int i = h.length - 1; i >= 0; i --){
                while (st.peek() != h.length){
                    if (h[st.peek()] >= h[i]){
                        st.pop();
                    } else {
                        break;
                    }
                }

                res = Math.max(res, (st.peek() - left[i] - 1) * h[i]);
                st.push(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}