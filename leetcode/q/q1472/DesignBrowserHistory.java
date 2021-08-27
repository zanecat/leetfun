//You have a browser of one tab where you start on the homepage and you can visi
//t another url, get back in the history number of steps or move forward in the hi
//story number of steps. 
//
// Implement the BrowserHistory class: 
//
// 
// BrowserHistory(string homepage) Initializes the object with the homepage of t
//he browser. 
// void visit(string url) Visits url from the current page. It clears up all the
// forward history. 
// string back(int steps) Move steps back in history. If you can only return x s
//teps in the history and steps > x, you will return only x steps. Return the curr
//ent url after moving back in history at most steps. 
// string forward(int steps) Move steps forward in history. If you can only forw
//ard x steps in the history and steps > x, you will forward only x steps. Return 
//the current url after forwarding in history at most steps. 
// 
//
// 
// Example: 
//
// 
//Input:
//["BrowserHistory","visit","visit","visit","back","back","forward","visit","for
//ward","back","back"]
//[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],
//["linkedin.com"],[2],[2],[7]]
//Output:
//[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin
//.com","google.com","leetcode.com"]
//
//Explanation:
//BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
//browserHistory.visit("google.com");       // You are in "leetcode.com". Visit 
//"google.com"
//browserHistory.visit("facebook.com");     // You are in "google.com". Visit "f
//acebook.com"
//browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit 
//"youtube.com"
//browserHistory.back(1);                   // You are in "youtube.com", move ba
//ck to "facebook.com" return "facebook.com"
//browserHistory.back(1);                   // You are in "facebook.com", move b
//ack to "google.com" return "google.com"
//browserHistory.forward(1);                // You are in "google.com", move for
//ward to "facebook.com" return "facebook.com"
//browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit 
//"linkedin.com"
//browserHistory.forward(2);                // You are in "linkedin.com", you ca
//nnot move forward any steps.
//browserHistory.back(2);                   // You are in "linkedin.com", move b
//ack two steps to "facebook.com" then to "google.com". return "google.com"
//browserHistory.back(7);                   // You are in "google.com", you can 
//move back only one step to "leetcode.com". return "leetcode.com"
// 
//
// 
// Constraints: 
//
// 
// 1 <= homepage.length <= 20 
// 1 <= url.length <= 20 
// 1 <= steps <= 100 
// homepage and url consist of '.' or lower case English letters. 
// At most 5000 calls will be made to visit, back, and forward. 
// 
// Related Topics Array Linked List Stack Design Doubly-Linked List Data Stream 
//
// 👍 666 👎 71


package q.q1472;

import java.util.Stack;

public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory solution = new DesignBrowserHistory().new BrowserHistory("!2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class BrowserHistory {
        String cur;
        Stack<String> backs = new Stack<>();
        Stack<String> forth = new Stack<>();

        public BrowserHistory(String homepage) {
            cur = homepage;
        }

        public void visit(String url) {
            backs.push(cur);
            forth.clear();
            cur = url;
        }

        public String back(int steps) {
            int i = 0;

            while(i < steps && !backs.isEmpty()){
                forth.push(cur);
                cur = backs.pop();
                i ++;
            }

            return cur;
        }

        public String forward(int steps) {
            int i = 0;

            while(i < steps && !forth.isEmpty()){
                backs.push(cur);
                cur = forth.pop();
                i++;
            }

            return cur;
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)

}