//We have n jobs, where every job is scheduled to be done from startTime[i] to e
//ndTime[i], obtaining a profit of profit[i]. 
//
// You're given the startTime, endTime and profit arrays, return the maximum pro
//fit you can take such that there are no two jobs in the subset with overlapping 
//time range. 
//
// If you choose a job that ends at time X you will be able to start another job
// that starts at time X. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
// 
//
// Example 2: 
//
// 
//
// 
//Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70
//,60]
//Output: 150
//Explanation: The subset chosen is the first, fourth and fifth job. 
//Profit obtained 150 = 20 + 70 + 60.
// 
//
// Example 3: 
//
// 
//
// 
//Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 104 
// 1 <= startTime[i] < endTime[i] <= 109 
// 1 <= profit[i] <= 104 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 
// 👍 1799 👎 19


package q.q1235;

import java.util.*;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        Solution solution = new MaximumProfitInJobScheduling().new Solution();
        solution.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class jobs{
            int start,end,profit;
            jobs(int s,int e,int p){
                start=s;
                end=e;
                profit=p;
            }
        }

        public int jobScheduling(int[] s, int[] e, int[] p) {
            List<int[]> times = new ArrayList<>();
            for (int i = 0; i < s.length; i ++){
                times.add(new int[]{s[i], e[i], p[i]});
            }

            // 0 -> start
            // 1 -> end
            // 2 -> profit

            times.sort(Comparator.comparingInt(l -> l[1]));

            int [] dp = new int[s.length];
            dp[0] = times.get(0)[2];

            for (int i = 1; i < s.length; i ++){
                dp[i] = Math.max(dp[i - 1], times.get(i)[2]);

                for (int j = i - 1; j >= 0; j --){
                    if (times.get(j)[1] <= times.get(i)[0]){
                        dp[i] = Math.max(dp[i], dp[j] + times.get(i)[2]);
                        break;
                    }
                }
            }

            return dp[s.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}