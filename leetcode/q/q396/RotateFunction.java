//
//Given an array of integers A and let n to be its length.
// 
//
// 
//Assume Bk to be an array obtained by rotating the array A k positions clock-wi
//se, we define a "rotation function" F on A as follow:
// 
//
// 
//F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]. 
//
// Calculate the maximum value of F(0), F(1), ..., F(n-1). 
// 
//
// Note: 
//n is guaranteed to be less than 105.
// 
//
// Example:
// 
//A = [4, 3, 2, 6]
//
//F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
//F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
//F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
//F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
//
//So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
// 
// Related Topics 数学 
// 👍 55 👎 0


package q.q396;

public class RotateFunction {
  public static void main(String[] args) {
    Solution solution = new RotateFunction().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int maxRotateFunction(int[] A) {

      if(A.length <= 1){
        return 0;
      }

      int sum = 0;
      int f1 = 0;
      for(int i = 0; i < A.length; i++){
        sum+=A[i];
        f1+=A[i]*i;
      }

      int ans = f1;
      int f2;

      for(int i = 1; i < A.length; i++){
        f2 = f1 + sum - A[A.length - i]* A.length;
        ans = Math.max(ans, f2);
        f1 = f2;
      }

      return ans;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}