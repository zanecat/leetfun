//Given a string s containing only digits, return all possible valid IP addresse
//s that can be obtained from s. You can return them in any order. 
//
// A valid IP address consists of exactly four integers, each integer is between
// 0 and 255, separated by single dots and cannot have leading zeros. For example,
// "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.
//168.1.312" and "192.168@1.1" are invalid IP addresses. 
//
// 
// Example 1: 
// Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// Example 2: 
// Input: s = "0000"
//Output: ["0.0.0.0"]
// Example 3: 
// Input: s = "1111"
//Output: ["1.1.1.1"]
// Example 4: 
// Input: s = "010010"
//Output: ["0.10.0.10","0.100.1.0"]
// Example 5: 
// Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3000 
// s consists of digits only. 
// 
// Related Topics String Backtracking 
// 👍 1945 👎 586


package q.q093;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new LinkedList<>();
        String s;
        public List<String> restoreIpAddresses(String s) {
            this.s = s;
            bt(0, new ArrayList<>());
            return res;
        }

        void bt(int start, List<String> list){
            if (start > s.length() || list.size() > 4 || (s.length() - start > 3 * (4 - list.size()))) return;

            if (start == s.length()){
                if (list.size() == 4){
                    res.add(String.join(".", list));
                }
                return;
            }

            if (s.charAt(start) == '0'){
                List<String> l1 = new ArrayList<>(list);
                l1.add("0");
                bt(start + 1, l1);
                return;
            }

            for (int i = 1; i <= 3 && i + start <= s.length(); i ++){
                List<String> l1 = new ArrayList<>(list);

                if (ok(start, start + i)){
                    l1.add(s.substring(start, start + i));
                    bt(start + i, l1);
                }
            }
        }

        boolean ok(int l, int r){
            String v = s.substring(l, r);
            int i = Integer.parseInt(v);
            return i <= 255 && i >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}