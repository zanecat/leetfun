//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 511 👎 0

  
package q.q54;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{
  public static void main(String[] args) {
    Solution solution = new SpiralMatrix().new Solution();
    int [][] test = new int[3][];
    test[0] = new int[] {1,2,3};
    test[1] = new int[] {4,5,6};
    test[2] = new int[] {7,8,9};
    System.out.println(solution.spiralOrder(test));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] mx) {
      LinkedList<Integer> res = new LinkedList<>();

      if (mx.length == 0){
        return res;
      }

      int up = 0, down = mx.length, left = 0, right = mx[0].length;
      int cnt = 0;
      while (up<down && left<right){
        if(cnt%4 == 0){
          for (int i = left; i < right; i ++){
            res.add(mx[up][i]);
          }

          up++;
        }

        if(cnt%4 == 1){
          for(int i = up; i < down; i++){
            res.add(mx[i][right-1]);
          }

          right--;
        }

        if(cnt%4 == 2){
          if(right >= 1){
            for (int i = right - 1; i>= left; i--){
              res.add(mx[down-1][i]);
            }
          }
          down --;
        }

        if(cnt%4 == 3){
          if(down >= 1){
            for (int i = down - 1; i>=up; i--){
              res.add(mx[i][left]);
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