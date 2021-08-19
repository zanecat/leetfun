//You are visiting a farm that has a single row of fruit trees arranged from lef
//t to right. The trees are represented by an integer array fruits where fruits[i]
// is the type of fruit the ith tree produces. 
//
// You want to collect as much fruit as possible. However, the owner has some st
//rict rules that you must follow: 
//
// 
// You only have two baskets, and each basket can only hold a single type of fru
//it. There is no limit on the amount of fruit each basket can hold. 
// Starting from any tree of your choice, you must pick exactly one fruit from e
//very tree (including the start tree) while moving to the right. The picked fruit
//s must fit in one of your baskets. 
// Once you reach a tree with fruit that cannot fit in your baskets, you must st
//op. 
// 
//
// Given the integer array fruits, return the maximum number of fruits you can p
//ick. 
//
// 
// Example 1: 
//
// 
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.
// 
//
// Example 2: 
//
// 
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].
//If we had started at the first tree, we would only pick from trees [0,1].
// 
//
// Example 3: 
//
// 
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].
//If we had started at the first tree, we would only pick from trees [1,2].
// 
//
// Example 4: 
//
// 
//Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
//Output: 5
//Explanation: We can pick from trees [1,2,1,1,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= fruits.length <= 105 
// 0 <= fruits[i] < fruits.length 
// 
// Related Topics Array Hash Table Sliding Window 
// 👍 235 👎 12


package q.q904;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int l = 0, r = 0, len = fruits.length;
            int [] count = new int[len];
            int size = 0;
            int res = 0;

            while (r < len){
                int cur = fruits[r];
                if (size < 2){
                    if (count[cur] == 0){
                        size ++;
                    }
                } else {
                    if (count[cur] == 0){
                        while (size == 2){
                            count[fruits[l]]--;
                            if (count[fruits[l]] == 0){
                                size--;
                            }
                            l ++;
                        }
                        size ++;
                    }
                }

                if (res < r - l + 1) res = r - l + 1;
                count[cur]++;
                r ++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}