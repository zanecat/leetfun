//There are n flights that are labeled from 1 to n. 
//
// You are given an array of flight bookings bookings, where bookings[i] = [firs
//ti, lasti, seatsi] represents a booking for flights firsti through lasti (inclus
//ive) with seatsi seats reserved for each flight in the range. 
//
// Return an array answer of length n, where answer[i] is the total number of se
//ats reserved for flight i. 
//
// 
// Example 1: 
//
// 
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
// 
//
// Example 2: 
//
// 
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 104 
// 1 <= bookings.length <= 2 * 104 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 104 
// 
// Related Topics Array Prefix Sum 
// 👍 792 👎 131


package q.q1109;

public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
        solution.corpFlightBookings(new int[][]{{1,2,10}, {2,3,20}, {2,5,25}}, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int [] res = new int[n];

            for (var b: bookings){
                int start = b[0], end = b[1], seat = b[2];

                res[start - 1] += seat;
                if (end < n){
                    res[end] -= seat;
                }
            }

            for (int i = 1; i < n; i ++){
                res[i] += res[i - 1];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}