//You are given a list of airline tickets where tickets[i] = [fromi, toi] repres
//ent the departure and the arrival airports of one flight. Reconstruct the itiner
//ary in order and return it. 
//
// All of the tickets belong to a man who departs from "JFK", thus, the itinerar
//y must begin with "JFK". If there are multiple valid itineraries, you should ret
//urn the itinerary that has the smallest lexical order when read as a single stri
//ng. 
//
// 
// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["
//JFK", "LGB"]. 
// 
//
// You may assume all tickets form at least one valid itinerary. You must use al
//l the tickets once and only once. 
//
// 
// Example 1: 
//
// 
//Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//Output: ["JFK","MUC","LHR","SFO","SJC"]
// 
//
// Example 2: 
//
// 
//Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["AT
//L","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL"
//,"SFO"] but it is larger in lexical order.
// 
//
// 
// Constraints: 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi and toi consist of uppercase English letters. 
// fromi != toi 
// 
// Related Topics Depth-First Search Graph Eulerian Circuit 
// 👍 3141 👎 1397


package q.q332;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            Map<String, PriorityQueue<String>> map = new HashMap<>();
            List<String> res = new ArrayList<>();
        public List<String> findItinerary(List<List<String>> tickets) {

            for (List<String> pair : tickets){
                String from = pair.get(0), to = pair.get(1);
                if (!map.containsKey(from)){
                    map.put(from, new PriorityQueue<>());
                }
                map.get(from).offer(to);
            }

            dfs("JFK");

            return res;
        }

        void dfs(String from){
            while (map.containsKey(from) && map.get(from).size() > 0)
            {
                var temp = map.get(from).poll();
                dfs(temp);
            }
            res.add(0, from);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}