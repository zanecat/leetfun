//Given a string s, determine if it is a palindrome, considering only alphanumer
//ic characters and ignoring cases. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 105 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 
// 👍 2289 👎 4144


package q.q125_2;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            String news = s.toLowerCase();

            while (l <= r){
                while (l < r && !Character.isLetterOrDigit(news.charAt(l))) l ++;
                while (l < r && !Character.isLetterOrDigit(news.charAt(r))) r --;

                if (news.charAt(l) != news.charAt(r)) return false;
                l ++;
                r --;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}