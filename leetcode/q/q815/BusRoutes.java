//You are given an array routes representing bus routes where routes[i] is a bus
// route that the ith bus repeats forever. 
//
// 
// For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in
// the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever. 
// 
//
// You will start at the bus stop source (You are not on any bus initially), and
// you want to go to the bus stop target. You can travel between bus stops by buse
//s only. 
//
// Return the least number of buses you must take to travel from source to targe
//t. Return -1 if it is not possible. 
//
// 
// Example 1: 
//
// 
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then t
//ake the second bus to the bus stop 6.
// 
//
// Example 2: 
//
// 
//Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
// 12
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// All the values of routes[i] are unique. 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 
// 
// Related Topics Array Hash Table Breadth-First Search 
// 👍 1346 👎 40


package q.q815;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        Solution solution = new BusRoutes().new Solution();
        solution.numBusesToDestination(new int[][]{{1,2,7}, {3,6,7}}, 1, 6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;

            Map<Integer, Set<Integer>> stopAndRoutes = new HashMap<>();
            Map<Integer, Integer> routeAndCount = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < routes.length; i++){
                for(int stop : routes[i]){
                    Set<Integer> rts = stopAndRoutes.getOrDefault(stop, new HashSet<>());
                    rts.add(i);
                    stopAndRoutes.put(stop, rts);

                    if(stop == source){
                        queue.add(i);
                        routeAndCount.put(i, 1);
                    }
                }
            }

            while(!queue.isEmpty()){
                int rt = queue.poll();
                int [] stops = routes[rt];
                int count = routeAndCount.get(rt);

                for(int s: stops){
                    if(s == target) return count;
                    Set<Integer> rts = stopAndRoutes.get(s);

                    if(rts != null){
                        for(int r: rts){
                            if(!routeAndCount.containsKey(r)){
                                queue.add(r);
                                routeAndCount.put(r, count + 1);
                            }
                        }
                    }
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}