//Given n orders, each order consist in pickup and delivery services. 
//
// Count all valid pickup/delivery possible sequences such that delivery(i) is a
//lways after of pickup(i). 
//
// Since the answer may be too large, return it modulo 10^9 + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 1
//Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 6
//Explanation: All possible orders: 
//(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and 
//(P2,D2,P1,D1).
//This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2
//.
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: 90
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 500 
// 
// Related Topics Math Dynamic Programming Combinatorics 
// 👍 383 👎 45

  
  package q.q1359;
  public class CountAllValidPickupAndDeliveryOptions{
      public static void main(String[] args) {
           Solution solution = new CountAllValidPickupAndDeliveryOptions().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          int mod = 1000000007;

          public int countOrders(int n) {
              long last = 1;

              for(int i = 2; i < n + 1; i ++){
                  long slots = (i - 1) * 2 + 1;

                  long possible = ((slots + 1)) * slots  / 2 * last;

                  last = possible % mod;
              }

              return (int)last;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }