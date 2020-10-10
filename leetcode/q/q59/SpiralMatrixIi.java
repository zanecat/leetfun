//Given a positive integer n, generate a square matrix filled with elements from
// 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics 数组 
// 👍 246 👎 0


package q.q59;

public class SpiralMatrixIi {
  public static void main(String[] args) {
    Solution solution = new SpiralMatrixIi().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] generateMatrix(int n) {
      if(n == 0) return new int[0][];
      int [][] res = new int[n][];

      int aa = n;
      while(aa-- > 0){
        res[aa] = new int[n];
      }

      int b = 1;

      int up = 0, down = n, left = 0, right = n;
      int cnt = 0;
      while (up<down && left<right){
        if(cnt%4 == 0){
          for (int i = left; i < right; i ++){
            res[up][i] = b++;
          }

          up++;
        }

        if(cnt%4 == 1){
          for(int i = up; i < down; i++){
            res[i][right-1] = b++;
          }

          right--;
        }

        if(cnt%4 == 2){
          if(right >= 1){
            for (int i = right - 1; i>= left; i--){
              res[down-1][i] = b++;
            }
          }
          down --;
        }

        if(cnt%4 == 3){
          if(down >= 1){
            for (int i = down - 1; i>=up; i--){
              res[i][left] = b++;
            }
          }

          left++;
        }

        cnt ++;
      }

      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}