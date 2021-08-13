//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// Implement the MinStack class: 
//
// 
// MinStack() initializes the stack object. 
// void push(val) pushes the element val onto the stack. 
// void pop() removes the element on the top of the stack. 
// int top() gets the top element of the stack. 
// int getMin() retrieves the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// -231 <= val <= 231 - 1 
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks. 
// At most 3 * 104 calls will be made to push, pop, top, and getMin. 
// 
// Related Topics Stack Design 
// 👍 5419 👎 492


package q.q155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class MinStack1 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Deque<Integer> st = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;


        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int val) {
            if (val <= min ){
                st.push(min);
                min = val;
            }
            st.push(val);
        }

        public int pop() {
            int top = st.pop();

            if (top == min) min = st.pop();
            return top;
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}